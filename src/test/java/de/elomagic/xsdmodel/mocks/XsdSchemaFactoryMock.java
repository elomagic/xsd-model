/*
 * XSD Model (Java 11)
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
package de.elomagic.xsdmodel.mocks;

import de.elomagic.xsdmodel.XsdSchemaException;
import de.elomagic.xsdmodel.XsdSchemaFactory;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

public class XsdSchemaFactoryMock implements XsdSchemaFactory {

    @Override
    public Schema createSchema() throws XsdSchemaException {
        try {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            sf.setResourceResolver(XsdInputMock::new);
            return sf.newSchema(XsdSchemaFactoryMock.class.getResource("/XMLSchema.xsd"));
        } catch (Exception ex) {
            throw new XsdSchemaException(ex.getMessage(), ex);
        }
    }

}
