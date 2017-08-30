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
 * The <code>schema</code> element defines the root element of a schema.
 *
 * @author Carsten Rambow
 */
public interface XsdSchema extends ElementGetParent {

    /**
     * Returns a the value of the attribute <code>version</code> of this <code>schema</code> element.
     * <p>
     * Optional. Specifies the version of the schema
     *
     * @return String value of attribute <code>version</code>.
     */
    String getVersion();

    /**
     * Returns a the value of the attribute <code>elementFormDefault</code> of this <code>schema</code> element.
     * <p>
     * Optional. The form for elements declared in the target namespace of this schema.
     * The value must be "qualified" or "unqualified". Default is "unqualified".
     * "unqualified" indicates that elements from the target namespace are not required
     * to be qualified with the namespace prefix. "qualified" indicates that elements
     * from the target namespace must be qualified with the namespace prefix
     *
     * @return String value of attribute <code>elementFormDefault</code>.
     */
    String getElementFormDefault();

    /**
     * Returns a {@link List} of {@link XsdInclude} represented in the XSD by the element <code>include</code>.
     *
     * @return List of elements <code>include</code>.
     */
    List<? extends XsdInclude> getIncludes();

    /**
     * Returns a {@link List} of {@link XsdImport} represented in the XSD by the element <code>import</code>.
     *
     * @return List of elements <code>import</code>.
     */
    List<? extends XsdImport> getImports();

    /**
     * Returns a {@link List} of {@link XsdRedefine} represented in the XSD by the element <code>redefine</code>.
     *
     * @return List of elements <code>redefine</code>.
     */
    List<? extends XsdRedefine> getRedefines();

    /**
     * Returns root {@link XsdAnnotation} represented in the XSD by the element <code>annotation</code>.
     *
     * @return Element <code>annotation</code>.
     */
    XsdAnnotation getAnnotation();

    /**
     * Returns root {@link XsdElement} represented in the XSD by the element <code>element</code>.
     *
     * @return Element <code>element</code>.
     */
    XsdElement getElement();

    /**
     * Returns a {@link List} of {@link XsdComplexType} represented in the XSD by the element <code>complexType</code>.
     *
     * @return List of elements <code>complexType</code>.
     */
    List<? extends XsdComplexType> getComplexTypes();

}
