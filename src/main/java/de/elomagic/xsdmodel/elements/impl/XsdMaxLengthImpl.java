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

import de.elomagic.xsdmodel.adapter.BooleanDataTypeAdapter;
import de.elomagic.xsdmodel.adapter.NonNegativeIntegerAdapter;
import de.elomagic.xsdmodel.elements.XsdAnnotation;
import de.elomagic.xsdmodel.elements.XsdMaxLength;

import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Carsten Rambow
 */
public class XsdMaxLengthImpl extends AbstractElement implements XsdMaxLength {

    @XmlAttribute
    private String id;
    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanDataTypeAdapter.class)
    private Boolean fixed;
    @XmlAttribute
    @XmlJavaTypeAdapter(NonNegativeIntegerAdapter.class)
    private Integer value;

    @XmlElement
    private XsdAnnotationImpl annotation;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Boolean getFixed() {
        return fixed;
    }

    @Override
    public XsdMaxLength setFixed(Boolean fixed) {
        this.fixed = fixed;
        return this;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public XsdAnnotation getAnnotation() {
        return annotation;
    }

    @Override
    @NotNull
    public XsdMaxLength setAnnotation(XsdAnnotation annotation) {
        this.annotation = (XsdAnnotationImpl) annotation;
        return this;
    }

}
