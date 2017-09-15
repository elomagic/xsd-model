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
package de.elomagic.xsdmodel.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import de.elomagic.xsdmodel.enumerations.Final;

/**
 *
 * @author Carsten Rambow
 */
public class FinalValueAdapter extends XmlAdapter<String, Final> {

    @Override
    public Final unmarshal(String v) throws Exception {
        if(v == null || v.length() == 0) {
            return null;
        }

        return Final.parseValue(v);
    }

    @Override
    public String marshal(Final v) throws Exception {
        return v == null ? null : v.getValue();
    }

}
