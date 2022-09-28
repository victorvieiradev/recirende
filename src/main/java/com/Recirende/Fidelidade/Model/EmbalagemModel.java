package com.Recirende.Fidelidade.Model;

import com.Recirende.Fidelidade.Model.enuns.EstadoEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "embalagem")
public class EmbalagemModel implements Serializable {


    @Column
    private String marca;
    @Id
    @Column
    private String numeroDeSerie;
    @Column
    private EstadoEnum localDeColeta;

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "cpf")
    private UsuarioModel usuario;


}
