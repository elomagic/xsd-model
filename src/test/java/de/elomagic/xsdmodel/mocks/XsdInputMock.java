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

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

import org.w3c.dom.ls.LSInput;

public class XsdInputMock implements LSInput {

    private final String publicId;
    private final String systemId;
    private final String baseURI;

    public XsdInputMock(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
        this.publicId = publicId;
        this.systemId = systemId;
        this.baseURI = baseURI;
    }

    @Override
    public Reader getCharacterStream() {
        return null;
    }

    @Override
    public void setCharacterStream(Reader characterStream) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public InputStream getByteStream() {
        try {
            URL url;
            switch(systemId) {
                case "XMLSchema.dtd":
                    url = XsdInputMock.class.getResource("/XMLSchema.dtd");
                    break;
                case "datatypes.dtd":
                    url = XsdInputMock.class.getResource("/datatypes.dtd");
                    break;
                case "http://www.w3.org/2001/xml.xsd":
                    url = XsdInputMock.class.getResource("/xml.xsd");
                    break;

                default:
                    throw new IOException("Unsupported system ID resource \"" + systemId + "\".");

            }

            URLConnection con = url.openConnection();
            return con.getInputStream();
        } catch(IOException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    @Override
    public void setByteStream(InputStream byteStream) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getStringData() {
        return null;
    }

    @Override
    public void setStringData(String stringData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getSystemId() {
        return systemId;
    }

    @Override
    public void setSystemId(String systemId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getPublicId() {
        return publicId;
    }

    @Override
    public void setPublicId(String publicId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getBaseURI() {
        return baseURI;
    }

    @Override
    public void setBaseURI(String baseURI) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getEncoding() {
        return null;
    }

    @Override
    public void setEncoding(String encoding) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean getCertifiedText() {
        return false;
    }

    @Override
    public void setCertifiedText(boolean certifiedText) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
