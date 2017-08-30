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
 * The <code>element</code> element defines an element.
 * <p>
 * What else?
 *
 * @author Carsten Rambow
 */
public interface XsdElement extends ElementGetParent, AttributeId, AttributeName, AttributeMinMaxOccurs, AttributeRef {

    /**
     * Specifies either the name of a built-in data type, or the name of a simpleType or complexType element.
     * <p>
     * Optional.
     *
     * @return String value of attribute <code>type</code>.
     */
    String getType();

    /**
     * Specifies a default value for the element (can only be used if the element's content is a simple type or text only)
     * <p>
     * Optional.
     *
     * @return String value of attribute <code>default</code>.
     */
    String getDefault();

    XsdAnnotation getAnnotation();

    XsdSimpleType getSimpleType();

    XsdComplexType getComplexType();

    List<? extends XsdUnique> getUniques();

    List<? extends XsdKey> getKeys();

    List<? extends XsdKeyref> getKeyrefs();

}
