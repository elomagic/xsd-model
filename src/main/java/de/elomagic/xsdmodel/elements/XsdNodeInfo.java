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
 * The <code>node-info</code> element is a child element of the {@link XsdAppInfo} element.
 * <p>
 * Will be used by the XmlEditor
 *
 * @author Carsten Rambow
 */
public interface XsdNodeInfo extends ElementGetParent {

    String getMessage();

    String getEditorClass();

    String getEditorId();

}
