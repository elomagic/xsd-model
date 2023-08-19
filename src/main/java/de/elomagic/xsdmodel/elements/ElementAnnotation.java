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
public interface ElementAnnotation<O> extends ElementChild {

    /**
     * Returns root {@link XsdAnnotation} represented in the XSD by the element <code>annotation</code>.
     *
     * @return Element <code>annotation</code>.
     */
    @Nullable
    XsdAnnotation getAnnotation();

    /**
     * Set root {@link XsdAnnotation} represented in the XSD by the element <code>annotation</code>.
     *
     * @param annotation Element <code>annotation</code>.
     * @return This instance
     */
    @NotNull
    O setAnnotation(@Nullable XsdAnnotation annotation);

    /**
     * Returns {@link Optional} of root {@link XsdAnnotation} represented in the XSD by the element <code>annotation</code>.
     *
     * @return Optional of Element <code>annotation</code>.
     */
    @NotNull
    default Optional<XsdAnnotation> getOptionalAnnotation() {
        return Optional.ofNullable(getAnnotation());
    }


}
