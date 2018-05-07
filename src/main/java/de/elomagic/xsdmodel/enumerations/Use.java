/*
 * XSD Model
 * Copyright (c) 2017-2018 Carsten Rambow
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
package de.elomagic.xsdmodel.enumerations;

import java.util.Arrays;

/**
 *
 * @author Carsten Rambow
 */
public enum Use {

    /**
     * The attribute is optional (this is default).
     */
    optional("optional"),
    /**
     * The attribute cannot be used.
     */
    prohibited("prohibited"),
    /**
     * The attribute is required.
     */
    required("required");

    private final String value;

    private Use(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Use parseValue(String value) {
        for(Use item : values()) {
            if(item.getValue().equals(value)) {
                return item;
            }
        }

        throw new IllegalArgumentException("Invalid value \"" + value + "\". Supported values are: " + Arrays.toString(values()));
    }

}
