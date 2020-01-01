/*
 * XSD Model
 * Copyright (c) 2017-2019 Carsten Rambow
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
 * The redefine element redefines simple and complex types, groups, and attribute groups from an external schema.
 *
 * @author Carsten Rambow
 */
public interface XsdRedefine extends ElementChild, AttributeId {

    /**
     * A URI to the location of a schema document.
     * <p>
     * Required.
     *
     * @return String value of attribute <code>schemaLocation</code>.
     */
    URI getSchemaLocation();

}
