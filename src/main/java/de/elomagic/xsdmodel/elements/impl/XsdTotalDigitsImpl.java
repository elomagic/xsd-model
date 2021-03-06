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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.elomagic.xsdmodel.adapter.BooleanDataTypeAdapter;
import de.elomagic.xsdmodel.adapter.PositiveIntegerAdapter;
import de.elomagic.xsdmodel.elements.XsdAnnotation;
import de.elomagic.xsdmodel.elements.XsdTotalDigits;

/**
 *
 * @author Carsten Rambow
 */
public class XsdTotalDigitsImpl extends AbstractElement implements XsdTotalDigits {

    @XmlAttribute
    @XmlJavaTypeAdapter(PositiveIntegerAdapter.class)
    private Integer value;
    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanDataTypeAdapter.class)
    private Boolean fixed;

    @XmlElement
    private XsdAnnotationImpl annotation;

    @Override
    public Boolean getFixed() {
        return fixed;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public XsdAnnotation getAnnotation() {
        return annotation;
    }

}
