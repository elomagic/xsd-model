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
package de.elomagic.xsdmodel.elements;

/**
 *
 * @author Carsten Rambow
 */
public interface XsdField extends ElementChild, AttributeId {

    /**
     * Identifies a single element or attribute whose content or value is used for the constraint.
     * <p>
     * Required.
     *
     * @return String value of attribute <code>xpath</code>.
     */
    String getXPath();

}
