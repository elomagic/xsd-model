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
package de.elomagic.xsdmodel.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import de.elomagic.xsdmodel.enumerations.Use;

/**
 *
 * @author Carsten Rambow
 */
public class UseValueAdapter extends XmlAdapter<String, Use> {

    @Override
    public Use unmarshal(String v) {
        if(v == null || v.length() == 0) {
            return null;
        }

        return Use.parseValue(v);
    }

    @Override
    public String marshal(Use v) {
        return v == null ? null : v.getValue();
    }

}
