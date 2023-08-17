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
package de.elomagic.xsdmodel.elements;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import de.elomagic.xsdmodel.enumerations.Block;
import de.elomagic.xsdmodel.enumerations.Final;
import de.elomagic.xsdmodel.enumerations.Form;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The <code>element</code> element defines an element.
 * <p>
 * What else?
 *
 * @author Carsten Rambow
 */
public interface XsdElement extends ElementAnnotation, AttributeId, AttributeName, AttributeMinMaxOccurs, AttributeRef {

    /**
     * Specifies either the name of a built-in data type, or the name of a simpleType or complexType element.
     * <p>
     * Optional.
     *
     * @return String value of attribute <code>type</code>.
     */
    @Nullable
    String getType();

    /**
     * Specifies either the name of a built-in data type, or the name of a simpleType or complexType element.
     *
     * @param type String value of attribute <code>type</code>.
     */
    void setType(@Nullable String type);

    /**
     * Specifies either the name of a built-in data type, or the name of a simpleType or complexType element.
     * <p>
     * Optional.
     *
     * @return String value of attribute <code>type</code>.
     */
    @NotNull
    default Optional<String> getOptionalType() {
        return Optional.ofNullable(getType());
    }

    /**
     * Specifies the name of an element that can be substituted with this element. This attribute cannot be used if the parent element is not the schema element
     * <p>
     * Optional.
     *
     * @return The substitution group
     */
    @Nullable
    String getSubstitutionGroup();

    @NotNull
    default Optional<String> getOptionalSubstitutionGroup() {
        return Optional.ofNullable(getSubstitutionGroup());
    }

    /**
     * Specifies a default value for the element (can only be used if the element's content is a simple type or text only).
     * <p>
     * Optional.
     *
     * @return String value of attribute <code>default</code>.
     */
    @Nullable
    String getDefault();

    /**
     * Specifies a default value for the element (can only be used if the element's content is a simple type or text only).
     * <p>
     * Optional.
     *
     * @param defaultValue String value of attribute <code>default</code>.
     */
    void setDefault(@Nullable String defaultValue);

    @NotNull
    default Optional<String> getOptionalDefault() {
        return Optional.ofNullable(getDefault());
    }

    /**
     * Specifies a fixed value for the element (can only be used if the element's content is a simple type or text only).
     * <p>
     * Optional.
     *
     * @return The fixed value
     */
    @Nullable
    String getFixed();

    @NotNull
    default Optional<String> getOptionalFixed() {
        return Optional.ofNullable(getFixed());
    }

    /**
     * Specifies the form for the element. "unqualified" indicates that this element is not required to be qualified with
     * the namespace prefix. "qualified" indicates that this element must be qualified with the namespace prefix. The
     * default value is the value of the elementFormDefault attribute of the schema element. This attribute cannot be
     * used if the parent element is the schema element.
     * <p>
     * Optional.
     *
     * @return The form value
     */
    @Nullable
    Form getForm();

    @NotNull
    default Optional<Form> getOptionalForm() {
        return Optional.ofNullable(getForm());
    }

    /**
     * Specifies whether an explicit null value can be assigned to the element. True enables an instance of the element
     * to have the null attribute set to true. The null attribute is defined as part of the XML Schema namespace for
     * instances. Default is false.
     * <p>
     * Optional
     *
     * @return The nillable value
     */
    @Nullable
    Boolean getNillable();

    @NotNull
    default Optional<Boolean> getOptionalNillable() {
        return Optional.ofNullable(getNillable());
    }

    /**
     * Specifies whether the element can be used in an instance document. True indicates that the element cannot appear
     * in the instance document. Instead, another element whose substitutionGroup attribute contains the qualified
     * name (QName) of this element must appear in this element's place. Default is false.
     * <p>
     * Optional
     *
     * @return The abstract value.
     */
    @Nullable
    Boolean getAbstract();

    @NotNull
    default Optional<Boolean> getOptionalAbstract() {
        return Optional.ofNullable(getAbstract());
    }

    /**
     * Prevents an element with a specified type of derivation from being used in place of this element. This value can
     * contain #all or a list that is a subset of extension, restriction, or equivClass:
     * <ul>
     * <li>extension - prevents elements derived by extension</li>
     * <li>restriction - prevents elements derived by restriction</li>
     * <li>substitution - prevents elements derived by substitution</li>
     * <li>#all - prevents all derived elements</li>
     * </ul>
     * <p>
     * Optional
     *
     * @return The block value
     */
    @Nullable
    Block getBlock();

    @NotNull
    default Optional<Block> getOptionalBlock() {
        return Optional.ofNullable(getBlock());
    }


    /**
     * Sets the default value of the final attribute on the element. This attribute cannot be used if the
     * parent element is not the schema element. This value can contain #all or a list that is a subset of extension
     * or restriction:
     * <ul>
     * <li>extension - prevents elements derived by extension</li>
     * <li>restriction - prevents elements derived by restriction</li>
     * <li>#all - prevents all derived elements</li>
     * </ul>
     * <p>
     * Optional
     *
     * @return The final value
     */
    @Nullable
    Final getFinal();

    default Optional<Final> getOptionalFinal() {
        return Optional.ofNullable(getFinal());
    }

    @Nullable
    XsdSimpleType getSimpleType();

    @Deprecated(since = "2023-08-11")
    void setSimpleType(@Nullable XsdSimpleType simpleType);

    @NotNull
    XsdSimpleType createSimpleType();

    @NotNull
    default Optional<XsdSimpleType> getOptionalSimpleType() {
        return Optional.ofNullable(getSimpleType());
    }

    @Nullable
    XsdComplexType getComplexType();

    @Deprecated(since = "2023-08-11")
    void setComplexType(@Nullable XsdComplexType complexType);

    @NotNull
    XsdComplexType createComplexType();

    @NotNull
    default Optional<XsdComplexType> getOptionalComplexType() {
        return Optional.ofNullable(getComplexType());
    }

    List<? extends XsdUnique> getUniques();

    @NotNull
    default Stream<XsdUnique> streamUnique() {
        return getUniques() == null ? Stream.empty() : getUniques().stream().map(i -> (XsdUnique) i);
    }

    List<? extends XsdKey> getKeys();

    @NotNull
    default Stream<XsdKey> streamKeys() {
        return getKeys() == null ? Stream.empty() : getKeys().stream().map(i -> (XsdKey) i);
    }

    List<? extends XsdKeyref> getKeyrefs();

    @NotNull
    default Stream<XsdKeyref> streamKeyrefs() {
        return getKeyrefs() == null ? Stream.empty() : getKeyrefs().stream().map(i -> (XsdKeyref) i);
    }

    default String toLogString() {
        return "XsdElement{" +
                "getName()='" + getName() + '\'' +
                ", getType()='" + getType() + '\'' +
                ", getSubstitutionGroup()=" + getSubstitutionGroup() + '\'' +
                ", getDefault()='" + getDefault() + '\'' +
                ", getFixed()='" + getFixed() + '\'' +
                ", getNillable()='" + getNillable() + '\'' +
                ", getAbstract()='" + getAbstract() + '\'' +
                '}';
    }

}
