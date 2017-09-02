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
package de.elomagic.xsdmodel.elements.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import de.elomagic.xsdmodel.elements.ElementChild;

/**
 * Each XSD element must be extended from this class.
 *
 * @author Carsten Rambow
 */
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractElement implements ElementChild, ElementSetParent {

    private AbstractElement parent;

    @Override
    public AbstractElement getParent() {
        return parent;
    }

    @Override
    public void setParent(AbstractElement parent) {
        this.parent = parent;
    }

    /**
     * Checks on null value.
     *
     * @param child Child element of this element.
     */
    protected void setParentInProperty(ElementSetParent child) {
        if(child == null) {
            return;
        }

        child.setParent(this);
    }

    /**
     * Checks on null value.
     *
     * @param childList List of child elements of this element.
     */
    protected void setParentInList(List<? extends ElementSetParent> childList) {
        if(childList == null) {
            return;
        }

        childList.forEach((item)->setParentInProperty(item));
    }

    @Override
    public String toString() {
        return getClass().getName() + ":parent=" + getParent();
    }

}
