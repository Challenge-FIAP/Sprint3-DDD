package com.example.model;

public record Sessao(String email, String senha) {

  @Override
  public String toString() {
    return email + " - " + senha;
  }

}
