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

/**
 * The <code>unique</code> element defines that an element or an attribute value must be unique within the scope.
 * <p>
 * The unique element MUST contain the following (in order):
 * <ul>
 * <li>one and only one selector element (contains an XPath expression that specifies the set of elements across which the values specified by field must be
 * unique)</li>
 * <li>one or more field elements (contains an XPath expression that specifies the values that must be unique for the set of elements specified by the selector
 * element)</li>
 * </ul>
 *
 * @author Carsten Rambow
 */
public interface XsdUnique extends ElementChild, AttributeId, AttributeName<XsdUnique> {

    XsdSelector getSelector();

    XsdUnique setSelector(XsdSelector selector);

}
