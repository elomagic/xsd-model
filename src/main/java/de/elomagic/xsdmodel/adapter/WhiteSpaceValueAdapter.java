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
package de.elomagic.xsdmodel.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import de.elomagic.xsdmodel.enumerations.WhiteSpace;

/**
 *
 * @author rambow
 */
public class WhiteSpaceValueAdapter extends XmlAdapter<String, WhiteSpace> {

    @Override
    public WhiteSpace unmarshal(String v) {
        if(v == null || v.length() == 0) {
            return null;
        }

        return WhiteSpace.parseValue(v);
    }

    @Override
    public String marshal(WhiteSpace v) {
        return v == null ? null : v.getValue();
    }

}
