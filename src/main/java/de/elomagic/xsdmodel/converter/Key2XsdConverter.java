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

import de.elomagic.xsdmodel.elements.XsdElement;
import de.elomagic.xsdmodel.elements.XsdSchema;
import de.elomagic.xsdmodel.elements.impl.XsdSchemaImpl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Key2XsdConverter {

    private String keyDelimiter = ".";
    private Pattern keyPattern = Pattern.compile("^(?<name>[^#\\[\\]]+)(\\[(?<index>\\d+)])?(#(?<attr>.+))?$");
    private int repetitionStart = 1;
    private boolean setDefaultValue;
    private String rootName = "root";
    private BiConsumer<String, XsdElement> keyConsumer;

    /**
     * Returns the delimiter string, which will divide key into key items.
     * <p>
     * Default "."
     *
     * @return key item delimiter but never null
     */
    @NotNull
    public String getKeyDelimiter() {
        return keyDelimiter;
    }

    /**
     * Set the delimiter string, which will divide key into key items.
     *
     * @param keyDelimiter key item delimiter
     * @return This instance
     */
    public Key2XsdConverter setKeyDelimiter(@NotNull String keyDelimiter) {
        this.keyDelimiter = keyDelimiter;
        return this;
    }

    /**
     * Returns a regular expression {@link Pattern} to separate key item into name, repetition and attribute.
     * <p>
     * Default "^(?<name>[^#\\[\\]]+)(\\[(?<index>\\d+)])?(#(?<attr>.+))?$"
     *
     * @return The key pattern but never null.
     */
    @NotNull
    public Pattern getKeyPattern() {
        return keyPattern;
    }

    /**
     * Set regular expression {@link Pattern} to separate key item into name, repetition and attribute.
     *
     * @param keyPattern The key pattern but never null.
     * @return This instance
     */
    public Key2XsdConverter setKeyPattern(@NotNull Pattern keyPattern) {
        this.keyPattern = keyPattern;
        return this;
    }

    public int getRepetitionStart() {
        return repetitionStart;
    }

    /**
     * Set value, where repetition index will start.
     *
     * @param repetitionStart Start from index
     * @return This instance
     */
    public Key2XsdConverter setRepetitionStart(int repetitionStart) {
        this.repetitionStart = repetitionStart;
        return this;
    }

    public boolean isSetDefaultValue() {
        return setDefaultValue;
    }

    public Key2XsdConverter setSetDefaultValue(boolean setDefaultValue) {
        this.setDefaultValue = setDefaultValue;
        return this;
    }

    @Nullable
    public String getRootName() {
        return rootName;
    }

    public Key2XsdConverter setRootName(@Nullable String rootName) {
        this.rootName = rootName;
        return this;
    }

    @Nullable
    public BiConsumer<String, XsdElement> getKeyConsumer() {
        return keyConsumer;
    }

    public Key2XsdConverter setKeyConsumer(@Nullable BiConsumer<String, XsdElement> keyConsumer) {
        this.keyConsumer = keyConsumer;
        return this;
    }

    /**
     *
     * @param keys Set of keys to convert
     * @return Returns an {@link Optional} but never null
     * @throws XsdConverterException Thrown when unable to map keys into {@link XsdSchema}
     */
    @NotNull
    public Optional<XsdSchema> convert(@NotNull Set<Object> keys) throws XsdConverterException{

        if (keys.isEmpty()) {
            return Optional.empty();
        }

        // TODO Use factory class
        XsdSchema schema = new XsdSchemaImpl();

        keys.stream()
                .sorted()
                .forEach(k -> mapKey(k.toString(), schema));

        return Optional.of(schema);

    }

    @NotNull
    XsdElement findOrCreateElement(@NotNull XsdElement parentElement, @NotNull String name) {
        return parentElement
                .getOptionalComplexType()
                .orElseGet(parentElement::createComplexType)
                .getOptionalAll()
                .orElseGet(() -> parentElement.getOptionalComplexType().orElseThrow().createAll())
                .streamElements()
                .filter(e -> name.equals(e.getName()))
                .map(e -> (XsdElement)e)
                .findFirst()
                .orElseGet(() -> {
                        XsdElement element = parentElement.createComplexType().createAll().createElement();
                        element.setName(name);
                        return element;
                });
    }

    void mapKey(@NotNull String key, @NotNull XsdSchema schema) throws XsdConverterException{

        String[] keyChain = key.split("\\.");

        //document.getDocumentElement().

        boolean isAttr = false;

        XsdElement parentNode = schema.getOptionalElement().orElseGet(() -> {
            XsdElement n = schema.createElement();
            n.setName(rootName == null ? keyChain[0] : rootName);
            return n;
        });

        for (String item : Arrays.copyOfRange(keyChain, 1, keyChain.length)) {
            Matcher matcher = keyPattern.matcher(item);

            if (matcher.find()) {
                String name = matcher.group("name");
                Integer index = Optional.ofNullable(matcher.group("index")).map(Integer::parseInt).orElse(null);
                // TODO Check. Attr can only be set on latest item
                String attr = matcher.group("attr");

                parentNode = findOrCreateElement(parentNode, name);
            } else {
                throw new XsdConverterException("Unsupported key value '" + key + "'.");
            }
        }

        // TODO parentNode now leaf node. Set datatype, default value etc.
        parentNode.setType("xs:string");

        if (keyConsumer != null) {
            keyConsumer.accept(key, parentNode);
        }

    }

}
