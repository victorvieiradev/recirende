package com.Recirende.Fidelidade.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column( unique = true)
    @Size(min = 11, max = 11)
    private String cpf;

    @Column
    private String nome;

    @Column
    private Long pontos = 0L;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "usuario1", cascade = CascadeType.ALL)
    private List<PremiosModel> premios;


    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<EmbalagemModel> embalagemModel;
    private String listaDePremios;



}