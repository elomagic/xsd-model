/*
 * XSD Model (Java 17 with Jakarta XML Binding 4.0)
 * Copyright (c) 2017-present Carsten Rambow
 * mailto:developer AT elomagic DOT de
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.elomagic.xsdmodel.converter;

import jakarta.xml.bind.JAXBException;

import de.elomagic.xsdmodel.XsdReader;
import de.elomagic.xsdmodel.elements.*;
import de.elomagic.xsdmodel.elements.extention.XsdNodeInfo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Very <b>experimental</b> small tooling class to map a simple XSD into a key properties map.
 * <p>
 */
public class Xsd2KeyValueConverter<T extends KeyProperties> {

    // TODO Use namespace prefix from XSD
    private final String namespace = "xs:";
    private XsdReader reader = new XsdReader();
    private String keyDelimiter = ".";
    private boolean attributeSupport = true;
    private String attributeDelimiter = "#";
    private Supplier<T> keyPropertySupplier = () -> (T) new KeyProperties();
    private boolean restrictionSupport = true;

    final Map<String, XsdSimpleType> resolvedSimpleTypes = new HashMap<>();
    final Map<String, XsdComplexType> resolvedComplexTypes = new HashMap<>();

    /**
     * Create an instance with default {@link KeyProperties} supplier.
     */
    public Xsd2KeyValueConverter() {
    }

    /**
     * Create an instance with an alternative {@link KeyProperties} {@link Supplier}.
     */
    public Xsd2KeyValueConverter(@NotNull Supplier<T> keyPropertySupplier) {
        this.keyPropertySupplier = keyPropertySupplier;
    }

    /**
     * Returns the current XSD reader instance.
     *
     * @return Returns the current XSD reader instance
     */
    @NotNull
    public XsdReader getReader() {
        return reader;
    }

    /**
     * Sets an alternative XSD reader instance.
     *
     * @param reader Alternative XSD reader instance.
     * @return Returns this instance
     */
    public Xsd2KeyValueConverter<T> setReader(@NotNull XsdReader reader) {
        this.reader = reader;
        return this;
    }

    /**
     * Returns delimiters string
     * <p>
     * Default "." (Dot)
     *
     * @return Returns a string.
     */
    @NotNull
    public String getKeyDelimiter() {
        return keyDelimiter;
    }

    /**
     * Set key word delimiter.
     * <p>
     * Default "." (Dot)
     *
     * @param keyDelimiter A string
     * @return This instance
     */
    public Xsd2KeyValueConverter<T> setKeyDelimiter(@NotNull String keyDelimiter) {
        this.keyDelimiter = keyDelimiter;
        return this;
    }

    /**
     * Returns delimiters for attributes.
     * <p>
     * Default "#" (Hashtag)
     *
     * @return Returns a string.
     */
    @NotNull
    public String getAttributeDelimiter() {
        return attributeDelimiter;
    }

    /**
     * Set delimiter for the attribute name.
     * <p>
     * Default "#" (Hashtag)
     *
     * @param attributeDelimiter A string
     * @return This instance
     */
    public Xsd2KeyValueConverter<T> setAttributeDelimiter(@NotNull String attributeDelimiter) {
        this.attributeDelimiter = attributeDelimiter;
        return this;
    }

    /**
     * Returns support of converting XML attributes.
     * <p>
     * Default true
     *
     * @return When true, XML attributes will also be converted otherwise not
     */
    public boolean isAttributeSupport() {
        return attributeSupport;
    }

    /**
     * Set converting support of XML attributes
     * <p>
     * Default true;
     *
     * @param attributeSupport When true, XML attributes will also be converted otherwise not
     * @return This instance
     */
    public Xsd2KeyValueConverter<T> setAttributeSupport(boolean attributeSupport) {
        this.attributeSupport = attributeSupport;
        return this;
    }

    /**
     * Set an alternative {@link KeyProperties} {@link Supplier}.
     * <p>
     * MUST be set, when this class is used with an extended class of {@link KeyProperties}
     *
     * @param keyPropertySupplier The alternative supplier
     * @return This instance
     */
    public Xsd2KeyValueConverter<T> setKeyPropertySupplier(@NotNull Supplier<T> keyPropertySupplier) {
        this.keyPropertySupplier = keyPropertySupplier;
        return this;
    }

    /**
     * Converts also restriction of simple type elements
     *
     * @return Return restriction support. Default: true
     */
    public boolean isRestrictionSupport() {
        return restrictionSupport;
    }

