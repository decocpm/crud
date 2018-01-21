package br.com.crud.rest.dto;

import br.com.crud.rest.model.Usuario;

import java.util.Date;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private Date dataNascimento;
    private int genero;
    private int estado;

    public UsuarioDTO(Usuario usuario) {
        if (usuario == null)
            return;

        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.dataNascimento = usuario.getDataNascimento();
        this.genero = usuario.getGenero();
        this.estado = usuario.getEstado();
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
