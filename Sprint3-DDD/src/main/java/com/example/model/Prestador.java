package com.example.model;

public record Prestador(String email, String senha, String nm_prestador, String modelo_guincho) {

    @Override
    public String toString() {
        return email + " - " + nm_prestador + " - " + modelo_guincho;
    }

}
