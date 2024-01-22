package com.rosendo.toDoList.exceptions;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public record ExceptionsResponse(Date timestamp, String message, String details) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}
