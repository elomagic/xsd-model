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

/**
 * The <code>list</code> element defines a simple type element as a list of values of a specified data type.
 *
 * @author Carsten Rambow
 */
public interface XsdList extends ElementChild, AttributeId {

    /**
     * Specifies the name of a built-in data type or simpleType element defined in this or another schema.
     * <p>
     * This attribute is not allowed if the content contains a simpleType element, otherwise it is required.
     *
     * @return String value of attribute <code>itemType</code>.
     */
    String getItemType();

    /**
     * Specifies the name of a built-in data type or simpleType element defined in this or another schema.
     * <p>
     * This attribute is not allowed if the content contains a simpleType element, otherwise it is required.
     *
     * @param itemType String value of attribute <code>itemType</code>.
     * @return This instance
     */
    @NotNull
    XsdList setItemType(@Nullable String itemType);

}
