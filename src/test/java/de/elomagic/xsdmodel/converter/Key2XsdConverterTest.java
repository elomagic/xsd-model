package de.elomagic.xsdmodel.converter;

import de.elomagic.xmltools.XmlWriter;
import de.elomagic.xsdmodel.elements.XsdSchema;

import org.glassfish.jaxb.core.marshaller.XMLWriter;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class Key2XsdConverterTest {

    @Test
    void convert() throws Exception {

        Properties p = new Properties();
        p.load(getClass().getResourceAsStream("/example1.properties"));

        XsdSchema schema = new Key2XsdConverter()
                .setRootName(null)
                .convert(p.keySet()).get();

        assertEquals("a1", schema.getElement().getName());

        XmlWriter.write(System.out, schema);
    }
}