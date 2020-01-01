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
 * The <code>selector</code> element specifies an XPath expression that selects a set
 * of elements for an identity constraint (unique, key, and keyref elements).
 *
 * @author Carsten Rambow
 */
public interface XsdSelector extends ElementChild, AttributeId {

    /**
     * Specifies an XPath expression, relative to the element being declared, that
     * identifies the child elements to which the identity constraint applies.
     * <p>
     * Required.
     *
     * @return String value of attribute <code>xpath</code>.
     */
    String getXpath();

}
