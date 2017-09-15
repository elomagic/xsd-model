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

import java.net.URI;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.elomagic.xsdmodel.adapter.AnyURIDataTypeAdapter;
import de.elomagic.xsdmodel.elements.XsdInclude;

/**
 *
 * @author Carsten Rambow
 */
public class XsdIncludeImpl extends AbstractElement implements XsdInclude {

    @XmlAttribute
    private String id;
    @XmlAttribute
    @XmlJavaTypeAdapter(AnyURIDataTypeAdapter.class)
    private URI schemaLocation;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public URI getSchemaLocation() {
        return schemaLocation;
    }

}
