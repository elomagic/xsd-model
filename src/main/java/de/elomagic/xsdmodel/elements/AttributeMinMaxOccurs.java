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
 *
 * @author Carsten Rambow
 */
public interface AttributeMinMaxOccurs {

    /**
     * Specifies the maximum number of times the choice element can occur in the parent element.
     * <p>
     * Optional. The value can be any number &gt;= 0, or if you want to set no limit on the maximum
     * number, use the value "unbounded". Default value is 1, This attribute cannot
     * be used if the parent element is the schema element.
     *
     * @return String value of attribute <code>max</code>.
     */
    Integer getMaxOccurs();

    /**
     * Specifies the minimum number of times the choice element can occur in the parent the element.
     * <p>
     * Optional. The value can be any number &gt;= 0. Default value is 1. This attribute cannot be used
     * if the parent element is the schema element
     *
     * @return String value of attribute <code>min</code>.
     */
    Integer getMinOccurs();

}
