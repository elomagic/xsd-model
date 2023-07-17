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
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.elomagic.xsdmodel.adapter.BlockValueAdapter;
import de.elomagic.xsdmodel.adapter.BooleanDataTypeAdapter;
import de.elomagic.xsdmodel.adapter.FinalValueAdapter;
import de.elomagic.xsdmodel.elements.XsdComplexContent;
import de.elomagic.xsdmodel.elements.XsdComplexType;
import de.elomagic.xsdmodel.elements.XsdSimpleContent;
import de.elomagic.xsdmodel.enumerations.Block;
import de.elomagic.xsdmodel.enumerations.Final;

/**
 *
 * @author Carsten Rambow
 */
public class XsdComplexTypeImpl extends AbstractElement implements XsdComplexType {

    @XmlAttribute
    private String id;
    @XmlAttribute(name = "abstract")
    @XmlJavaTypeAdapter(BooleanDataTypeAdapter.class)
    private Boolean abstractValue;
    @XmlAttribute
    private String name;
    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanDataTypeAdapter.class)
    private Boolean mixed;
    @XmlAttribute
    @XmlJavaTypeAdapter(BlockValueAdapter.class)
    private Block block;
    @XmlAttribute(name = "final")
    @XmlJavaTypeAdapter(FinalValueAdapter.class)
    private Final finalValue;

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
    public Boolean getAbstract() {
        return abstractValue;
    }

    @Override
    public Boolean getMixed() {
        return mixed;
    }

    @Override
    public Block getBlock() {
        return block;
    }

    @Override
    public Final getFinal() {
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
