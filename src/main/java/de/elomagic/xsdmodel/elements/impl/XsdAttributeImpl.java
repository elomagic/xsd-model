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

import de.elomagic.xsdmodel.elements.XsdAttribute;

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
    private String form;
    @XmlAttribute
    private String type;
    @XmlAttribute
    private String use;
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
    public String getType() {
        return type;
    }

    @Override
    public String getUse() {
        return use;
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
    public XsdAnnotationImpl getAnnotation() {
        setParentInProperty(annotation);
        return annotation;
    }

    @Override
    public String getFixed() {
        return fixed;
    }

    @Override
    public String getForm() {
        return form;
    }

    @Override
    public String toString() {
        return super.toString() + ";id=" + id + ";name=" + name + ";type=" + type;
    }

}
