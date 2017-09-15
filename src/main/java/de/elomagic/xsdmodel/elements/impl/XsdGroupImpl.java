/*
 * XSD Model
 * Copyright (c) 2017-2017 Carsten Rambow
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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.elomagic.xsdmodel.adapter.MaxOccursAttributeAdapter;
import de.elomagic.xsdmodel.adapter.NonNegativeIntegerAdapter;
import de.elomagic.xsdmodel.elements.XsdGroup;

/**
 *
 * @author Carsten Rambow
 */
public class XsdGroupImpl extends AbstractElement implements XsdGroup {

    @XmlAttribute
    private String id;
    @XmlAttribute
    private String name;
    @XmlAttribute
    @XmlJavaTypeAdapter(NonNegativeIntegerAdapter.class)
    private Integer minOccurs;
    @XmlAttribute
    @XmlJavaTypeAdapter(MaxOccursAttributeAdapter.class)
    private Integer maxOccurs;
    @XmlAttribute
    private String ref;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
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
    public String getRef() {
        return ref;
    }

}
