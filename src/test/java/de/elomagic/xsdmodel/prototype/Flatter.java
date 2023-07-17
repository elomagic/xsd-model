package de.elomagic.xsdmodel.prototype;

import de.elomagic.xsdmodel.elements.XsdComplexType;
import de.elomagic.xsdmodel.elements.XsdSchema;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Flatter {

    private Map<String, Set<String>> complexKeys = new HashMap<>();

    public Set<String> flattXsd(@NotNull XsdSchema schema) {

        schema.getComplexTypes()
                .stream()
                .map(this::flattComplexType);

        return Set.of();

    }

    private Map<String, Set<String>> flattComplexType(@NotNull XsdComplexType complexType) {
        if (complexKeys.containsKey(complexType.getName())) {
            return Map.of();
        }

        return Map.of();

    }



}
