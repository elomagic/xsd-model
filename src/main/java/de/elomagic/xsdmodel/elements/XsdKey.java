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

/**
 * The key element specifies an attribute or element value as a key (unique, non-nullable, and always present) within the containing element in an instance
 * document.
 * <p>
 * The key element MUST contain the following (in order):
 * <ul>
 * <li>
 * one and only one selector element (contains an XPath expression that specifies the set of elements across which the values specified by field must be
 * unique)</li>
 * <li>one or more field elements (contains an XPath expression that specifies the values that must be unique for the set of elements specified by the selector
 * element)</li>
 * </ul>
 *
 * @author Carsten Rambow
 */
public interface XsdKey extends ElementChild, AttributeId, AttributeName {

    XsdSelector getSelector();

}
