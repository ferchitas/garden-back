package org.ferchu.garden.implementation.exceptions;

import org.ferchu.garden.generated.model.ErrorApp;

public class MissingPlantTypeException extends MainException {
    public MissingPlantTypeException(ErrorApp errorApp) {
        super(errorApp);
    }
}
