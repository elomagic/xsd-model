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
 * The <code>simpleType</code> element defines a simple type and specifies the
 * constraints and information about the values of attributes or text-only elements.
 *
 * @author Carsten Rambow
 */
public interface XsdSimpleType extends ElementAnnotation<XsdSimpleType>, AttributeId, AttributeName<XsdSimpleType>, AttributeAny, Attributes {

    String getFinal();

    /**
     * Return restriction of a range of values for the simple type to a subset of those for inherited simple type.
     *
     * @return Returns the restriction of null.
     */
    @Nullable
    XsdRestriction getRestriction();

    @NotNull
    default Optional<XsdRestriction> getOptionalRestriction() {
        return Optional.ofNullable(getRestriction());
    }

    @Nullable
    XsdList getList();

    @NotNull
    default Optional<XsdList> getOptionalList() {
        return Optional.ofNullable(getList());
    }

    @Nullable
    XsdUnion getUnion();

    @NotNull
    default Optional<XsdUnion> getOptionalUnion() {
        return Optional.ofNullable(getUnion());
    }

}
