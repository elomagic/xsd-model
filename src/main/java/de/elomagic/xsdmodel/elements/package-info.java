/*
 * Contains the interfaces of the XSD model.
 * <p>
 * Usually, your application will use these classes.
 */
@XmlSchema(
        namespace = "http://www.w3.org/2001/XMLSchema",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
            @XmlNs(prefix = "xs", namespaceURI = "http://www.w3.org/2001/XMLSchema"),
            @XmlNs(prefix = "xml", namespaceURI = "http://www.w3.org/XML/1998/namespace")
        })
package de.elomagic.xsdmodel.elements;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
