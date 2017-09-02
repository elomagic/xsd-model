/*
 * XSD Model
 * Copyright (c) 2017-2017 Carsten Rambow
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

/**
 * The <code>complexType</code> element defines a complex type.
 * <p>
 * A complex type element is an XML element that contains other elements and/or attributes.
 *
 * @author Carsten Rambow
 */
public interface XsdComplexType extends ElementChild, AttributeId, AttributeName {

    /**
     * Specifies whether the complex type can be used in an instance document.
     * <p>
     * Optional. True indicates that an element cannot use this complex type directly
     * but must use a complex type derived from this complex type. Default is false
     *
     * @return String value of attribute <code>abstract</code>.
     */
    String getAbstract();

    /**
     * Specifies whether character data is allowed to appear between the child elements of this complexType element.
     * <p>
     * Optional. Default is false. If a simpleContent element is a child element, the mixed attribute is not allowed!
     *
     * @return String value of attribute <code>mixed</code>.
     */
    String getMixed();

    /**
     * Prevents a complex type that has a specified type of derivation from being used in place of this complex type.
     * <p>
     * This value can contain #all or a list that is a subset of extension or restriction:
     * <ul>
     * <li>extension - prevents complex types derived by extension</li>
     * <li>restriction - prevents complex types derived by restriction</li>
     * <li>#all - prevents all derived complex types</li>
     * </ul>
     *
     * @return String value of attribute <code>block</code>.
     */
    String getBlock();

    /**
     * Prevents a specified type of derivation of this complex type element.
     * <p>
     * Optional. Can contain #all or a list that is a subset of extension or restriction.
     * <ul>
     * <li>extension - prevents derivation by extension</li>
     * <li>restriction - prevents derivation by restriction</li>
     * <li>#all - prevents all derivation</li>
     * </ul>
     *
     * @return String value of attribute <code>final</code>.
     */
    String getFinal();

    XsdAll getAll();

    XsdSimpleContent getSimpleContent();

    XsdComplexContent getComplexContent();

    XsdSequence getSequence();

    XsdChoice getChoice();

}
