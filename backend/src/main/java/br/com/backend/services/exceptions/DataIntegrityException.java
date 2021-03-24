package br.com.backend.services.exceptions;

// classe utilizada para personalizar o retorno de exceções lançadas por violação de integridade no banco

public class DataIntegrityException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DataIntegrityException(String message) {
        super(message);
    }

    public DataIntegrityException(String message, Throwable cause) {
        super(message, cause);
    }

}
