package org.ferchu.garden.implementation.exceptions;

import org.ferchu.garden.generated.model.ErrorApp;

public class UnexistingObjectException extends MainException {

    public UnexistingObjectException(ErrorApp errorApp) {
        super(errorApp);
    }
}
