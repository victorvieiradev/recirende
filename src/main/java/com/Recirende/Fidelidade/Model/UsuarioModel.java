package com.Recirende.Fidelidade.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @Column(nullable = false, unique = true)
    @Size(min = 11, max = 11)
    private Long cpf;

    @Column(nullable = false)
    private String nome;

    @Column
    private Long pontos;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<PremiosModel> premios;

    @JsonIgnore //1
    @OneToMany(mappedBy = "cpf", cascade = CascadeType.ALL)
    private List<EmbalagemModel> embalagemModel;

}