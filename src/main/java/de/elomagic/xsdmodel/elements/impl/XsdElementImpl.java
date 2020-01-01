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

import de.elomagic.xsdmodel.adapter.BlockValueAdapter;
import de.elomagic.xsdmodel.adapter.BooleanDataTypeAdapter;
import de.elomagic.xsdmodel.adapter.FinalValueAdapter;
import de.elomagic.xsdmodel.adapter.FormAttributeAdapter;
import de.elomagic.xsdmodel.adapter.MaxOccursAttributeAdapter;
import de.elomagic.xsdmodel.adapter.NonNegativeIntegerAdapter;
import de.elomagic.xsdmodel.elements.XsdElement;
import de.elomagic.xsdmodel.elements.XsdKey;
import de.elomagic.xsdmodel.elements.XsdKeyref;
import de.elomagic.xsdmodel.elements.XsdUnique;
import de.elomagic.xsdmodel.enumerations.Block;
import de.elomagic.xsdmodel.enumerations.Final;
import de.elomagic.xsdmodel.enumerations.Form;

/**
 *
 * @author Carsten Rambow
 */
public class XsdElementImpl extends AbstractElement implements XsdElement {

    @XmlAttribute
    private String id;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String type;
    @XmlAttribute
    private String substitutionGroup;
    @XmlAttribute
    private String fixed;
    @XmlAttribute
    @XmlJavaTypeAdapter(FormAttributeAdapter.class)
    private Form form;
    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanDataTypeAdapter.class)
    private Boolean nillable;
    @XmlAttribute(name = "abstract")
    @XmlJavaTypeAdapter(BooleanDataTypeAdapter.class)
    private Boolean abstractValue;
    @XmlAttribute
    @XmlJavaTypeAdapter(BlockValueAdapter.class)
    private Block block;
    @XmlAttribute(name = "final")
    @XmlJavaTypeAdapter(FinalValueAdapter.class)
    private Final finalValue;
    @XmlAttribute
    @XmlJavaTypeAdapter(NonNegativeIntegerAdapter.class)
    private Integer minOccurs;
    @XmlAttribute
    @XmlJavaTypeAdapter(MaxOccursAttributeAdapter.class)
    private Integer maxOccurs;
    @XmlAttribute(name = "default")
    private String defaultValue;
    @XmlAttribute
    private String ref;

    @XmlElement
    private XsdAnnotationImpl annotation;
    @XmlElement
    private XsdSimpleTypeImpl simpleType;
    @XmlElement
    private XsdComplexTypeImpl complexType;
    @XmlElement(name = "unique")
    private List<XsdUniqueImpl> uniques;
    @XmlElement(name = "key")
    private List<XsdKeyImpl> keys;
    @XmlElement(name = "keyref")
    private List<XsdKeyrefImpl> keyrefs;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Integer getMinOccurs() {
        return minOccurs;
    }

    @Override
    public Integer getMaxOccurs() {
        return maxOccurs;
    }

    @Override
    public String getDefault() {
        return defaultValue;
    }

    @Override
    public String getRef() {
        return ref;
    }

    @Override
    public String getSubstitutionGroup() {
        return substitutionGroup;
    }

    @Override
    public String getFixed() {
        return fixed;
    }

    @Override
    public Form getForm() {
        return form;
    }

    @Override
    public Boolean getNillable() {
        return nillable;
    }

    @Override
    public Boolean getAbstract() {
        return abstractValue;
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
    public XsdAnnotationImpl getAnnotation() {
        setParentInProperty(annotation);
        return annotation;
    }

    @Override
    public XsdSimpleTypeImpl getSimpleType() {
        setParentInProperty(simpleType);
        return simpleType;
    }

    @Override
    public XsdComplexTypeImpl getComplexType() {
        setParentInProperty(complexType);
        return complexType;
    }

    @Override
    public List<? extends XsdUnique> getUniques() {
        setParentInList(uniques);
        return uniques;
    }

    @Override
    public List<? extends XsdKey> getKeys() {
        setParentInList(keys);
        return keys;
    }

    @Override
    public List<? extends XsdKeyref> getKeyrefs() {
        setParentInList(keyrefs);
        return keyrefs;
    }

    @Override
    public String toString() {
        return super.toString() + ";id=" + id + ";name=" + name + ";type=" + type;
    }

}
