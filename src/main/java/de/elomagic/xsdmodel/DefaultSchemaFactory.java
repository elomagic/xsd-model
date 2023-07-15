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

import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

/**
 * Default implementation of the {@link XsdSchemaFactory}.
 * <p>
 * This factory will be used by default and load the required XSD from remote source.
 *
 * @author Carsten Rambow
 */
public final class DefaultSchemaFactory implements XsdSchemaFactory {

    @Override
    public Schema createSchema() throws XsdSchemaException {
        try {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            sf.setResourceResolver(XsdInput::new);
            return sf.newSchema(new URL(XsdInput.URL_XMLSCHEMA_XSD));
        } catch (Exception ex) {
            throw new XsdSchemaException(ex.getMessage(), ex);
        }
    }

}
