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
package de.elomagic.xsdmodel.elements.impl;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import de.elomagic.xsdmodel.elements.XsdAnnotation;
import de.elomagic.xsdmodel.elements.XsdAppInfo;

/**
 *
 * @author Carsten Rambow
 */
public class XsdAnnotationImpl extends AbstractElement implements XsdAnnotation {

    @XmlAttribute
    private String id;

    @XmlElement
    private XsdDocumentationImpl documentation;
    @XmlElement(name = "appinfo")
    private XsdAppInfoImpl appInfo;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public XsdDocumentationImpl getDocumentation() {
        setParentInProperty(documentation);
        return documentation;
    }

    @Override
    public XsdAppInfo getAppInfo() {
        return appInfo;
    }

}
