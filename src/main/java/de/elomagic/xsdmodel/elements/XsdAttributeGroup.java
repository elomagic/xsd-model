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

import java.util.List;

/**
 * The attributeGroup element is used to group a set of attribute declarations so that they can be incorporated as a group into complex type definitions.
 *
 * @author Carsten Rambow
 */
public interface XsdAttributeGroup extends ElementGetParent, AttributeId, AttributeName, AttributeRef {

    List<? extends XsdAttributeGroup> getAttributeGroups();

    List<? extends XsdAttribute> getAttributes();

}
