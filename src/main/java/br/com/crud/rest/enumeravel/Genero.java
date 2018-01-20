package br.com.crud.rest.enumeravel;

public enum Genero {

    MASCULINO(1), FEMININO(2), INDEFINIDO(3);

    private final int genero;

    Genero(int valor) {
        genero = valor;
    }

    public int getTipoPessoa() {
        return genero;
    }
}
