package com.laurens.tul.utilities;

/**
 * Enumerable creado para manejar el estado de una compra
 */
public enum Status {
    //Se crean dos estados.
    PENDIENTE("S"), COMPLETADO("C");

    //Se crea un codigo que manejara la identidad de los estados
    private String code;

    private Status(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }

}
