package org.ferchu.garden.implementation.exceptions;

import org.ferchu.garden.generated.model.ErrorApp;

public class NotCreatedPlantTypeException extends MainException {
    public NotCreatedPlantTypeException(ErrorApp errorApp) {
        super(errorApp);
    }
}
