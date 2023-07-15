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
package de.elomagic.xsdmodel.elements.impl;

import java.net.URI;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.elomagic.xsdmodel.adapter.AnyURIDataTypeAdapter;
import de.elomagic.xsdmodel.elements.XsdDocumentation;

/**
 *
 * @author Carsten Rambow
 */
@XmlAccessorType(XmlAccessType.NONE)
public final class XsdDocumentationImpl implements XsdDocumentation, ElementSetParent {

    private AbstractElement parent;

    @XmlAttribute
    @XmlJavaTypeAdapter(AnyURIDataTypeAdapter.class)
    private URI source;
    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
    private String language;

    @XmlValue
    private String value;

    @Override
    public URI getSource() {
        return source;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public AbstractElement getParent() {
        return parent;
    }

    @Override
    public void setParent(AbstractElement parent) {
        this.parent = parent;
    }

}
