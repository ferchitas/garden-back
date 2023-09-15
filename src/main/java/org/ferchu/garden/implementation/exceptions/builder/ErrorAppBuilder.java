package org.ferchu.garden.implementation.exceptions.builder;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.ferchu.garden.generated.model.ErrorApp;
import org.ferchu.garden.generated.model.ErrorType;

import java.math.BigDecimal;

public class ErrorAppBuilder {

    private ErrorApp errorApp;

    public ErrorAppBuilder() {

        errorApp = new ErrorApp();
    }

    public ErrorAppBuilder name(String name) {

        this.errorApp.setName(name);
        return this;
    }

    public ErrorAppBuilder description(String description) {

        this.errorApp.setDescription(description);
        return this;
    }

    public ErrorAppBuilder errorCode(BigDecimal errorCode) {

        this.errorApp.setErrorCode(errorCode);
        return this;
    }

    public ErrorAppBuilder httpCode(BigDecimal httpCode) {

        this.errorApp.setHttpCode(httpCode);
        return this;
    }

    public ErrorAppBuilder errorType(ErrorType errorType) {

        this.errorApp.setErrorType(errorType);
        return this;
    }

    public ErrorApp build() {

        return errorApp;
    }
}
