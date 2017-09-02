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
 * The <code>union</code> element defines a simple type as a collection (union) of values from specified simple data types.
 *
 * @author Carsten Rambow
 */
public interface XsdUnion extends ElementChild, AttributeId {

    /**
     * Specifies a list of built-in data types or simpleType elements defined in a schema.
     * <p>
     * Optional.
     *
     * @return String value of attribute <code>memberTypes</code>.
     */
    String getMemberTypes();

}
