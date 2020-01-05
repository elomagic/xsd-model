/*
 * XSD Model
 * Copyright (c) 2017-2019 Carsten Rambow
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

import de.elomagic.xsdmodel.enumerations.Block;
import de.elomagic.xsdmodel.enumerations.Final;
import de.elomagic.xsdmodel.enumerations.Form;

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
    String getType();

    /**
     * Specifies the name of an element that can be substituted with this element. This attribute cannot be used if the parent element is not the schema element
     * <p>
     * Optional.
     *
     * @return The substitution group
     */
    String getSubstitutionGroup();

    /**
     * Specifies a default value for the element (can only be used if the element's content is a simple type or text only).
     * <p>
     * Optional.
     *
     * @return String value of attribute <code>default</code>.
     */
    String getDefault();

    /**
     * Specifies a fixed value for the element (can only be used if the element's content is a simple type or text only).
     * <p>
     * Optional.
     *
     * @return The fixed value
     */
    String getFixed();

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
    Form getForm();

    /**
     * Specifies whether an explicit null value can be assigned to the element. True enables an instance of the element
     * to have the null attribute set to true. The null attribute is defined as part of the XML Schema namespace for
     * instances. Default is false.
     * <p>
     * Optional
     *
     * @return The nillable value
     */
    Boolean getNillable();

    /**
     * Specifies whether the element can be used in an instance document. True indicates that the element cannot appear
     * in the instance document. Instead, another element whose substitutionGroup attribute contains the qualified
     * name (QName) of this element must appear in this element's place. Default is false.
     * <p>
     * Optional
     *
     * @return The abstract value.
     */
    Boolean getAbstract();

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
    Block getBlock();

    /**
     * Sets the default value of the final attribute on the element element. This attribute cannot be used if the
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
    Final getFinal();

    XsdSimpleType getSimpleType();

    XsdComplexType getComplexType();

    List<? extends XsdUnique> getUniques();

    List<? extends XsdKey> getKeys();

    List<? extends XsdKeyref> getKeyrefs();

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
