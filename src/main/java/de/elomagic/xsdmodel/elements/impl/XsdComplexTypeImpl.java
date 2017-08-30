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
import javax.xml.bind.annotation.XmlElement;

import de.elomagic.xsdmodel.elements.XsdComplexContent;
import de.elomagic.xsdmodel.elements.XsdComplexType;
import de.elomagic.xsdmodel.elements.XsdSimpleContent;

/**
 *
 * @author Carsten Rambow
 */
public class XsdComplexTypeImpl extends AbstractElement implements XsdComplexType {

    @XmlAttribute
    private String id;
    @XmlAttribute(name = "abstract")
    private String abstractValue;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String mixed;
    @XmlAttribute
    private String block;
    @XmlAttribute(name = "final")
    private String finalValue;

    @XmlElement
    private XsdSimpleContentImpl simpleContent;
    @XmlElement
    private XsdComplexContentImpl complexContent;
    @XmlElement
    private XsdAllImpl all;
    @XmlElement
    private XsdSequenceImpl sequence;
    @XmlElement
    private XsdChoiceImpl choice;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAbstract() {
        return abstractValue;
    }

    @Override
    public String getMixed() {
        return mixed;
    }

    @Override
    public String getBlock() {
        return block;
    }

    @Override
    public String getFinal() {
        return finalValue;
    }

    @Override
    public XsdSimpleContent getSimpleContent() {
        return simpleContent;
    }

    @Override
    public XsdComplexContent getComplexContent() {
        return complexContent;
    }

    @Override
    public XsdAllImpl getAll() {
        setParentInProperty(all);
        return all;
    }

    @Override
    public XsdSequenceImpl getSequence() {
        setParentInProperty(sequence);
        return sequence;
    }

    @Override
    public XsdChoiceImpl getChoice() {
        setParentInProperty(choice);
        return choice;
    }

    @Override
    public String toString() {
        return super.toString() + ";name=" + name;
    }

}
