package br.com.fabionicola.cobranca_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")

public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column (nullable = false, unique = true, length = 20)
    private String documento;

    @Column (nullable = false, unique = true, length = 20)
    private String email;

    @Column (nullable = false)
    private String telefone;

    public Cliente(){
    }

    public Cliente (String nome, String documento, String email, String telefone){
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId(){return id;}

    public String getNome(){return nome;}
    public void setNome(String nome){this.nome = nome;}

    public String getDocumento(){return documento;}
    public void setDocumento(String documento){this.documento = documento;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getTelefone(){return telefone;}
    public void setTelefone(String telefone){this.telefone = telefone;}

}
