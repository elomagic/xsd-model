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

import de.elomagic.xsdmodel.enumerations.Block;
import de.elomagic.xsdmodel.enumerations.Final;

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
    Boolean getAbstract();

    /**
     * Specifies whether character data is allowed to appear between the child elements of this complexType element.
     * <p>
     * Optional. Default is false. If a simpleContent element is a child element, the mixed attribute is not allowed!
     *
     * @return String value of attribute <code>mixed</code>.
     */
    Boolean getMixed();

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
    Block getBlock();

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
    Final getFinal();

    /**
     * Returns the <code>all</code> element if exists.
     * <p>
     * The <code>all</code> element specifies that the child elements can appear in any order and that each child element can occur zero or one time (Default is one time).
     * <p>
     * See also <a href="https://www.w3schools.com/xml/el_all.asp">W3Schools</a>
     *
     * @return Returns the element of null
     */
    XsdAll getAll();

    /**
     * Returns the <code>simpleContent</code> element if exists.
     * <p>
     * The <code>simpleContent</code> element contains extensions or restrictions on a text-only complex type or on a simple type as content and contains no elements.
     * <p>
     * See also <a href="https://www.w3schools.com/xml/el_simpleContent.asp">W3Schools</a>
     *
     * @return Returns the element of null
     */
    XsdSimpleContent getSimpleContent();

    /**
     * Returns the <code>complexContent</code> element if exists.
     * <p>
     * The <code>complexContent</code> element defines extensions or restrictions on a complex type that contains mixed content or elements only.
     * <p>
     * See also <a href="https://www.w3schools.com/xml/el_complexcontent.asp">W3Schools</a>
     *
     * @return Returns the element of null
     */
    XsdComplexContent getComplexContent();

    /**
     * Returns the <code>sequence</code> element if exists.
     * <p>
     * The <code>sequence</code> element specifies that the child elements must appear in a sequence. Each child element can occur from 0 to any number of times (Default is one time).
     * <p>
     * See also <a href="https://www.w3schools.com/xml/el_sequence.asp">W3Schools</a>
     *
     * @return Returns the element of null
     */
    XsdSequence getSequence();

    /**
     * Returns the <code>choice</code> element if exists.
     * <p>
     * XML Schema <code>choice</code> element allows only one of the elements contained in the &lt;choice&gt; declaration to be present within the containing element (Default is one time).
     *
     * @return Returns the element of null
     */
    XsdChoice getChoice();

}
