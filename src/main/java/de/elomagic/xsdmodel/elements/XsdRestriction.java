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

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * The <code>restriction</code> element defines restrictions on a simpleType, simpleContent, or complexContent definition.
 *
 * @author Carsten Rambow
 */
public interface XsdRestriction extends ElementAnnotation, AttributeId {

    /**
     * Specifies the name of a built-in data type, simpleType element, or complexType element defined in this schema or another schema
     * <p>
     * Required.
     *
     * @return String value of attribute <code>base</code>.
     */
    String getBase();

    @Nullable
    List<? extends XsdEnumeration> getEnumerations();

    @NotNull
    default Stream<? extends XsdEnumeration> streamEnumeration() {
        return getEnumerations() == null ? Stream.empty() : getEnumerations().stream();
    }

    @NotNull
    default Optional<List<? extends XsdEnumeration>> gerOptionalEnumerations() {
        return Optional.ofNullable(getEnumerations());
    }

    @Nullable
    XsdFractionDigits getFractionDigits();

    @NotNull
    default Optional<XsdFractionDigits> getOptionalFractionDigits() {
        return Optional.ofNullable(getFractionDigits());
    }

    /**
     * Specifies the exact number of characters or list items allowed.
     * <p>
     * Must be equal to or greater than zero.
     *
     * @return Exact number of characters or list items allowed.
     */
    @Nullable
    XsdLength getLength();

    @NotNull
    default Optional<XsdLength> getOptionalLength() {
        return Optional.ofNullable(getLength());
    }

    @Nullable
    XsdMaxExclusive getMaxExclusive();

    @NotNull
    default Optional<XsdMaxExclusive> getOptionalMaxExclusive() {
        return Optional.ofNullable(getMaxExclusive());
    }

    @Nullable
    XsdMinLength getMinLength();

    @NotNull
    default Optional<XsdMinLength> getOptionalMinLength() {
        return Optional.ofNullable(getMinLength());
    }

    @Nullable
    XsdMinInclusive getMinInclusive();

    @NotNull
    default Optional<XsdMinInclusive> getOptionalMinInclusive() {
        return Optional.ofNullable(getMinInclusive());
    }

    @Nullable
    XsdMinExclusive getMinExclusive();

    @NotNull
    default Optional<XsdMinExclusive> getOptionalMinExclusive() {
        return Optional.ofNullable(getMinExclusive());
    }

    /**
     * Specifies the maximum number of characters or list items allowed.
     * <p>
     * Must be equal to or greater than zero
     *
     * @return Maximum number of characters or list items allowed.
     */
    @Nullable
    XsdMaxLength getMaxLength();

    @NotNull
    default Optional<XsdMaxLength> getOptionalMaxLength() {
        return Optional.ofNullable(getMaxLength());
    }

    @Nullable
    XsdMaxInclusive getMaxInclusive();

    @NotNull
    default Optional<XsdMaxInclusive> getOptionalMaxInclusive() {
        return Optional.ofNullable(getMaxInclusive());
    }

    @Nullable
    XsdPattern getPattern();

    @NotNull
    default Optional<XsdPattern> getOptionalPattern() {
        return Optional.ofNullable(getPattern());
    }

    @Nullable
    XsdTotalDigits getTotalDigits();

    @NotNull
    default Optional<XsdTotalDigits> getOptionalTotalDigits() {
        return Optional.ofNullable(getTotalDigits());
    }

    @Nullable
    XsdWhiteSpace getWhiteSpace();

    @NotNull
    default Optional<XsdWhiteSpace> getOptionalWhiteSpace() {
        return Optional.ofNullable(getWhiteSpace());
    }

}
