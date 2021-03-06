/*
 * Contains the implementation of the XSD model.
 * <p>
 * It's advisable that your application don't to use these classes to avoid issues in the future by refactoring etc.
 */
@XmlSchema(
        namespace = "http://www.w3.org/2001/XMLSchema",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
            @XmlNs(prefix = "xs", namespaceURI = "http://www.w3.org/2001/XMLSchema"),
            @XmlNs(prefix = "xml", namespaceURI = "http://www.w3.org/XML/1998/namespace")
        })
package de.elomagic.xsdmodel.elements.impl;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
