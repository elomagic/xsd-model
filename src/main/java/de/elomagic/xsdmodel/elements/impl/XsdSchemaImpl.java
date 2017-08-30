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

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import de.elomagic.xsdmodel.elements.XsdSchema;

/**
 *
 * @author Carsten Rambow
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "schema", namespace = "http://www.w3.org/2001/XMLSchema")
public class XsdSchemaImpl extends AbstractElement implements XsdSchema {

    @XmlAttribute
    private String version;
    @XmlAttribute(name = "elementFormDefault")
    private String elementFormDefault;

    @XmlElement(name = "include")
    private List<XsdIncludeImpl> includes;
    @XmlElement(name = "import")
    private List<XsdImportImpl> imports;
    @XmlElement
    private XsdAnnotationImpl annotation;
    @XmlElement
    private XsdElementImpl element;
    @XmlElement(name = "complexType")
    private List<XsdComplexTypeImpl> complexTypes;
    @XmlElement(name = "redefine")
    private List<XsdRedefineImpl> redefines;

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getElementFormDefault() {
        return elementFormDefault;
    }

    @Override
    public List<? extends XsdIncludeImpl> getIncludes() {
        setParentInList(includes);
        return includes;
    }

    @Override
    public List<XsdImportImpl> getImports() {
        setParentInList(imports);
        return imports;
    }

    @Override
    public XsdAnnotationImpl getAnnotation() {
        setParentInProperty(annotation);
        return annotation;
    }

    @Override
    public XsdElementImpl getElement() {
        setParentInProperty(element);
        return element;
    }

    @Override
    public List<? extends XsdComplexTypeImpl> getComplexTypes() {
        setParentInList(complexTypes);
        return complexTypes;
    }

    @Override
    public List<? extends XsdRedefineImpl> getRedefines() {
        setParentInList(redefines);
        return redefines;
    }

}
