package br.com.crud.rest.dto;

import br.com.crud.rest.model.Usuario;
import br.com.crud.rest.util.Util;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String dataNascimento;
    private String genero;
    private String estado;
    private String cidade;
    private String cpfCnpj;
    private Double salarioReceita;

    public UsuarioDTO(Usuario usuario) {
        if (usuario == null)
            return;

        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.dataNascimento = Util.formataData(usuario.getDataNascimento());
        this.genero = usuario.getGenero();
        this.cidade = usuario.getCidade();
        this.estado = usuario.getEstado();
        this.cpfCnpj = usuario.getCpfCnpj();
        this.salarioReceita = usuario.getSalarioReceita();
    }

    public UsuarioDTO(Long id, String nome, String dataNascimento, String genero, String estado, String cidade, String cpfCnpj, String salarioReceita) throws Exception {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.cidade = cidade;
        this.estado = estado;
        this.cpfCnpj = cpfCnpj;
        this.salarioReceita = (salarioReceita != null ? new Double(salarioReceita) : null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Double getSalarioReceita() {
        return salarioReceita;
    }

    public void setSalarioReceita(Double salarioReceita) {
        this.salarioReceita = salarioReceita;
    }

}
