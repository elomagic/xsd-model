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
 * The <code>annotation</code> element is a top level element that specifies schema comments.
 * <p>
 * The comments serve as inline documentation.
 *
 * @author Carsten Rambow
 */
public interface XsdAnnotation extends ElementChild, AttributeId {

    /**
     * Returns the documentation element, which is used to enter text comments in a schema.
     *
     * @return Element <code>documentation</code>.
     */
    @Nullable
    XsdDocumentation getDocumentation();

    /**
     * Returns {@link Optional} of the documentation element, which is used to enter text comments in a schema.
     *
     * @return  Optional of element <code>documentation</code>.
     */
    @NotNull
    default Optional<XsdDocumentation> getOptionalDocumentation() {
        return  Optional.ofNullable(getDocumentation());
    }

    /**
     * Returns element <code>appInfo</code>.
     * <p>
     * This is a non standard XSD element.
     *
     * @return Element <code>appinfo</code>.
     */
    @Nullable
    XsdAppInfo getAppInfo();

    /**
     * Returns {@link java.util.Optional} element <code>appInfo</code>.
     * <p>
     * This is a non standard XSD element.
     *
     * @return Optional of element <code>appinfo</code>.
     */
    @NotNull
    default Optional<XsdAppInfo> getOptionalAppInfo() {
        return Optional.ofNullable(getAppInfo());
    }

}
