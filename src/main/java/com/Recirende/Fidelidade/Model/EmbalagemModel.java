package com.Recirende.Fidelidade.Model;

import com.Recirende.Fidelidade.Model.enuns.EstadoEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "embalagem")
public class EmbalagemModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @Column
    private String marca;
    @Id
    @Column
    private String numeroDeSerie;
    @Column
    private EstadoEnum localDeColeta;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "usuario", referencedColumnName = "cpf")
    private UsuarioModel usuario;


}
