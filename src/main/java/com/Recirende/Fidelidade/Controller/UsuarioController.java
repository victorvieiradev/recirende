package com.Recirende.Fidelidade.Controller;

import com.Recirende.Fidelidade.Exception.ExceptionHandlerUsuario;
import com.Recirende.Fidelidade.Exception.PontosInsuficientesException;
import com.Recirende.Fidelidade.Exception.ProdutoNaoEncontradoException;
import com.Recirende.Fidelidade.Exception.UsuarioNaoEncontradoException;
import com.Recirende.Fidelidade.Model.UsuarioModel;
import com.Recirende.Fidelidade.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController extends ExceptionHandlerUsuario {

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
    public ResponseEntity<UsuarioModel> deletarUsuario(@PathVariable String id){
        return ResponseEntity.ok(usuarioService.deletarUsuario(id));
    }

    @GetMapping(path = "/usuario")
    public List<UsuarioModel> mostrarTodos(){
        return usuarioService.mostrarTudo();
    }
    @PutMapping(path = "/usuario/{cpf}/premios/{idPremio}")
    public ResponseEntity<String> resgatarPremios(@PathVariable Long idPremio, @PathVariable String cpf){
        try {
            usuarioService.resgatarPremios(idPremio, cpf);
            return ResponseEntity.status(HttpStatus.OK).body("Operação realizada com sucesso.");
        } catch (ProdutoNaoEncontradoException | UsuarioNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        } catch (PontosInsuficientesException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
