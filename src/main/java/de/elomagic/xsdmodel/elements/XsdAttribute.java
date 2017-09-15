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

import de.elomagic.xsdmodel.enumerations.Form;
import de.elomagic.xsdmodel.enumerations.Use;

/**
 * The <code>attribute</code> element defines an attribute.
 *
 * @author Carsten Rambow
 */
public interface XsdAttribute extends ElementAnnotation, AttributeId, AttributeName, AttributeRef {

    /**
     * Specifies a default value for the attribute.
     * <p>
     * Optional. Default and fixed attributes cannot both be present
     *
     * @return String value of attribute <code>default</code>.
     */
    String getDefault();

    /**
     * Specifies a fixed value for the attribute.
     * <p>
     * Optional. Default and fixed attributes cannot both be present.
     *
     * @return String value of attribute <code>fixed</code>.
     */
    String getFixed();

    /**
     * Specifies the form for the attribute.
     * <p>
     * Optional. The default value is the value of the attributeFormDefault attribute of the
     * element containing the attribute. Can be set to one of the following:
     * <ul>
     * <li>"qualified" - indicates that this attribute must be qualified with the namespace
     * prefix and the no-colon-name (NCName) of the attribute</li>
     * <li>unqualified - indicates that this attribute is not required to be qualified with the
     * namespace prefix and is matched against the (NCName) of the attribute</li>
     * </ul>
     *
     * @return String value of attribute <code>form</code>.
     */
    Form getForm();

    /**
     * Specifies a built-in data type or a simple type.
     * <p>
     * Optional. The type attribute can only be present when the content does not contain a simpleType element
     *
     * @return String value of attribute <code>type</code>.
     */
    String getType();

    /**
     * Specifies how the attribute is used.
     * <p>
     * Optional. Can be one of the following values:
     * <ul>
     * <li>optional - the attribute is optional (this is default)</li>
     * <li>prohibited - the attribute cannot be used</li>
     * <li>required - the attribute is required</li>
     * </ul>
     *
     * @return String value of attribute <code>use</code>.
     */
    Use getUse();

}
