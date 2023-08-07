package de.elomagic.xsdmodel.converter;

import java.util.HashSet;
import java.util.Set;

public class KeyRestrictions {

    private Set<String> enumeration = new HashSet<>();

    public Set<String> getEnumeration() {
        return enumeration;
    }

    public void setEnumeration(Set<String> enumeration) {
        this.enumeration = enumeration;
    }

}
