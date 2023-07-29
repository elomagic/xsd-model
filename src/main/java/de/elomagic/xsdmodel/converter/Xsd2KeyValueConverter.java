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
package de.elomagic.xsdmodel.converter;

import jakarta.xml.bind.JAXBException;

import de.elomagic.xsdmodel.NotSupportedYetException;
import de.elomagic.xsdmodel.XsdReader;
import de.elomagic.xsdmodel.elements.XsdSchema;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Map;

/**
 * Very small tooling class to map a simple XSD into a key properties map.
 */
public class Xsd2KeyValueConverter {

    /**
     * Reads an XSD file and converts as a very simple key properties {@link Map}.
     *
     * @param file File to read
     * @return Returns a map but never null
     * @throws JAXBException Thrown when unable to parse the XSD document
     * @throws IOException Thrown when unable to read XML document from the input stream
     */
    @NotNull
    public Map<String, KeyProperties> convert(@NotNull Path file) throws JAXBException, IOException {
        return convert(XsdReader.read(file));
    }

    /**
     * Reads an XSD document from an {@link InputStream} and converts as a very simple key properties {@link Map}.
     *
     * @param in Input stream where to read the XSD document
     * @return Returns a map but never null
     * @throws JAXBException Thrown when unable to parse the XSD document
     * @throws IOException Thrown when unable to read XML document from the input stream
     */
    @NotNull
    public Map<String, KeyProperties> convert(@NotNull InputStream in) throws JAXBException, IOException {
        return convert(XsdReader.read(in));
    }

    /**
     * Converts an {@link XsdSchema} into a very simple key properties {@link Map}.
     *
     * @param schema An {@link XsdSchema}
     * @return Returns a map but never null
     */
    @NotNull
    public Map<String, KeyProperties> convert(@NotNull XsdSchema schema) {

        throw new NotSupportedYetException();

    }


}
