package com.Recirende.Fidelidade.Model;

import com.Recirende.Fidelidade.Model.enuns.EstadoEnum;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "embalagem")
public class EmbalagemModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String marca;
    private String numeroDeSerie;
    private EstadoEnum localDeColeta;

    @ManyToOne(optional = true)
    @JoinColumn(name = "usuario_cpf", referencedColumnName = "cpf", nullable = true)
    private UsuarioModel usuario;


}
