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

    private String xsdSchemaFactoryClass = System.getProperty(XsdSchemaFactory.XSD_SCHEMA_FACTORY_CLASS, DefaultSchemaFactory.class.getName());
    private boolean validateSchema = true;
    private JAXBContext context;

    /**
     * Returns the mode for schema validation.
     *
     * Default is true
     *
     * @return Returns schema validation mode
     */
    public boolean isValidateSchema() {
        return validateSchema;
    }

    /**
     * Set the schema validation mode.
     *
     * Disabling can be a performance booster
     *
     * When true then XSD itself will be validated against
     * @param validateSchema True when
     */
    public void setValidateSchema(boolean validateSchema) {
        this.validateSchema = validateSchema;
    }

    /**
     * Returns the schema factory class.
     *
     * Default {@link DefaultSchemaFactory}
     *
     * @return Returns the schema factory class of this instance.
     */
    public String getXsdSchemaFactoryClass() {
        return xsdSchemaFactoryClass;
    }

    /**
     * Set a schema factory class.
     *
     * Useful to set an alternative schema factory class.
     *
     * @param xsdSchemaFactoryClass Class name
     */
    public void setXsdSchemaFactoryClass(String xsdSchemaFactoryClass) {
        this.xsdSchemaFactoryClass = xsdSchemaFactoryClass;
    }

    /**
     * Set a schema factory class.
     *
     * Useful to set an alternative schema factory class.
     *
     * @param xsdSchemaFactoryClass Class name
     */
    public void setXsdSchemaFactoryClass(Class<XsdSchemaFactory> xsdSchemaFactoryClass) {
        setXsdSchemaFactoryClass(xsdSchemaFactoryClass == null ? null : xsdSchemaFactoryClass.getName());
    }

    private Schema createSchema() {

        if(xsdSchemaFactoryClass == null || xsdSchemaFactoryClass.isEmpty()) {
            return null;
        }

        Schema schema;
        try {
            Class<? extends XsdSchemaFactory> clazz = (Class<? extends XsdSchemaFactory>)Class.forName(xsdSchemaFactoryClass);
            XsdSchemaFactory factory = clazz.getDeclaredConstructor().newInstance();
            schema = factory.createSchema();
        } catch(Exception ex) {
            throw new XsdModelRuntimeException(ex.getMessage(), ex);
        }

        return schema;
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
    public XsdSchema readXsd(Reader reader) throws JAXBException {
        if (context == null) {
            context = JAXBContext.newInstance(DEFAULT_ROOT_CLASS);
        }

        Unmarshaller u = context.createUnmarshaller();

        if (validateSchema) {
            u.setSchema(createSchema());
        }

        return (XsdSchema)u.unmarshal(reader);
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
        XsdReader xsdReader = new XsdReader();
        return xsdReader.readXsd(reader);
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

}
