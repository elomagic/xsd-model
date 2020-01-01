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
import de.elomagic.xsdmodel.elements.XsdList;
import de.elomagic.xsdmodel.elements.XsdSimpleType;
import de.elomagic.xsdmodel.elements.XsdUnion;

/**
 *
 * @author Carsten Rambow
 */
public class XsdSimpleTypeImpl extends AbstractElement implements XsdSimpleType {

    @XmlAttribute(name = "final")
    private String finalValue;
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String name;

    @XmlElement
    private XsdRestrictionImpl restriction;
    @XmlElement
    private XsdListImpl list;
    @XmlElement
    private XsdUnionImpl union;
    @XmlElement
    private XsdAnnotationImpl annotation;

    @Override
    public String getFinal() {
        return finalValue;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public XsdRestrictionImpl getRestriction() {
        setParentInProperty(restriction);
        return restriction;
    }

    @Override
    public XsdList getList() {
        setParentInProperty(list);
        return list;
    }

    @Override
    public XsdUnion getUnion() {
        setParentInProperty(union);
        return union;
    }

    @Override
    public XsdAnnotation getAnnotation() {
        return annotation;
    }
}
