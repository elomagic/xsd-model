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
package de.elomagic.xsdmodel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;

import de.elomagic.xsdmodel.elements.XsdSchema;
import de.elomagic.xsdmodel.elements.impl.XsdSchemaImpl;

/**
 * Helper class to read XSD's from different sources.
 *
 * @author Carsten Rambow
 */
public final class XsdReader {

    private static final Class<XsdSchemaImpl> DEFAULT_ROOT_CLASS = XsdSchemaImpl.class;

    private XsdReader() {
    }

    /**
     * Read the XSD file into a XSD object model including validating against the XSD.
     * <p>
     * XSD must be UTF-8 encoded.
     *
     * @param filename Name of the XSD file source.
     * @return Returns a {@link XsdSchema}
     * @throws javax.xml.bind.JAXBException Thrown when unable to parse the XSD.
     * @throws java.io.IOException Thrown when unable to read from the source.
     */
    public static XsdSchema read(Path filename) throws JAXBException, IOException {
        try (Reader reader = Files.newBufferedReader(filename, StandardCharsets.UTF_8)) {
            return read(reader);
        }
    }

    /**
     * Read the XSD from the {@link InputStream} into a XSD object model including validating against the XSD.
     * <p>
     * XSD must be UTF-8 encoded.
     *
     * @param in {@link InputStream} source of the XSD
     * @return Returns a {@link XsdSchema}
     * @throws javax.xml.bind.JAXBException Thrown when unable to parse the XSD.
     * @throws java.io.IOException Thrown when unable to read from the source.
     */
    public static XsdSchema read(InputStream in) throws JAXBException, IOException {
        try (Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
            return read(reader);
        }
    }

    /**
     * Read the XSD from the {@link Reader} into a XSD object model including validating against the XSD.
     * <p>
     * XSD must be UTF-8 encoded.
     *
     * @param reader {@link Reader} of the XSD source.
     * @return Returns a {@link XsdSchema}
     * @throws javax.xml.bind.JAXBException Thrown when unable to parse the XSD.
     */
    public static XsdSchema read(Reader reader) throws JAXBException {
        Schema schema = createSchema();

        JAXBContext context = JAXBContext.newInstance(DEFAULT_ROOT_CLASS);
        Unmarshaller u = context.createUnmarshaller();
        u.setSchema(schema);

        return (XsdSchema)u.unmarshal(reader);
    }

    /**
     * Read the XSD from the {@link File} into a XSD object model including validating against the XSD.
     * <p>
     * XSD must be UTF-8 encoded.
     *
     * @param file {@link File} of the XSD source.
     * @return Returns a {@link XsdSchema}
     * @throws javax.xml.bind.JAXBException Thrown when unable to parse the XSD.
     * @throws java.io.IOException Thrown when unable to read from the source.
     */
    public static XsdSchema read(File file) throws JAXBException, IOException {
        return read(file.toPath());
    }

    private static Schema createSchema() throws XsdModelRuntimeException {

        String className = System.getProperty(XsdSchemaFactory.XSD_SCHEMA_FACTORY_CLASS, DefaultSchemaFactory.class.getName());

        if(className == null || className.isEmpty()) {
            return null;
        }

        Schema schema;
        try {
            Class<? extends XsdSchemaFactory> clazz = (Class<? extends XsdSchemaFactory>)Class.forName(className);
            XsdSchemaFactory factory = clazz.getDeclaredConstructor().newInstance();
            schema = factory.createSchema();
        } catch(Exception ex) {
            throw new XsdModelRuntimeException(ex.getMessage(), ex);
        }

        return schema;
    }

}
