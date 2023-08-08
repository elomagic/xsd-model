package de.elomagic.xsdmodel.converter;

import jakarta.xml.bind.JAXBException;

import de.elomagic.xsdmodel.XsdReader;
import de.elomagic.xsdmodel.mocks.XsdSchemaFactoryMock;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

        //Map<String, KeyProperties> map = converter.convert(java.nio.file.Paths.get("excluded/sample.xsd"));
        Map<String, KeyProperties> map = converter.convert(getClass().getResourceAsStream("/example.xsd"));
        //Map<String, KeyProperties> map = converter.convert(getClass().getResourceAsStream("/example02.xsd"));

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

        assertEquals("/", converter.getKeyDelimiter());
        assertEquals("?", converter.getAttributeDelimiter());
        assertTrue(converter.isAttributeSupport());
        assertEquals(12, converter.resolvedComplexTypes.size());
        assertEquals(0, converter.resolvedSimpleTypes.size());
        assertEquals(18, map.size());
        assertEquals("xs:string", map.get("sample-xsd/complex5/interface/remoteInterface/hostname").getDatatype());
        assertEquals("Name or IP address of a host", map.get("sample-xsd/complex5/interface/remoteInterface/hostname").getDescription());
        assertEquals("Something to activate", map.get("sample-xsd/complex5/interface/active").getDescription());
        assertEquals("xs:boolean", map.get("sample-xsd/complex5/interface/active").getDatatype());
        assertTrue(map.get("sample-xsd/complex3/a/b").getConstraints().isRequired());
        assertFalse(map.get("sample-xsd/complex5/interface/active").getConstraints().isRequired());
    }

    @Test
    void testConvert2() throws JAXBException, IOException {
        Xsd2KeyValueConverter<KeyProperties> converter = new Xsd2KeyValueConverter<>()
                .setReader(new XsdReader().setXsdSchemaFactoryClass(XsdSchemaFactoryMock.class.getName()))
                .setKeyDelimiter("/")
                .setAttributeDelimiter("?")
                .setAttributeSupport(true)
                .setKeyPropertySupplier(KeyProperties::new);

        //Map<String, KeyProperties> map = converter.convert(java.nio.file.Paths.get("excluded/sample.xsd"));
        //Map<String, KeyProperties> map = converter.convert(getClass().getResourceAsStream("/example.xsd"));
        Map<String, KeyProperties> map = converter.convert(getClass().getResourceAsStream("/example02.xsd"));

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

        assertEquals("/", converter.getKeyDelimiter());
        assertEquals("?", converter.getAttributeDelimiter());
        assertTrue(converter.isAttributeSupport());
        assertEquals(0, converter.resolvedComplexTypes.size());
        assertEquals(4, converter.resolvedSimpleTypes.size());
        assertEquals(31, map.size());
        assertEquals("xs:string", map.get("Service/RIStoFerrari/faxLID").getDatatype());
        assertEquals("Locale sender ID", map.get("Service/RIStoFerrari/faxLID").getDescription());
        assertEquals(4, map.get("Service/FaxManager/faxClass").getConstraints().getEnumeration().size());
    }


}