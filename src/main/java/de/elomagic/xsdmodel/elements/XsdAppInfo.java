/*
 * XSD Model (Java 17 + Jakarta)
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
package de.elomagic.xsdmodel.elements;

import java.net.URI;

import de.elomagic.xsdmodel.elements.extention.XsdNodeInfo;

/**
 * The <code>appinfo</code> element specifies information to be used by the application.
 * <p>
 * This element must go within an annotation element.
 *
 * @author Carsten Rambow
 */
public interface XsdAppInfo extends ElementChild {

    /**
     * A URI reference that specifies the source of the application information.
     * <p>
     * Optional.
     *
     * @return String value of attribute <code>source</code>.
     */
    URI getSource();

    XsdNodeInfo getNodeInfo();

}
