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

import de.elomagic.xsdmodel.NotSupportedYetException;
import de.elomagic.xsdmodel.XsdReader;
import de.elomagic.xsdmodel.elements.ElementGroup;
import de.elomagic.xsdmodel.elements.XsdComplexType;
import de.elomagic.xsdmodel.elements.XsdElement;
import de.elomagic.xsdmodel.elements.XsdRestriction;
import de.elomagic.xsdmodel.elements.XsdSchema;
import de.elomagic.xsdmodel.elements.XsdSimpleType;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Very <b>experimental</b> small tooling class to map a simple XSD into a key properties map.
 */
public class Xsd2KeyValueConverter<T extends KeyProperties> {

    private String keyDelimiter = ".";
    private boolean attributeSupport = true;
    private String attributeDelimiter = "#";

    private final Map<String, XsdSimpleType> simpleTypeMap = new HashMap<>();
    // Name of complex type, key and property of key
    private final Map<String, Map<String, KeyProperties>> complexTypeMap = new HashMap<>();

    public String getKeyDelimiter() {
        return keyDelimiter;
    }

    public void setKeyDelimiter(String keyDelimiter) {
        this.keyDelimiter = keyDelimiter;
    }

    public String getAttributeDelimiter() {
        return attributeDelimiter;
    }

    public void setAttributeDelimiter(String attributeDelimiter) {
        this.attributeDelimiter = attributeDelimiter;
    }

    public boolean isAttributeSupport() {
        return attributeSupport;
    }

    public void setAttributeSupport(boolean attributeSupport) {
        this.attributeSupport = attributeSupport;
    }

    protected T createKeyProperties() {
        return (T) new KeyProperties();
    }

    /**
     * Reads an XSD file and converts as a very simple key properties {@link Map}.
     *
     * @param file File to read
     * @return Returns a map but never null
     * @throws JAXBException Thrown when unable to parse the XSD document
     * @throws IOException Thrown when unable to read XML document from the input stream
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
     * @throws IOException Thrown when unable to read XML document from the input stream
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

        //schema.getComplexTypes().stream().map(t -> traverse(t)).forEach(kp -> complexTypeMap.put()) ;

        return traverse(schema.getElement());

    }

    Map<String, T> traverse(XsdElement element) {

        // TODO Handle complex type

        String key = element.getName();
        Optional<String> opt = getPrimitiveType(element);
        if (opt.isPresent()) {
            T kp = createKeyProperties();
            kp.setKey(key);
            kp.setDatatype(opt.get());
            kp.setDefaultValue(element.getDefault());

            // TODO Get annotation

            if (element.getOptionalComplexType().isEmpty()) {

            }
            return Map.of(key, kp);
        }

        // TODO traverse complex element
        return element
                .getOptionalComplexType()
                .map(this::traverse)
                .orElse(Map.of());
    }

    Map<String, T> traverse(XsdComplexType complexType) {
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

    Optional<String> getPrimitiveType(@NotNull XsdElement element) {
        Optional<String> o = element.getOptionalType().filter(t -> t.startsWith("xs:"));
        if (o.isPresent()) {
            return o;
        }

        return element
                .getOptionalSimpleType()
                .map(XsdSimpleType::getRestriction)
                .map(XsdRestriction::getBase)
                .filter(b -> b.startsWith("xs:"));
    }

}
