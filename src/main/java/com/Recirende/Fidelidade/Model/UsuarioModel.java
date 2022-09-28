package com.Recirende.Fidelidade.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable {

    @Id
    @Column( unique = true)
    @Size(min = 11, max = 11)
    private String cpf;

    @Column
    private String nome;

    @Column
    private Long pontos;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario1", cascade = CascadeType.ALL)
    private List<PremiosModel> premios;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<EmbalagemModel> embalagemModel;

}