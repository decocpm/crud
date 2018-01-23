package br.com.crud.rest.dto;

import br.com.crud.rest.util.Util;
import java.util.Date;

public class FiltroUsuarioDTO {

    private String nomeSearch;
    private Date dataNascimentoInicioSearch;
    private Date dataNascimentoFimSearch;
    private String generoSearch;
    private String estadoSearch;
    private String cidadeSearch;
    private String cpfCnpjSearch;
    private Double salarioReceitaInicioSearch;
    private Double salarioReceitaFimSearch;

    public FiltroUsuarioDTO(String nome, String nascIni, String nascFim, String genero, String estado, String cidade, String cpfCnpj) throws Exception {
        this.nomeSearch = nome;
        this.dataNascimentoInicioSearch = (nascIni != null ? Util.parseDate(nascIni) : null);
        this.dataNascimentoFimSearch = (nascFim != null ? Util.parseDate(nascFim) : null);
        this.generoSearch = genero;
        this.estadoSearch = estado;
        this.cidadeSearch = cidade;
        this.cpfCnpjSearch = cpfCnpj;
    }

    public String getNomeSearch() {
        return nomeSearch;
    }

    public void setNomeSearch(String nomeSearch) {
        this.nomeSearch = nomeSearch;
    }

    public Date getDataNascimentoInicioSearch() {
        return dataNascimentoInicioSearch;
    }

    public void setDataNascimentoInicioSearch(Date dataNascimentoInicioSearch) {
        this.dataNascimentoInicioSearch = dataNascimentoInicioSearch;
    }

    public Date getDataNascimentoFimSearch() {
        return dataNascimentoFimSearch;
    }

    public void setDataNascimentoFimSearch(Date dataNascimentoFimSearch) {
        this.dataNascimentoFimSearch = dataNascimentoFimSearch;
    }

    public String getGeneroSearch() {
        return generoSearch;
    }

    public void setGeneroSearch(String generoSearch) {
        this.generoSearch = generoSearch;
    }

    public String getEstadoSearch() {
        return estadoSearch;
    }

    public void setEstadoSearch(String estadoSearch) {
        this.estadoSearch = estadoSearch;
    }

    public String getCidadeSearch() {
        return cidadeSearch;
    }

    public void setCidadeSearch(String cidadeSearch) {
        this.cidadeSearch = cidadeSearch;
    }

    public String getCpfCnpjSearch() {
        return cpfCnpjSearch;
    }

    public void setCpfCnpjSearch(String cpfCnpjSearch) {
        this.cpfCnpjSearch = cpfCnpjSearch;
    }

    public Double getSalarioReceitaInicioSearch() {
        return salarioReceitaInicioSearch;
    }

    public void setSalarioReceitaInicioSearch(Double salarioReceitaInicioSearch) {
        this.salarioReceitaInicioSearch = salarioReceitaInicioSearch;
    }

    public Double getSalarioReceitaFimSearch() {
        return salarioReceitaFimSearch;
    }

    public void setSalarioReceitaFimSearch(Double salarioReceitaFimSearch) {
        this.salarioReceitaFimSearch = salarioReceitaFimSearch;
    }
}
