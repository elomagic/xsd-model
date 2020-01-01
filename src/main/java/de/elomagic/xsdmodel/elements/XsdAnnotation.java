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
package de.elomagic.xsdmodel.elements;

/**
 * The <code>annotation</code> element is a top level element that specifies schema comments.
 * <p>
 * The comments serve as inline documentation.
 *
 * @author Carsten Rambow
 */
public interface XsdAnnotation extends ElementChild, AttributeId {

    XsdDocumentation getDocumentation();

    /**
     * Returns element <code>appInfo</code>.
     * <p>
     * This is a non standard XSD element.
     *
     * @return Element <code>appinfo</code>.
     */
    XsdAppInfo getAppInfo();

}
