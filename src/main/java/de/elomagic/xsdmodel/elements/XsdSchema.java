/*
 * XSD Model (Java 17 + Jakarta)
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

import java.net.URI;
import java.util.List;

import de.elomagic.xsdmodel.enumerations.Block;
import de.elomagic.xsdmodel.enumerations.Final;
import de.elomagic.xsdmodel.enumerations.NMToken;

/**
 * The <code>schema</code> element defines the root element of a schema.
 *
 * @author Carsten Rambow
 */
public interface XsdSchema extends ElementAnnotation, AttributeId {

    /**
     * The form for attributes declared in the target namespace of this schema.
     * <p>
     * Optional.
     * <p>
     * The value must be "qualified" or "unqualified". Default is "unqualified". "unqualified" indicates that
     * attributes from the target namespace are not required to be qualified with the namespace prefix.
     * "qualified" indicates that attributes from the target namespace must be qualified with the namespace prefix
     *
     * @return {@link NMToken} value
     */
    NMToken getAttributeFormDefault();

    /**
     * Returns a the value of the attribute <code>elementFormDefault</code> of this <code>schema</code> element.
     * <p>
     * Optional. The form for elements declared in the target namespace of this schema.
     * The value must be "qualified" or "unqualified". Default is "unqualified".
     * "unqualified" indicates that elements from the target namespace are not required
     * to be qualified with the namespace prefix. "qualified" indicates that elements
     * from the target namespace must be qualified with the namespace prefix
     *
     * @return {@link NMToken} value
     */
    NMToken getElementFormDefault();

    /**
     * Specifies the default value of the block attribute on element and complexType elements in the target namespace.
     * <p>
     * Optional.
     * <p>
     * The block attribute prevents a complex type (or element) that has a specified type of derivation from being used
     * in place of this complex type. This value can contain #all or a list that is a subset of extension, restriction,
     * or substitution:
     * <ul>
     * <li>extension - prevents complex types derived by extension</li>
     * <li>restriction - prevents complex types derived by restriction</li>
     * <li>substitution - prevents substitution of elements</li>
     * <li>#all - prevents all derived complex types</li>
     * </ul>
     *
     * @return {@link Block} value
     */
    Block getBlockDefault();

    /**
     * Specifies the default value of the final attribute on element, simpleType, and complexType elements in the target namespace.
     * <p>
     * Optional.
     * <p>
     * The final attribute prevents a specified type of derivation of an element, simpleType, or complexType element.
     * For element and complexType elements, this value can contain #all or a list that is a subset of extension or restriction.
     * For simpleType elements, this value can additionally contain list and union:
     * <ul>
     * <li>extension - prevents derivation by extension</li>
     * <li>restriction - prevents derivation by restriction</li>
     * <li>list - prevents derivation by list</li>
     * <li>union - prevents derivation by union</li>
     * <li>#all - prevents all derivation</li>
     * </ul>
     *
     * @return {@link Final} value
     */
    Final getFinalDefault();

    /**
     * A URI reference of the namespace of this schema.
     * <p>
     * Optional.
     *
     * @return
     */
    URI getTargetNamespace();

    /**
     * Returns a the value of the attribute <code>version</code> of this <code>schema</code> element.
     * <p>
     * Optional. Specifies the version of the schema
     *
     * @return String value of attribute <code>version</code>.
     */
    String getVersion();

    /**
     * A URI reference that specifies one or more namespaces for use in this schema.
     * <p>
     * If no prefix is assigned, the schema components of the namespace can be used with unqualified references
     *
     * @return URI value
     */
    URI getXmlns();

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
     * Returns root {@link XsdElement} represented in the XSD by the element <code>element</code>.
     *
     * @return Element <code>element</code>.
     */
    XsdElement getElement();

    /**
     * Returns a {@link List} of {@link XsdSimpleType} represented in the XSD by the element <code>simpleType</code>.
     *
     * @return List of elements <code>simpleType</code>.
     */
    List<? extends XsdSimpleType> getSimpleTypes();

    /**
     * Returns a {@link List} of {@link XsdComplexType} represented in the XSD by the element <code>complexType</code>.
     *
     * @return List of elements <code>complexType</code>.
     */
    List<? extends XsdComplexType> getComplexTypes();

}
