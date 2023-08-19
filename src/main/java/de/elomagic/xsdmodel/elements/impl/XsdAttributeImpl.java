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

import de.elomagic.xsdmodel.adapter.FormAttributeAdapter;
import de.elomagic.xsdmodel.adapter.UseValueAdapter;
import de.elomagic.xsdmodel.elements.XsdAnnotation;
import de.elomagic.xsdmodel.elements.XsdAttribute;
import de.elomagic.xsdmodel.enumerations.Form;
import de.elomagic.xsdmodel.enumerations.Use;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 *
 * @author Carsten Rambow
 */
public class XsdAttributeImpl extends AbstractElement implements XsdAttribute {

    @XmlAttribute
    private String id;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String fixed;
    @XmlAttribute
    @XmlJavaTypeAdapter(FormAttributeAdapter.class)
    private Form form;
    @XmlAttribute
    private String type;
    @XmlAttribute
    @XmlJavaTypeAdapter(UseValueAdapter.class)
    private Use use;
    @XmlAttribute(name = "default")
    private String defaultValue;
    @XmlAttribute
    private String ref;

    @XmlElement
    private XsdAnnotationImpl annotation;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public XsdAttributeImpl setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public XsdAttributeImpl setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public Use getUse() {
        return use;
    }

    @Override
    public String getDefault() {
        return defaultValue;
    }

    @Override
    public XsdAttributeImpl setDefault(@Nullable String value) {
        this.defaultValue = value;
        return this;
    }

    @Override
    public String getRef() {
        return ref;
    }

    @Override
    public XsdAnnotationImpl getAnnotation() {
        setParentInProperty(annotation);
        return annotation;
    }

    @Override
    @NotNull
    public XsdAnnotation createAnnotation() {
        annotation = new XsdAnnotationImpl();
        annotation.setParent(this);
        return annotation;
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
    public String toString() {
        return super.toString() + ";id=" + id + ";name=" + name + ";type=" + type;
    }

}
