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
package de.elomagic.xsdmodel.converter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class KeyConstraints {

    private boolean required;
    private Set<String> enumeration = new HashSet<>();
    private Integer minExclusive;
    private Integer minInclusive;
    private Integer maxExclusive;
    private Integer maxInclusive;
    private Integer totalDigits;
    private Integer fractionDigits;
    private Integer length;
    private Integer minLength;
    private Integer maxLength;
    private String pattern;

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    @NotNull
    public Set<String> getEnumeration() {
        return enumeration;
    }

    public void setEnumeration(@NotNull Set<String> enumeration) {
        this.enumeration = enumeration;
    }

    @Nullable
    public Integer getMinExclusive() {
        return minExclusive;
    }

    public void setMinExclusive(Integer minExclusive) {
        this.minExclusive = minExclusive;
    }

    @Nullable
    public Integer getMinInclusive() {
        return minInclusive;
    }

    public void setMinInclusive(Integer minInclusive) {
        this.minInclusive = minInclusive;
    }

    @Nullable
    public Integer getMaxExclusive() {
        return maxExclusive;
    }

    public void setMaxExclusive(Integer maxExclusive) {
        this.maxExclusive = maxExclusive;
    }

    @Nullable
    public Integer getMaxInclusive() {
        return maxInclusive;
    }

    public void setMaxInclusive(Integer maxInclusive) {
        this.maxInclusive = maxInclusive;
    }

    @Nullable
    public Integer getTotalDigits() {
        return totalDigits;
    }

    public void setTotalDigits(Integer totalDigits) {
        this.totalDigits = totalDigits;
    }

    @Nullable
    public Integer getFractionDigits() {
        return fractionDigits;
    }

    public void setFractionDigits(Integer fractionDigits) {
        this.fractionDigits = fractionDigits;
    }

    @Nullable
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Nullable
    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    @Nullable
    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    @Nullable
    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

}
