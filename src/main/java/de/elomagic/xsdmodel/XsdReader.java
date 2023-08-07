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
package de.elomagic.xsdmodel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;

import de.elomagic.xsdmodel.elements.XsdSchema;
import de.elomagic.xsdmodel.elements.impl.XsdSchemaImpl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Helper class to read XSD's from different sources.
 *
 * @author Carsten Rambow
 */
public final class XsdReader {

    private static final Class<XsdSchemaImpl> DEFAULT_ROOT_CLASS = XsdSchemaImpl.class;

    private String xsdSchemaFactoryClass = DefaultSchemaFactory.class.getName();
    private boolean validateSchema = true;
    private JAXBContext context;

    /**
     * Returns the mode for schema validation.
     * <p>
     * Default is true
     *
     * @return Returns schema validation mode
     */
    public boolean isValidateSchema() {
        return validateSchema;
    }

    /**
     * Set the schema validation mode.
     * <p>
     * Disabling can be a performance booster
     * <p>
     * When true then XSD itself will be validated against
     * @param validateSchema True when
     * @return Returns this instance
     */
    @NotNull
    public XsdReader setValidateSchema(boolean validateSchema) {
        this.validateSchema = validateSchema;
        return this;
    }

    /**
     * Returns the schema factory class.
     * <p>
     * Default {@link DefaultSchemaFactory}
     *
     * @return Returns the schema factory class of this instance.
     */
    @Nullable
    public String getXsdSchemaFactoryClass() {
        return xsdSchemaFactoryClass;
    }

    /**
     * Set a schema factory class.
     * <p>
     * Useful to set an alternative schema factory class.
     *
     * @param xsdSchemaFactoryClass Class name
     *                              @return Returns the schema factory class of this instance.
     */
    @NotNull
    public XsdReader setXsdSchemaFactoryClass(@Nullable String xsdSchemaFactoryClass) {
        this.xsdSchemaFactoryClass = xsdSchemaFactoryClass;
        return this;
    }

    /**
     * Set a schema factory class.
     * <p>
     * Useful to set an alternative schema factory class.
     *
     * @param xsdSchemaFactoryClass Class name
     * @return Returns the schema factory class of this instance.
     */
    public XsdReader setXsdSchemaFactoryClass(@Nullable Class<XsdSchemaFactory> xsdSchemaFactoryClass) {
        setXsdSchemaFactoryClass(xsdSchemaFactoryClass == null ? null : xsdSchemaFactoryClass.getName());
        return this;
    }

    @Nullable
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
     * @throws jakarta.xml.bind.JAXBException Thrown when unable to parse the XSD.
     */
    @NotNull
    public XsdSchema readXsd(@NotNull Reader reader) throws JAXBException {
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
     * @throws jakarta.xml.bind.JAXBException Thrown when unable to parse the XSD.
     * @throws java.io.IOException Thrown when unable to read from the source.
     */
    @NotNull
    public static XsdSchema read(@NotNull Path filename) throws JAXBException, IOException {
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
     * @throws jakarta.xml.bind.JAXBException Thrown when unable to parse the XSD.
     * @throws java.io.IOException Thrown when unable to read from the source.
     */
    @NotNull
    public static XsdSchema read(@NotNull InputStream in) throws JAXBException, IOException {
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
     * @throws jakarta.xml.bind.JAXBException Thrown when unable to parse the XSD.
     */
    @NotNull
    public static XsdSchema read(@NotNull Reader reader) throws JAXBException {
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
     * @throws jakarta.xml.bind.JAXBException Thrown when unable to parse the XSD.
     * @throws java.io.IOException Thrown when unable to read from the source.
     */
    @NotNull
    public static XsdSchema read(@NotNull File file) throws JAXBException, IOException {
        return read(file.toPath());
    }

}
