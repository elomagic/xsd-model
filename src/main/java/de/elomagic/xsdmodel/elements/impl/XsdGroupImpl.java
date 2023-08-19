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

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.elomagic.xsdmodel.adapter.NonNegativeIntegerAdapter;
import de.elomagic.xsdmodel.elements.XsdGroup;

import org.jetbrains.annotations.Nullable;

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
    private String maxOccurs;
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
    public XsdGroupImpl setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getMaxOccurs() {
        return maxOccurs;
    }

    @Override
    public void setMaxOccurs(String maxOccurs) {
        this.maxOccurs = maxOccurs;
    }

    @Override
    public Integer getMinOccurs() {
        return minOccurs;
    }

    @Override
    public void setMinOccurs(Integer minOccurs) {
        this.minOccurs = minOccurs;
    }

    @Override
    public String getRef() {
        return ref;
    }

    @Override
    public void setRef(@Nullable String ref) {
        this.ref = ref;
    }

}
