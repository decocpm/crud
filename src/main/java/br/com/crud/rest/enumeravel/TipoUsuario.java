package br.com.crud.rest.enumeravel;

public enum TipoUsuario {

    PF(1), PJ(2);

    private final int tipoPessoa;

    TipoUsuario(int valor) {
        tipoPessoa = valor;
    }

    public int getTipoPessoa() {
        return tipoPessoa;
    }
}
