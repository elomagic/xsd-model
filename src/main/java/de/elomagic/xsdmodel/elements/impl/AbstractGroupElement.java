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

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.elomagic.xsdmodel.adapter.MaxOccursAttributeAdapter;
import de.elomagic.xsdmodel.adapter.NonNegativeIntegerAdapter;
import de.elomagic.xsdmodel.elements.ElementGroup;

/**
 *
 * @author Carsten Rambow
 */
public abstract class AbstractGroupElement extends AbstractElement implements ElementGroup {

    @XmlAttribute
    private String id;
    @XmlAttribute
    @XmlJavaTypeAdapter(MaxOccursAttributeAdapter.class)
    private Integer maxOccurs;
    @XmlAttribute
    @XmlJavaTypeAdapter(NonNegativeIntegerAdapter.class)
    private Integer minOccurs;

    @XmlElement(name = "element")
    private List<XsdElementImpl> elements;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Integer getMaxOccurs() {
        return maxOccurs;
    }

    @Override
    public Integer getMinOccurs() {
        return minOccurs;
    }

    @Override
    public List<XsdElementImpl> getElements() {
        setParentInList(elements);
        return elements;
    }

}
