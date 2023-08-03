package de.elomagic.xsdmodel.converter;

import jakarta.xml.bind.JAXBException;

import de.elomagic.xsdmodel.XsdSchemaFactory;
import de.elomagic.xsdmodel.mocks.XsdSchemaFactoryMock;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Xsd2KeyValueConverterTest {

    @Test
    void testConvert() throws JAXBException, IOException {
        System.setProperty(XsdSchemaFactory.XSD_SCHEMA_FACTORY_CLASS, XsdSchemaFactoryMock.class.getName());

        Xsd2KeyValueConverter<KeyProperties> converter = new Xsd2KeyValueConverter<>()
                .setKeyDelimiter("/")
                .setAttributeDelimiter("?")
                .setAttributeSupport(true)
                .setKeyPropertySupplier(KeyProperties::new);

        //Map<String, KeyProperties> map = converter.convert(Paths.get("excluded/sample.xsd"));
        Map<String, KeyProperties> map = converter.convert(getClass().getResourceAsStream("/example.xsd"));

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> System.out.println(e.getKey() + "=" + e.getValue().getDatatype()));

        assertEquals("/", converter.getKeyDelimiter());
        assertEquals("?", converter.getAttributeDelimiter());
        assertTrue(converter.isAttributeSupport());
        assertEquals(31, map.size());
        //assertEquals("xs:string", map.get("sample-xsd/complex5/interfaces/interface/required").getDatatype());
    }

    @Test
    void testIsUnresolved() throws JAXBException, IOException {
        Xsd2KeyValueConverter<KeyProperties> converter = new Xsd2KeyValueConverter<>();

        assertTrue(converter.isUnresolvedType("abc"));

        converter.simpleTypeMap.put("abc", new KeyProperties());
        assertFalse(converter.isUnresolvedType("abc"));

        converter.simpleTypeMap.clear();
        converter.complexTypeMap.put("abc", new HashMap<>());
        assertFalse(converter.isUnresolvedType("abc"));

        converter.simpleTypeMap.put("abc", new KeyProperties());
        assertFalse(converter.isUnresolvedType("abc"));
    }
}