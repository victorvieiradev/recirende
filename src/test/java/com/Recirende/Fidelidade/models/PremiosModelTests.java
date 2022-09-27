package com.Recirende.Fidelidade.models;

import com.Recirende.Fidelidade.Model.PremiosModel;
import com.Recirende.Fidelidade.Model.UsuarioModel;
import com.Recirende.Fidelidade.Model.enuns.PremioEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PremiosModelTests {
    @Test
    public void premiosModelTests(){
        PremiosModel premios = new PremiosModel();
        premios.setNomePremio("iphone");
        Assertions.assertEquals("iphone", premios.getNomePremio());
        premios.setValorPremio(3000L);
        Assertions.assertEquals(3000L, premios.getValorPremio());
        premios.setId(1L);
        Assertions.assertEquals(1L, premios.getId());
        premios.setTipo(PremioEnum.BENEFICIOS);
        Assertions.assertEquals(PremioEnum.BENEFICIOS, premios.getTipo());
        UsuarioModel usuario = new UsuarioModel();
        premios.setUsuario(usuario);
        Assertions.assertEquals(new UsuarioModel(), premios.getUsuario());
    }
}
