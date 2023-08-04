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

import de.elomagic.xsdmodel.elements.XsdSchema;
import de.elomagic.xsdmodel.mocks.XsdSchemaFactoryMock;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XsdReaderTest {

    @Test
    void testRead() throws Exception {
        XsdSchema schema = new XsdReader()
                .setXsdSchemaFactoryClass(XsdSchemaFactoryMock.class.getName())
                .readXsd(new InputStreamReader(getClass().getResourceAsStream("/example.xsd")));
        System.out.println("ns=" + String.join(", ", schema.getXmlns().keySet()));

        //assertEquals("http://www.w3.org/2001/XMLSchema", schema.getXmlns().get("xmlns:xs").toString());
        
        assertEquals("Documentation of the schema annotation.", schema.getAnnotation().getDocumentation().getValue());
        assertEquals(12, schema.getComplexTypes().size());
    }

}
