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
package de.elomagic.xsdmodel;

import javax.xml.validation.Schema;

/**
 *
 * @author Carsten Rambow
 */
@FunctionalInterface
public interface XsdSchemaFactory {

    /**
     * System property key to set an alternative factory class provider.
     */
    String XSD_SCHEMA_FACTORY_CLASS = "de.elomagic.xsdmodel.xsd_factory_class";

    /**
     * Method to create a {@link Schema} for validation.
     *
     * @return The {@link Schema} or null to disable schema validation
     * @throws XsdSchemaException Thrown when unable to create a {@link Schema}
     */
    Schema createSchema() throws XsdSchemaException;

}
