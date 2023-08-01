package de.elomagic.xsdmodel.converter;

import org.jetbrains.annotations.NotNull;

public class XsdConverterException extends RuntimeException {

    public XsdConverterException(@NotNull String message) {
        super(message);
    }

    public XsdConverterException(String message, @NotNull Throwable cause) {
        super(message, cause);
    }

}
