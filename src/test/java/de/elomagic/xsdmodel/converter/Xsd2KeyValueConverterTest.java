package de.elomagic.xsdmodel.converter;

import jakarta.xml.bind.JAXBException;

import de.elomagic.xsdmodel.XsdSchemaFactory;
import de.elomagic.xsdmodel.mocks.XsdSchemaFactoryMock;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Xsd2KeyValueConverterTest {

    @Test
    void convert() throws JAXBException, IOException {
        System.setProperty(XsdSchemaFactory.XSD_SCHEMA_FACTORY_CLASS, XsdSchemaFactoryMock.class.getName());

        //XsdSchema schema = XsdReader.read(getClass().getResourceAsStream("/root2.xsd"));
        //XsdSchema schema = XsdReader.read(Paths.get("excluded/sample.xsd"));
        //System.out.println("ns=" + schema.getXmlns());

        Xsd2KeyValueConverter<KeyProperties> converter = new Xsd2KeyValueConverter<>()
                .setKeyDelimiter("/")
                .setAttributeDelimiter("?")
                .setAttributeSupport(true)
                .setKeyPropertySupplier(KeyProperties::new);

        Map<String, KeyProperties> map = converter.convert(Paths.get("excluded/sample.xsd"));

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> System.out.println(e.getKey() + "=" + e.getValue().getDatatype()));

        assertEquals("/", converter.getKeyDelimiter());
        assertEquals("?", converter.getAttributeDelimiter());
        assertTrue(converter.isAttributeSupport());
        assertEquals(31, map.size());
        //assertEquals("xs:string", map.get("sample-xsd/complex5/interfaces/interface/required").getDatatype());
    }
}