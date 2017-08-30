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
package de.elomagic.xsdmodel.elements;

/**
 * The documentation element is used to enter text comments in a schema.
 * <p>
 * This element must go inside an annotation element.
 *
 * @author Carsten Rambow
 */
public interface XsdDocumentation extends ElementGetParent {

    /**
     * Specifies the source of the application information.
     * <p>
     * Optional.
     *
     * @return String value of attribute <code>source</code>.
     */
    String getSource();

    /**
     * Specifies the language used in the contents.
     * <p>
     * Optional.
     *
     * @return String value of attribute <code>xml:lang</code>.
     */
    String getLanguage();

    /**
     * Returns element value.
     *
     * @return String value of element <code>value</code>.
     */
    String getValue();

}
