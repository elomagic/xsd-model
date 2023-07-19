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
 * Interface of a XSD element child.
 *
 * @author Carsten Rambow
 */
public interface ElementChild {

    /**
     * Returns parent element of this element.
     * <p>
     * This method doesn't represent an element of the XSD!
     *
     * @return The parent element or null when this element is root or complex type of root.
     */
    @Nullable
    ElementChild getParent();

    @NotNull
    default Optional<ElementChild> getOptionalParent() {
        return Optional.ofNullable(getParent());
    }

}
