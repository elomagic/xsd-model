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
package de.elomagic.xsdmodel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.elomagic.xsdmodel.elements.XsdElement;
import de.elomagic.xsdmodel.elements.XsdSchema;
import de.elomagic.xsdmodel.mocks.XsdSchemaFactoryMock;
import de.elomagic.xsdmodel.prototype.Flatter;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

class XsdReaderTest {

    @Test
    void testRead() throws Exception {
        System.setProperty(XsdSchemaFactory.XSD_SCHEMA_FACTORY_CLASS, XsdSchemaFactoryMock.class.getName());

        XsdSchema schema = XsdReader.read(getClass().getResourceAsStream("/root2.xsd"));

        Assertions.assertEquals("Documentation of the schema annotation.", schema.getAnnotation().getDocumentation().getValue());
        Assertions.assertEquals(12, schema.getComplexTypes().size());
    }

    @Test
    void testSomethingResearch() throws Exception {
        System.setProperty(XsdSchemaFactory.XSD_SCHEMA_FACTORY_CLASS, XsdSchemaFactoryMock.class.getName());

        XsdSchema schema = XsdReader.read(Path.of("excluded/fax-default.xsd"));

        Flatter flatter = new Flatter();
        flatter.flattXsd(schema);
    }

}
