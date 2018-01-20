package br.com.crud.rest.dto;

import br.com.crud.rest.model.Usuario;

public class PessoaFisicaDTO extends Usuario {

    private String cpf;
    private Double salario;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
