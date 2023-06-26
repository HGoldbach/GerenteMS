package br.bantads.gerente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_gerentes")
public class Gerente implements Serializable, Comparable<Gerente> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_gerente")
    private Integer id;
    @Column(name="nome_gerente")
    private String nome;
    @Column(name="email_gerente")
    private String email;
    @Column(name="cpf_gerente", unique = true)
    private String cpf;
    @Column(name="telefone_gerente")
    private String telefone;
    @Column(name="perfil")
    private String perfil;

    public Gerente() {
        super();
    }

    public Gerente(Integer id, String nome, String email, String cpf, String telefone, String perfil) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.perfil = perfil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public int compareTo(Gerente gerente) {
        return getNome().compareTo(gerente.getNome());
    }
}
