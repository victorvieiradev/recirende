package com.Recirende.Fidelidade.models;

import com.Recirende.Fidelidade.Model.EmbalagemModel;
import com.Recirende.Fidelidade.Model.PremiosModel;
import com.Recirende.Fidelidade.Model.UsuarioModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UsuarioModelTests {
    @Test
    public void usuarioModelTests(){
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome("Ana");
        usuario.setCpf("11111111111");
        usuario.setPontos(1500L);
        Assertions.assertEquals("Ana", usuario.getNome());
        Assertions.assertEquals(12312343221L, usuario.getCpf());
        Assertions.assertEquals(1500L, usuario.getPontos());
    }
    }
