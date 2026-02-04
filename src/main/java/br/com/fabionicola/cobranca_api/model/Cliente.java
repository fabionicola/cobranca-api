package br.com.fabionicola.cobranca_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes")

public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é Obrigatório")
    @Size(min = 3, max = 120, message = "Nome deve ter entre 3 e 120 caracteres")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "Documento é Obrigatório")
    @Size(min = 11, max = 14, message = "Documento deve ter entre 11 e 14 dígitos (CPF/CNPJ)")
    @Pattern(regexp = "^[0-9]+$", message = "Documento deve conter apenas números")
    @Column (nullable = false, unique = true, length = 20)
    private String documento;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    @Column (nullable = false, unique = true, length = 20)
    private String email;

    
    @NotBlank(message = "Telefone é obrigatório")
    @Size(min = 8, max = 20, message = "Telefone deve ter entre 8 e 20 caracteres")
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
