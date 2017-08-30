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

import java.util.List;

/**
 * The <code>restriction</code> element defines restrictions on a simpleType, simpleContent, or complexContent definition.
 *
 * @author Carsten Rambow
 */
public interface XsdRestriction extends ElementGetParent {

    /**
     * Specifies the name of a built-in data type, simpleType element, or complexType element defined in this schema or another schema
     * <p>
     * Required.
     *
     * @return String value of attribute <code>base</code>.
     */
    String getBase();

    List<? extends XsdEnumeration> getEnumerations();

    XsdFractionDigits getFractionDigits();

    XsdLength getLength();

    XsdMaxExclusive getMaxExclusive();

    XsdMinLength getMinLength();

    XsdMinInclusive getMinInclusive();

    XsdMinExclusive getMinExclusive();

    XsdMaxLength getMaxLength();

    XsdMaxInclusive getMaxInclusive();

    XsdPattern getPattern();

    XsdTotalDigits getTotalDigits();

    XsdWhiteSpace getWhiteSpace();

}
