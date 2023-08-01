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
import de.elomagic.xsdmodel.elements.AttributeName;
import de.elomagic.xsdmodel.elements.ElementGroup;
import de.elomagic.xsdmodel.elements.XsdAnnotation;
import de.elomagic.xsdmodel.elements.XsdComplexType;
import de.elomagic.xsdmodel.elements.XsdElement;
import de.elomagic.xsdmodel.elements.XsdRestriction;
import de.elomagic.xsdmodel.elements.XsdSchema;
import de.elomagic.xsdmodel.elements.XsdSimpleType;
import de.elomagic.xsdmodel.elements.extention.XsdNodeInfo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Very <b>experimental</b> small tooling class to map a simple XSD into a key properties map.
 * <p>
 *
 */
public class Xsd2KeyValueConverter<T extends KeyProperties> {

    private static final Logger LOGGER = Logger.getLogger(Xsd2KeyValueConverter.class.getName());

    // TODO Use namespace prefix from XSD
    private final String namespace = "xs:";
    private String keyDelimiter = ".";
    private boolean attributeSupport = true;
    private String attributeDelimiter = "#";
    private Supplier<T> keyPropertySupplier = () -> (T) new KeyProperties();

    private final Map<String, T> simpleTypeMap = new HashMap<>();
    // Name of complex type, key and property of key
    private final Map<String, Map<String, T>> complexTypeMap = new HashMap<>();

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
     */
    public void setKeyDelimiter(@NotNull String keyDelimiter) {
        this.keyDelimiter = keyDelimiter;
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
     */
    public void setAttributeDelimiter(@NotNull String attributeDelimiter) {
        this.attributeDelimiter = attributeDelimiter;
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
     */
    public void setAttributeSupport(boolean attributeSupport) {
        this.attributeSupport = attributeSupport;
    }

    /**
     * Set an alternative {@link KeyProperties} {@link Supplier}.
     * <p>
     * MUST be set, when this class is used with an extended class of {@link KeyProperties}
     *
     * @param keyPropertySupplier The alternative supplier
     */
    public void setKeyPropertySupplier(@NotNull Supplier<T> keyPropertySupplier) {
        this.keyPropertySupplier = keyPropertySupplier;
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
        return convert(XsdReader.read(file));
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
        return convert(XsdReader.read(in));
    }

    /**
     * Converts an {@link XsdSchema} into a very simple key properties {@link Map}.
     *
     * @param schema An {@link XsdSchema}
     * @return Returns a map but never null
     */
    @NotNull
    public Map<String, T> convert(@NotNull XsdSchema schema) {

        buildupNamedTypeMap(schema);

        return traverse(schema.getElement());

    }

    void buildupNamedTypeMap(@NotNull XsdSchema schema) {
        simpleTypeMap.clear();
        complexTypeMap.clear();

        schema.streamSimpleTypes().forEach(st -> traverse(st).ifPresent(kp -> simpleTypeMap.put(st.getName(), kp)));

        // Set of complex types to resolve
        Set<String> complexTypeNames = schema.streamComplexTypes().map(AttributeName::getName).collect(Collectors.toSet());
        // TODO Resolve complex types recursive !
        // TODO Build dependency tree

        schema.streamComplexTypes().forEach(ct -> complexTypeMap.put(ct.getName(), traverse(ct)));
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

            getAppInfoMessage(element.getAnnotation()).ifPresent(kp::setDescription);

            return Map.of(key, kp);
        }

        return enrichKey(
                element.getOptionalType()
                        // Check also simpleTypeMap
                        .map(t -> complexTypeMap.getOrDefault(t, Map.of(element.getName(), simpleTypeMap.get(t))))
                        .orElse(element.getOptionalComplexType()
                                .map(ct -> enrichKey(traverse(ct), keyDelimiter))
                                .orElse(Map.of())),
                keyDelimiter
        );
    }

    /*
     * <code>
     *     <simpleType
     *          id=ID
     *          name=NCName
     *          any attributes
     *          >
     *          (annotation?,(restriction|list|union))
     *      </simpleType>
     * </code>
     */
    @NotNull
    Optional<T> traverse(@NotNull XsdSimpleType simpleType) {

        if (simpleType.getOptionalRestriction().isPresent()) {
            T kp = keyPropertySupplier.get();
            getPrimitiveType(simpleType).ifPresent(kp::setDatatype);
            getAppInfoMessage(simpleType.getAnnotation()).ifPresent(kp::setDescription);

            return Optional.of(kp);
        } else if (simpleType.getOptionalList().isPresent()) {
            LOGGER.info("Element 'list' in simple type '" + simpleType.getName() + "' currently not supported");
        } else if (simpleType.getOptionalUnion().isPresent()) {
            LOGGER.info("Element 'union' in simple type '" + simpleType.getName() + "' currently not supported");
        }
        // TODO Implementation missing

        return Optional.empty();
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

    boolean isPrimitiveType(@NotNull XsdElement element) {
        return getPrimitiveType(element).isPresent();
    }

    @NotNull
    Optional<String> getPrimitiveType(@NotNull XsdElement element) {
        Optional<String> o = element.getOptionalType().filter(t -> t.startsWith(namespace));
        if (o.isPresent()) {
            return o;
        }

        return element
                .getOptionalSimpleType()
                .map(XsdSimpleType::getRestriction)
                .map(XsdRestriction::getBase)
                .filter(b -> b.startsWith(namespace));
    }

    @NotNull
    Optional<String> getPrimitiveType(@NotNull XsdSimpleType simpleType) {
        return simpleType.getOptionalRestriction()
                .map(XsdRestriction::getBase)
                .filter(b -> b.startsWith(namespace));
    }

    @NotNull
    Optional<String> getAppInfoMessage(@Nullable XsdAnnotation annotation) {
        if (annotation == null) {
            return Optional.empty();
        }

        return annotation
                .getOptionalAppInfo()
                .flatMap(ai -> ai.getOptionalNodeInfo().map(XsdNodeInfo::getMessage));
    }

    @NotNull
    Map<String, T> enrichKey(@NotNull Map<String, T> map, @NotNull String keyEnrichment) {
        Map<String, T> result = new HashMap<>();
        map.forEach((key, value) -> result.put(String.format("%s%s%s", keyEnrichment, keyDelimiter, key), value));
        return result;
    }

}