    /**
     * Set the support of converting restrictions of simple type elements.
     *
     * @param restrictionSupport Set support. Default: true
     */
    public void setRestrictionSupport(boolean restrictionSupport) {
        this.restrictionSupport = restrictionSupport;
    }

    /**
     * Reads an XSD file and converts as a very simple key properties {@link Map}.
     *
     * @param file File to read
     * @return Returns a map but never null
     * @throws JAXBException Thrown when unable to parse the XSD document
     * @throws IOException   Thrown when unable to read XML document from the input stream
     */
    @NotNull
    public Map<String, T> convert(@NotNull Path file) throws JAXBException, IOException {
        try (Reader r = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            return convert(reader.readXsd(r));
        }
    }

    /**
     * Reads an XSD document from an {@link InputStream} and converts as a very simple key properties {@link Map}.
     * <p>
     * Complex types will be resolved to simple type as possible
     *
     * @param in Input stream where to read the XSD document
     * @return Returns a map but never null
     * @throws JAXBException Thrown when unable to parse the XSD document
     * @throws IOException   Thrown when unable to read XML document from the input stream
     */
    @NotNull
    public Map<String, T> convert(@NotNull InputStream in) throws JAXBException, IOException {
        try (Reader r = new InputStreamReader(in, StandardCharsets.UTF_8)) {
            return convert(reader.readXsd(r));
        }
    }

    /**
     * Converts an {@link XsdSchema} into a very simple key properties {@link Map}.
     *
     * @param schema An {@link XsdSchema}
     * @return Returns a map but never null
     */
    @NotNull
    public Map<String, T> convert(@NotNull XsdSchema schema) {

        resolveTypes(schema);
        resolveElement(schema.getElement());

        return traverse(schema.getElement());

    }

    void resolveTypes(@NotNull XsdSchema schema) {
        schema.streamSimpleTypes().forEach(st -> resolvedSimpleTypes.put(st.getName(), st));

        // Resolve simple types in complex types
        schema.streamComplexTypes()
                // Pass filter when simple type isn't resolved
                .filter(ct -> resolvedSimpleTypes.containsKey(ct.getName()))
                .flatMap(XsdComplexType::streamElementGroup)
                // Filter only type, who has no child of type complex
                .filter(e -> resolvedSimpleTypes.containsKey(e.getType()))
                .forEach(e -> {
                    e.setSimpleType(resolvedSimpleTypes.get(e.getType()));
                    e.setType(null);
                });

        Set<String> complexTypeNames = schema.streamComplexTypes().map(AttributeName::getName).collect(Collectors.toSet());

        while (resolvedComplexTypes.size() + resolvedSimpleTypes.size() < complexTypeNames.size()) {
            // Collect resolved complex types
            schema.streamComplexTypes()
                    // Pass filter when type isn't resolved
                    .filter(ct -> !resolvedComplexTypes.containsKey(ct.getName()) && !resolvedSimpleTypes.containsKey(ct.getName()))
                    // Resolve complex type because it can not be a simple type because simple types must not be resolved
                    // Filter only type, who has no child of type complex
                    .filter(ct -> getUnresolvedChildComplexTypes(ct).isEmpty())
                    .forEach(ct -> resolvedComplexTypes.put(ct.getName(), ct));

            // Resolve complex types
            schema.streamComplexTypes()
                    // Pass filter when type isn't resolved
                    .filter(ct -> !resolvedComplexTypes.containsKey(ct.getName()))
                    .flatMap(XsdComplexType::streamElementGroup)
                    .filter(e -> resolvedComplexTypes.containsKey(e.getType()))
                    .forEach(e -> {
                        e.setComplexType(resolvedComplexTypes.get(e.getType()));
                        e.setType(null);
                    });
        }
    }

    void resolveElement(@NotNull XsdElement element) {
        element.getOptionalType()
                .filter(t -> !isPrimitiveType(t))
                .ifPresentOrElse(t -> {
                    Optional.ofNullable(resolvedSimpleTypes.get(t)).ifPresent(element::setSimpleType);
                    Optional.ofNullable(resolvedComplexTypes.get(t)).ifPresent(element::setComplexType);
                    element.setType(null);
                }, () -> element.getOptionalComplexType().ifPresent(ct -> ct.streamElementGroup().forEach(this::resolveElement)));
    }

    @NotNull
    Set<String> getUnresolvedChildComplexTypes(XsdComplexType parent) {
        return parent.getOptionalElementGroup()
                .map(ElementGroup::getElements)
                .orElseGet(ArrayList::new)
                .stream()
                .filter(this::isComplexType)
                .filter(e -> e.getOptionalType().isPresent())
                .map(XsdElement::getType)
                .collect(Collectors.toSet());
    }

