package br.com.backend.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

// classe utilizada para armazenar erros de validação

public class ValidationError extends StandartError {
    private static final long serialVersionUID = 1L;

    List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Integer status, String message, Long timeStamp) {
        super(status, message, timeStamp);
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void setErros(String fieldMessage, String message) {
        erros.add(new FieldMessage(fieldMessage, message));
    }

}
