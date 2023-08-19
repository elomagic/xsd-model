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

import jakarta.xml.bind.annotation.XmlElement;

import de.elomagic.xsdmodel.elements.XsdAnnotation;
import de.elomagic.xsdmodel.elements.XsdPattern;

import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Carsten Rambow
 */
public class XsdPatternImpl extends AbstractValueElement implements XsdPattern {

    @XmlElement
    private XsdAnnotationImpl annotation;

    @Override
    public XsdAnnotation getAnnotation() {
        return annotation;
    }

    @Override
    @NotNull
    public XsdPattern setAnnotation(XsdAnnotation annotation) {
        this.annotation = (XsdAnnotationImpl) annotation;
        return this;
    }

}
