package de.elomagic.xsdmodel.prototype;

import de.elomagic.xsdmodel.elements.XsdComplexType;
import de.elomagic.xsdmodel.elements.XsdSchema;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Flatter {

    private final Map<String, Set<String>> complexKeys = new HashMap<>();
    private final Map<String, String> simpleKeys = new HashMap<>();

    public Set<String> flattXsd(@NotNull XsdSchema schema) {

        if (schema.getComplexTypes() != null) {
            schema.getComplexTypes()
                    .stream()
                    .map(this::flattComplexType);
        }

        if (schema.getSimpleTypes() != null) {
            schema.getSimpleTypes()
                    .stream()
                    .map(e -> simpleKeys.put(e.getName(), e.getName()));
        }

        flattComplexType(schema.getElement().getComplexType());

        return Set.of();

    }

    private Map<String, Set<String>> flattComplexType(@NotNull XsdComplexType complexType) {
        if (complexKeys.containsKey(complexType.getName())) {
            return Map.of();
        }

        return Map.of();

    }



}
