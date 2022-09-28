package com.Recirende.Fidelidade.models;

import com.Recirende.Fidelidade.Model.EmbalagemModel;
import com.Recirende.Fidelidade.Model.enuns.EstadoEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmbalagemModelTests {
    @Test
    public void embalagemModelTests(){
        EmbalagemModel embalagem = new EmbalagemModel();
        embalagem.setNumeroDeSerie("123d");
        Assertions.assertEquals("123d", embalagem.getNumeroDeSerie());
        Assertions.assertEquals(1L, embalagem.getNumeroDeSerie());
        embalagem.setMarca("doritos");
        Assertions.assertEquals("doritos", embalagem.getMarca());
        embalagem.setLocalDeColeta(EstadoEnum.DF);
        Assertions.assertEquals(EstadoEnum.DF, embalagem.getLocalDeColeta());
    }
}
