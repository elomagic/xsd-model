/*
 * XSD Model (Java 17 with Jakarta XML Binding 4.0)
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
package de.elomagic.xsdmodel.elements.impl;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import de.elomagic.xsdmodel.elements.XsdAnnotation;
import de.elomagic.xsdmodel.elements.XsdLength;
import de.elomagic.xsdmodel.elements.XsdMaxExclusive;
import de.elomagic.xsdmodel.elements.XsdRestriction;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 *
 * @author Carsten Rambow
 */
public class XsdRestrictionImpl extends AbstractElement implements XsdRestriction {

    @XmlAttribute
    private String base;
    @XmlAttribute
    private String id;

    @XmlElement(name = "enumeration")
    private List<XsdEnumerationImpl> enumerations;
    @XmlElement
    private XsdFractionDigitsImpl fractionDigits;
    @XmlElement
    private XsdLengthImpl length;
    @XmlElement
    private XsdMaxExclusiveImpl maxExclusive;
    @XmlElement
    private XsdMaxInclusiveImpl maxInclusive;
    @XmlElement
    private XsdMaxLengthImpl maxLength;
    @XmlElement
    private XsdMinExclusiveImpl minExclusive;
    @XmlElement
    private XsdMinInclusiveImpl minInclusive;
    @XmlElement
    private XsdMinLengthImpl minLength;
    @XmlElement
    private XsdPatternImpl pattern;
    @XmlElement
    private XsdTotalDigitsImpl totalDigits;
    @XmlElement
    private XsdWhiteSpaceImpl whiteSpace;
    @XmlElement
    private XsdAnnotationImpl annotation;

    @Override
    public String getBase() {
        return base;
    }

    @Override
    @NotNull
    public XsdRestrictionImpl setBase(@NotNull String base) {
        this.base = base;
        return this;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public List<XsdEnumerationImpl> getEnumerations() {
        setParentInList(enumerations);
        return enumerations;
    }

    @Override
    public XsdFractionDigitsImpl getFractionDigits() {
        setParentInProperty(fractionDigits);
        return fractionDigits;
    }

    @Override
    @NotNull
    public XsdFractionDigitsImpl createFractionDigits() {
        fractionDigits = new XsdFractionDigitsImpl();
        fractionDigits.setParent(this);
        return fractionDigits;
    }

    @Override
    public XsdLengthImpl getLength() {
        setParentInProperty(length);
        return length;
    }

    @Override
    @NotNull
    public XsdLength createLength() {
        length = new XsdLengthImpl();
        length.setParent(this);
        return length;
    }

    @Override
    public XsdMaxExclusive getMaxExclusive() {
        setParentInProperty(maxExclusive);
        return maxExclusive;
    }

    @Override
    @NotNull
    public XsdMaxExclusiveImpl createMaxExclusive() {
        maxExclusive = new XsdMaxExclusiveImpl();
        maxExclusive.setParent(this);
        return maxExclusive;
    }

    @Override
    public XsdMinLengthImpl getMinLength() {
        setParentInProperty(minLength);
        return minLength;
    }

    @Override
    @NotNull
    public XsdMinLengthImpl createMinLength() {
        minLength = new XsdMinLengthImpl();
        minLength.setParent(this);
        return minLength;
    }


    @Override
    public XsdMinInclusiveImpl getMinInclusive() {
        setParentInProperty(minInclusive);
        return minInclusive;
    }

    @Override
    @NotNull
    public XsdMinInclusiveImpl createMinInclusive() {
        minInclusive = new XsdMinInclusiveImpl();
        minInclusive.setParent(this);
        return minInclusive;
    }

    @Override
    public XsdMinExclusiveImpl getMinExclusive() {
        setParentInProperty(minExclusive);
        return minExclusive;
    }

    @Override
    @NotNull
    public XsdMinExclusiveImpl createMinExclusive() {
        minExclusive = new XsdMinExclusiveImpl();
        minExclusive.setParent(this);
        return minExclusive;
    }

    @Override
    public XsdMaxLengthImpl getMaxLength() {
        setParentInProperty(maxLength);
        return maxLength;
    }

    @Override
    @NotNull
    public XsdMaxLengthImpl createMaxLength() {
        maxLength = new XsdMaxLengthImpl();
        maxLength.setParent(this);
        return maxLength;
    }

    @Override
    public XsdMaxInclusiveImpl getMaxInclusive() {
        setParentInProperty(maxInclusive);
        return maxInclusive;
    }

    @Override
    @NotNull
    public XsdMaxInclusiveImpl createMaxInclusive() {
        maxInclusive = new XsdMaxInclusiveImpl();
        maxInclusive.setParent(this);
        return maxInclusive;
    }

    @Override
    public XsdPatternImpl getPattern() {
        setParentInProperty(pattern);
        return pattern;
    }

    @Override
    @NotNull
    public XsdPatternImpl createPattern() {
        pattern = new XsdPatternImpl();
        pattern.setParent(this);
        return pattern;
    }

    @Override
    public XsdTotalDigitsImpl getTotalDigits() {
        setParentInProperty(totalDigits);
        return totalDigits;
    }

    @Override
    @NotNull
    public XsdTotalDigitsImpl createTotalDigits() {
        totalDigits = new XsdTotalDigitsImpl();
        totalDigits.setParent(this);
        return totalDigits;
    }

    @Override
    public XsdWhiteSpaceImpl getWhiteSpace() {
        setParentInProperty(whiteSpace);
        return whiteSpace;
    }

    @Override
    @NotNull
    public XsdWhiteSpaceImpl createWhiteSpace() {
        whiteSpace = new XsdWhiteSpaceImpl();
        whiteSpace.setParent(this);
        return whiteSpace;
    }

    @Override
    public XsdAnnotation getAnnotation() {
        return annotation;
    }

    @Override
    @NotNull
    public XsdAnnotation createAnnotation() {
        annotation = new XsdAnnotationImpl();
        annotation.setParent(this);
        return annotation;
    }

}
