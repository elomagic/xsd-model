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

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 *
 * @author Carsten Rambow
 */
public interface AttributeMinMaxOccurs {

    String UNBOUNDED = "unbounded";

    /**
     * Specifies the maximum number of times the choice element can occur in the parent element.
     * <p>
     * Optional. The value can be any number &gt;= 0, or if you want to set no limit on the maximum
     * number, use the value "unbounded". Default value is 1, This attribute cannot
     * be used if the parent element is the schema element.
     *
     * @return String value of attribute <code>max</code>.
     */
    @Nullable
    String getMaxOccurs();

    /**
     * Specifies the maximum number of times the choice element can occur in the parent element.
     * <p>
     * Optional. The value can be any number &gt;= 0, or if you want to set no limit on the maximum
     * number, use the value "unbounded". Default value is 1, This attribute cannot
     * be used if the parent element is the schema element.
     *
     * @param value Value of attribute <code>max</code>.
     */
    void setMaxOccurs(@Nullable String value);

    @NotNull
    default Optional<String> getOptionalMaxOccurs() {
        return Optional.ofNullable(getMaxOccurs());
    }

    /**
     * Specifies the minimum number of times the choice element can occur in the parent the element.
     * <p>
     * Optional. The value can be any number &gt;= 0. Default value is 1. This attribute cannot be used
     * if the parent element is the schema element
     *
     * @return String value of attribute <code>min</code>.
     */
    @Nullable
    Integer getMinOccurs();

    void setMinOccurs(@Nullable Integer value);

    @NotNull
    default Optional<Integer> getOptionalMinOccurs() {
        return Optional.ofNullable(getMinOccurs());
    }

}
