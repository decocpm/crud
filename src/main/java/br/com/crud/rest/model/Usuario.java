package br.com.crud.rest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    public static final String SALARIO_RECEITA = "salario_receita";
    public static final String TIPO_USUARIO = "tipo_usuario";
    public static final String CPF_CNPJ = "cpf_cnpj";
    public static final String CIDADE = "cidade";
    public static final String ESTADO = "estado";
    public static final String GENERO = "genero";
    public static final String DATA_NASCIMENTO = "data_nascimento";
    public static final String NOME = "nome";
    public static final String ID = "id";
    public static final String DATA_CRIACAO = "data_criacao";
    public static final String DATA_ATUALIZACAO = "data_atualizacao";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;

    @Column(name = NOME, nullable = false)
    private String nome;

    @Column(name = DATA_NASCIMENTO, nullable = false)
    private Date dataNascimento;

    @Column(name = GENERO, nullable = false)
    private int genero;

    @Column(name = ESTADO, nullable = false)
    private int estado;

    @Column(name = CPF_CNPJ, nullable = false, unique = true, length = 14)
    private String cpfCnpj;

    @Column(name = TIPO_USUARIO, nullable = false)
    private int tipoUsuario;

    @Column(name = SALARIO_RECEITA, precision = 2)
    private Double salarioReceita;

    @Column(name = DATA_CRIACAO, nullable = false, updatable = false)
    private Date dataCriacao;

    @Column(name = DATA_ATUALIZACAO, nullable = false)
    private Date dataAtualizacao;

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

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Double getSalarioReceita() {
        return salarioReceita;
    }

    public void setSalarioReceita(Double salarioReceita) {
        this.salarioReceita = salarioReceita;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
