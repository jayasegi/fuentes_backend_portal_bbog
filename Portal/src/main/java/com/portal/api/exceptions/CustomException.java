package com.portal.api.exceptions;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Clase encargada de manejar las excepciones según estándar *
 * <p>
 * CustomException
 * <p>
 * Desarrollo Jaime Figueroa
 * <p>
 * Creado él: 11 de diciembre de 2025
 *
 * @author Jaime Figueroa
 * @version 1.0
 * @since 1.0
 * <p>
 * Requerimiento: Portal
 * <p>
 * Copyright © A Jaime Figueroa Todos los derechos reservados
 * <p>
 * Este software es confidencial y es propiedad de Jaime Figueroa, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de Jaime Figueroa o de quién represente sus derechos.
 */
@Getter
@Setter
public class CustomException extends RuntimeException {
    private final String errorCode;
    private final String message;
    private final int httpCode;

    private List<String> detail;

    /**
     * Constructor de la clase
     * Este metodo recibe los parametros cuando se llama a la libreria
     * @param errorCode
     * @param message
     * @param httpCode
     */
    public CustomException(String errorCode, String message, int httpCode) {
        this.errorCode = errorCode;
        this.message = message;
        this.httpCode = httpCode;
    }
    
    /**
     * Constructor de la clase
     * Este metodo recibe los parametros cuando se llama a la libreria
     *
     * @param errorCode
     * @param message
     * @param httpCode
     * @param detail
     */
    public CustomException(String errorCode, String message, int httpCode, List<String> detail) {
        this.errorCode = errorCode;
        this.message = message;
        this.httpCode = httpCode;
        this.detail = detail;
    }

}

