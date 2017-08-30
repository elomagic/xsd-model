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

import de.elomagic.xsdmodel.elements.XsdRedefine;

/**
 *
 * @author Carsten Rambow
 */
public class XsdRedefineImpl extends AbstractElement implements XsdRedefine {

    @XmlAttribute
    private String id;
    @XmlAttribute(required = true)
    private String schemaLocation;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getSchemaLocation() {
        return schemaLocation;
    }

}
