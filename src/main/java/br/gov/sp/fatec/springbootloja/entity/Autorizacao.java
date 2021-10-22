package br.gov.sp.fatec.springbootloja.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="aut_autorizacao")
public class Autorizacao {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="aut_id")
    private Long id;

    @Column(name="aut_nome")
    private String nome;

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "autorizacoes")
    private Set<Usuario> usuarios;

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

    
}
