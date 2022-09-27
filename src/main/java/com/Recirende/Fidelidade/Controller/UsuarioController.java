package com.Recirende.Fidelidade.Controller;

import com.Recirende.Fidelidade.Model.UsuarioModel;
import com.Recirende.Fidelidade.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@RequestBody UsuarioModel usuarioModel){
    return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuarioModel));
    }

    @PutMapping(path = "/usuario/{id}")
    public ResponseEntity<UsuarioModel> atualizarUsuario(@RequestBody UsuarioModel usuarioModel, @PathVariable Long id){
        return ResponseEntity.ok(usuarioService.atualizarUsuario(usuarioModel));
    }

    @DeleteMapping(path = "/usuario/{id}")
    public ResponseEntity<UsuarioModel> deletarUsuario(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.deletarUsuario(id));
    }


}
