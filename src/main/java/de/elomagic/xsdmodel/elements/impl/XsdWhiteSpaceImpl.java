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
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.elomagic.xsdmodel.adapter.BooleanDataTypeAdapter;
import de.elomagic.xsdmodel.adapter.WhiteSpaceValueAdapter;
import de.elomagic.xsdmodel.elements.XsdWhiteSpace;
import de.elomagic.xsdmodel.enumerations.WhiteSpace;

import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Carsten Rambow
 */
public class XsdWhiteSpaceImpl extends AbstractElement implements XsdWhiteSpace {

    @XmlAttribute
    @XmlJavaTypeAdapter(WhiteSpaceValueAdapter.class)
    private WhiteSpace value;
    @XmlAttribute
    @XmlJavaTypeAdapter(BooleanDataTypeAdapter.class)
    private Boolean fixed;

    @Override
    public WhiteSpace getValue() {
        return value;
    }

    @Override
    @NotNull
    public XsdWhiteSpace setValue(WhiteSpace value) {
        this.value = value;
        return this;
    }

    @Override
    public Boolean getFixed() {
        return fixed;
    }

    @Override
    public XsdWhiteSpace setFixed(Boolean fixed) {
        this.fixed = fixed;
        return this;
    }
}
