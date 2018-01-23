package br.com.crud.rest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    public static final String SALARIO_RECEITA = "salario_receita";
    public static final String CPF_CNPJ = "cpf_cnpj";
    public static final String CIDADE = "cidade";
    public static final String ESTADO = "estado";
    public static final String GENERO = "genero";
    public static final String DATA_NASCIMENTO = "data_nascimento";
    public static final String NOME = "nome";
    public static final String ID = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ID)
    private Long id;

    @Column(name = NOME, nullable = false)
    private String nome;

    @Column(name = DATA_NASCIMENTO, nullable = false)
    private Date dataNascimento;

    @Column(name = GENERO, nullable = false)
    private String genero;

    @Column(name = CIDADE, nullable = false)
    private String cidade;

    @Column(name = ESTADO, nullable = false)
    private String estado;

    @Column(name = CPF_CNPJ, nullable = false, unique = true, length = 14)
    private String cpfCnpj;

    @Column(name = SALARIO_RECEITA, precision = 2)
    private Double salarioReceita;

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
