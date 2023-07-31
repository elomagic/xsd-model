package de.elomagic.xsdmodel.converter;

import jakarta.xml.bind.JAXBException;

import de.elomagic.xsdmodel.XsdReader;
import de.elomagic.xsdmodel.XsdSchemaFactory;
import de.elomagic.xsdmodel.elements.XsdSchema;
import de.elomagic.xsdmodel.mocks.XsdSchemaFactoryMock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

class Xsd2KeyValueConverterTest {

    @Test
    void convert() throws JAXBException, IOException {
        System.setProperty(XsdSchemaFactory.XSD_SCHEMA_FACTORY_CLASS, XsdSchemaFactoryMock.class.getName());

        XsdSchema schema = XsdReader.read(getClass().getResourceAsStream("/root2.xsd"));

        System.out.println("ns=" + schema.getXmlns());

        Xsd2KeyValueConverter converter = new Xsd2KeyValueConverter();
        Map<String, KeyProperties> map = converter.convert(schema);

        Assertions.assertEquals(12, map.size());
    }
}