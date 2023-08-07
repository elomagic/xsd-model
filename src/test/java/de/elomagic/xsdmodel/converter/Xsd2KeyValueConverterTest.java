package de.elomagic.xsdmodel.converter;

import jakarta.xml.bind.JAXBException;

import de.elomagic.xsdmodel.XsdReader;
import de.elomagic.xsdmodel.mocks.XsdSchemaFactoryMock;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Xsd2KeyValueConverterTest {

    @Test
    void testConvert() throws JAXBException, IOException {
        Xsd2KeyValueConverter<KeyProperties> converter = new Xsd2KeyValueConverter<>()
                .setReader(new XsdReader().setXsdSchemaFactoryClass(XsdSchemaFactoryMock.class.getName()))
                .setKeyDelimiter("/")
                .setAttributeDelimiter("?")
                .setAttributeSupport(true)
                .setKeyPropertySupplier(KeyProperties::new);

        //Map<String, KeyProperties> map = converter.convert(Paths.get("excluded/sample.xsd"));
        Map<String, KeyProperties> map = converter.convert(getClass().getResourceAsStream("/example.xsd"));

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

        assertEquals("/", converter.getKeyDelimiter());
        assertEquals("?", converter.getAttributeDelimiter());
        assertTrue(converter.isAttributeSupport());
        assertEquals(12, converter.resolvedComplexTypes.size());
        assertEquals(0, converter.resolvedSimpleTypes.size());
        assertEquals(17, map.size());
        assertEquals("xs:string", map.get("sample-xsd/complex5/interface/remoteInterface/hostname").getDatatype());
        assertEquals("Name or IP address of a host", map.get("sample-xsd/complex5/interface/remoteInterface/hostname").getDescription());
    }

}