package org.ferchu.garden.implementation.exceptions;

import org.ferchu.garden.generated.model.ErrorApp;

public class MainException extends RuntimeException {

    private ErrorApp errorApp;

    public MainException(ErrorApp errorApp) {
        super();
        this.errorApp = errorApp;
    }

    public ErrorApp getErrorApp() {
        return errorApp;
    }
}
