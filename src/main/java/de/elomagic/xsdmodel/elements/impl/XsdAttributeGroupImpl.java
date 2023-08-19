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
package de.elomagic.xsdmodel.elements.impl;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import de.elomagic.xsdmodel.elements.XsdAttributeGroup;

/**
 *
 * @author Carsten Rambow
 */
public class XsdAttributeGroupImpl extends AbstractElement implements XsdAttributeGroup {

    @XmlAttribute
    private String id;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String ref;

    @XmlElement(name = "attributeGroup")
    private List<XsdAttributeGroupImpl> attributeGroups;
    @XmlElement(name = "attribute")
    private List<XsdAttributeImpl> attributes;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public XsdAttributeGroupImpl setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getRef() {
        return ref;
    }

    @Override
    public List<XsdAttributeGroupImpl> getAttributeGroups() {
        setParentInList(attributeGroups);
        return attributeGroups;
    }

    @Override
    public List<XsdAttributeImpl> getAttributes() {
        setParentInList(attributes);
        return attributes;
    }

}
