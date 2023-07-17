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

import java.net.URI;

/**
 * The <code>import</code> element is used to add multiple schemas with different target namespace to a document.
 *
 * @author Carsten Rambow
 */
public interface XsdImport extends ElementChild, AttributeId {

    /**
     * Specifies the URI of the namespace to import.
     * <p>
     * Optional.
     *
     * @return String value of attribute <code>namespace</code>.
     */
    String getNamespace();

    /**
     * Specifies the URI to the schema to include in the target namespace of the containing schema.
     * <p>
     * Required.
     *
     * @return String value of attribute <code>schemaLocation</code>.
     */
    URI getSchemaLocation();

}
