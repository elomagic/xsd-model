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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.elomagic.xsdmodel.adapter.AnyURIDataTypeAdapter;
import de.elomagic.xsdmodel.adapter.BlockValueAdapter;
import de.elomagic.xsdmodel.adapter.FinalValueAdapter;
import de.elomagic.xsdmodel.adapter.NMTokenValueAdapter;
import de.elomagic.xsdmodel.elements.XsdSchema;
import de.elomagic.xsdmodel.enumerations.Block;
import de.elomagic.xsdmodel.enumerations.Final;
import de.elomagic.xsdmodel.enumerations.NMToken;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.xml.namespace.QName;
import java.net.URI;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Carsten Rambow
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "schema", namespace = "http://www.w3.org/2001/XMLSchema")
public class XsdSchemaImpl extends AbstractElement implements XsdSchema {

    @XmlAttribute
    private String id;
    @XmlAttribute
    @XmlJavaTypeAdapter(NMTokenValueAdapter.class)
    private NMToken attributeFormDefault;
    @XmlAttribute
    @XmlJavaTypeAdapter(NMTokenValueAdapter.class)
    private NMToken elementFormDefault;
    @XmlAttribute
    @XmlJavaTypeAdapter(BlockValueAdapter.class)
    private Block blockDefault;
    @XmlAttribute
    @XmlJavaTypeAdapter(FinalValueAdapter.class)
    private Final finalDefault;
    @XmlAttribute
    @XmlJavaTypeAdapter(AnyURIDataTypeAdapter.class)
    private URI targetNamespace;
    @XmlAttribute
    private String version;
    @XmlAttribute
    @XmlJavaTypeAdapter(AnyURIDataTypeAdapter.class)
    private URI xmlns;
    @XmlAnyAttribute
    private Map<QName, String> anyAttributes;

    @XmlElement(name = "include")
    private List<XsdIncludeImpl> includes;
    @XmlElement(name = "import")
    private List<XsdImportImpl> imports;
    @XmlElement
    private XsdAnnotationImpl annotation;
    @XmlElement
    private XsdElementImpl element;
    @XmlElement(name = "simpleType")
    private List<XsdSimpleTypeImpl> simpleTypes;
    @XmlElement(name = "complexType")
    private List<XsdComplexTypeImpl> complexTypes;
    @XmlElement(name = "redefine")
    private List<XsdRedefineImpl> redefines;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public NMToken getAttributeFormDefault() {
        return attributeFormDefault;
    }

    @Override
    public NMToken getElementFormDefault() {
        return elementFormDefault;
    }

    @Override
    public Block getBlockDefault() {
        return blockDefault;
    }

    @Override
    public Final getFinalDefault() {
        return finalDefault;
    }

    @Override
    public URI getTargetNamespace() {
        return targetNamespace;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public Map<String, URI> getXmlns() {
        return anyAttributes == null
                ? Map.of()
                : anyAttributes
                .entrySet()
                .stream()
                .filter(aa -> aa.getKey().toString().startsWith("xmlns:"))
                .map(e -> new AbstractMap.SimpleEntry<String, URI>(e.getKey().toString(), URI.create(e.getValue())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
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
    public List<? extends XsdRedefineImpl> getRedefines() {
        setParentInList(redefines);
        return redefines;
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

    @NotNull
    @Override
    public XsdElementImpl createElement() {
        XsdElementImpl e = new XsdElementImpl();
        e.setParent(this);
        this.element = e;
        return e;
    }

    @Override
    public List<? extends XsdSimpleTypeImpl> getSimpleTypes() {
        setParentInList(simpleTypes);
        return simpleTypes;
    }

    @Override
    public List<? extends XsdComplexTypeImpl> getComplexTypes() {
        setParentInList(complexTypes);
        return complexTypes;
    }

    @Override
    public @Nullable Map<QName, String> getAnyAttributes() {
        return anyAttributes;
    }

}