    @NotNull
    Map<String, T> traverse(@NotNull XsdElement element) {
        String key = element.getName();
        Optional<String> opt = getPrimitiveType(element);
        if (opt.isPresent()) {
            T kp = keyPropertySupplier.get();
            kp.setKey(key);
            kp.setDatatype(opt.get());
            kp.setDefaultValue(element.getDefault());

            element.getOptionalSimpleType().ifPresent(st -> kp.setConstraints(convertRestrictions(st)));

            getAppInfoMessage(element.getAnnotation()).ifPresent(kp::setDescription);

            return Map.of(key, kp);
        }

        return element.getOptionalComplexType()
                        .map(ct -> enrichKey(traverse(ct), element.getName()))
                        .orElse(Map.of());
    }

    @NotNull
    Map<String, T> traverse(@NotNull XsdComplexType complexType) {
        Map<String, T> result = new HashMap<>();
        complexType
                .getOptionalElementGroup()
                .map(ElementGroup::streamElements)
                .orElse(Stream.empty())
                .map(this::traverse)
                .forEach(result::putAll);

        return result;
    }

    boolean isPrimitiveType(@Nullable String type) {
        return type != null && type.startsWith(namespace);
    }

    @NotNull
    Optional<String> getPrimitiveType(@NotNull XsdElement element) {
        Optional<String> o = element
                .getOptionalType()
                .filter(this::isPrimitiveType);
        if (o.isPresent()) {
            return o;
        }

        return element
                .getOptionalSimpleType()
                .map(XsdSimpleType::getRestriction)
                .map(XsdRestriction::getBase)
                .filter(this::isPrimitiveType);
    }

    boolean isComplexType(XsdElement element) {
        return getPrimitiveType(element).isEmpty();
    }

    @NotNull
    Optional<String> getAppInfoMessage(@Nullable XsdAnnotation annotation) {
        if (annotation == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(annotation
                .getOptionalDocumentation()
                .map(XsdDocumentation::getValue)
                .orElse(annotation
                        .getOptionalAppInfo()
                        .map(XsdAppInfo::getNodeInfo)
                        .map(XsdNodeInfo::getMessage)
                        .orElse(null)
                ));
    }

    @NotNull
    Map<String, T> enrichKey(@NotNull Map<String, T> map, @NotNull String keyEnrichment) {
        Map<String, T> result = new HashMap<>();
        map.forEach((key, value) -> result.put(String.format("%s%s%s", keyEnrichment, keyDelimiter, key), value));
        return result;
    }

    @Nullable
    KeyConstraints convertRestrictions(@NotNull XsdSimpleType simpleType) {
        if (!restrictionSupport) {
            return null;
        }

        KeyConstraints kr = new KeyConstraints();

        if (simpleType.getRestriction() == null) {
            return kr;
        }

        XsdRestriction restriction = simpleType.getRestriction();
        kr.setEnumeration(getEnumerationRestriction(simpleType));
        restriction.getOptionalMinExclusive().ifPresent(e -> kr.setMinExclusive(Integer.parseInt(e.getValue())));

        restriction.getOptionalMinExclusive().ifPresent(e -> kr.setMinExclusive(Integer.parseInt(e.getValue())));
        restriction.getOptionalMinInclusive().ifPresent(e -> kr.setMinInclusive(Integer.parseInt(e.getValue())));
        restriction.getOptionalMaxExclusive().ifPresent(e -> kr.setMaxExclusive(Integer.parseInt(e.getValue())));
        restriction.getOptionalMaxInclusive().ifPresent(e -> kr.setMaxInclusive(Integer.parseInt(e.getValue())));
        restriction.getOptionalTotalDigits().ifPresent(e -> kr.setTotalDigits(e.getValue()));
        restriction.getOptionalFractionDigits().ifPresent(e -> kr.setFractionDigits(e.getValue()));
        restriction.getOptionalLength().ifPresent(e -> kr.setLength(e.getValue()));
        restriction.getOptionalMinLength().ifPresent(e -> kr.setMinLength(e.getValue()));
        restriction.getOptionalMaxLength().ifPresent(e -> kr.setMaxLength(e.getValue()));
        restriction.getOptionalPattern().ifPresent(e -> kr.setPattern(e.getValue()));

        return kr;
    }

    @NotNull
    Set<String> getEnumerationRestriction(@NotNull XsdSimpleType simpleType) {
        return simpleType
                .getOptionalRestriction()
                .map(r -> r
                        .streamEnumeration()
                        .map(AttributeValue::getValue)
                        .collect(Collectors.toSet()))
                .orElse(Set.of());
    }

}
