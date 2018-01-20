package br.com.crud.rest.dto;

import br.com.crud.rest.model.Usuario;

public class PessoaJuridicaDTO extends Usuario {

    private String cnpj;
    private Double receita;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Double getReceita() {
        return receita;
    }

    public void setReceita(Double receita) {
        this.receita = receita;
    }
}
