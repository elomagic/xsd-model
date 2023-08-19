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
import de.elomagic.xsdmodel.adapter.FormAttributeAdapter;
import de.elomagic.xsdmodel.adapter.NonNegativeIntegerAdapter;
import de.elomagic.xsdmodel.elements.XsdAnnotation;
import de.elomagic.xsdmodel.elements.XsdComplexType;
import de.elomagic.xsdmodel.elements.XsdElement;
import de.elomagic.xsdmodel.elements.XsdSimpleType;
import de.elomagic.xsdmodel.enumerations.Block;
import de.elomagic.xsdmodel.enumerations.Final;
import de.elomagic.xsdmodel.enumerations.Form;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
    private String maxOccurs;
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
    public XsdElementImpl setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public XsdElementImpl setType(String type) {
        this.type = type;
        return this;
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
    public String getMaxOccurs() {
        return maxOccurs;
    }

    @Override
    public void setMaxOccurs(String maxOccurs) {
        this.maxOccurs = maxOccurs;
    }

    @Override
    public String getDefault() {
        return defaultValue;
    }

    @Override
    @NotNull
    public XsdElement setDefault(@Nullable String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
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
    @NotNull
    public XsdElement setAnnotation(@Nullable XsdAnnotation annotation) {
        this.annotation = (XsdAnnotationImpl) annotation;
        return this;
    }

    @Override
    public XsdSimpleTypeImpl getSimpleType() {
        setParentInProperty(simpleType);
        return simpleType;
    }

    public void setSimpleType(@Nullable XsdSimpleType simpleType) {
        this.simpleType = (XsdSimpleTypeImpl) simpleType;
    }

    @NotNull
    @Override
    public XsdSimpleTypeImpl createSimpleType() {
        XsdSimpleTypeImpl st = new XsdSimpleTypeImpl();
        st.setParent(this);
        setSimpleType(st);
        return st;
    }

    @Override
    public XsdComplexTypeImpl getComplexType() {
        setParentInProperty(complexType);
        return complexType;
    }

    public void setComplexType(@Nullable XsdComplexType complexType) {
        this.complexType = (XsdComplexTypeImpl) complexType;
    }

    @NotNull
    @Override
    public XsdComplexTypeImpl createComplexType() {
        XsdComplexTypeImpl ct = new XsdComplexTypeImpl();
        setComplexType(ct);
        ct.setParent(this);
        return ct;
    }

    @Override
    public List<XsdUniqueImpl> getUniques() {
        setParentInList(uniques);
        return uniques;
    }

    @Override
    public List<XsdKeyImpl> getKeys() {
        setParentInList(keys);
        return keys;
    }

    @Override
    public List<XsdKeyrefImpl> getKeyrefs() {
        setParentInList(keyrefs);
        return keyrefs;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name='" + name + "';type='" + type + "';id='" + id + "'}";
    }

}
