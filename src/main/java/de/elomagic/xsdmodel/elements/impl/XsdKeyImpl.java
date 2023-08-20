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
import jakarta.xml.bind.annotation.XmlElement;

import de.elomagic.xsdmodel.elements.XsdKey;
import de.elomagic.xsdmodel.elements.XsdSelector;

import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Carsten Rambow
 */
public class XsdKeyImpl extends AbstractElement implements XsdKey {

    @XmlAttribute
    private String id;
    @XmlAttribute(required = true)
    private String name;

    @XmlElement
    private XsdSelectorImpl selector;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public XsdKeyImpl setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public XsdSelector getSelector() {
        setParentInProperty(selector);
        return selector;
    }

    @Override
    @NotNull
    public XsdSelectorImpl createSelector() {
        selector = new XsdSelectorImpl();
        selector.setParent(this);
        return selector;
    }

}
