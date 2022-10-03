package com.Recirende.Fidelidade.Controller;

import com.Recirende.Fidelidade.Exception.ExceptionHandlerUsuario;
import com.Recirende.Fidelidade.Exception.PontosInsuficientesException;
import com.Recirende.Fidelidade.Exception.ProdutoNaoEncontradoException;
import com.Recirende.Fidelidade.Exception.UsuarioNaoEncontradoException;
import com.Recirende.Fidelidade.Model.UsuarioModel;
import com.Recirende.Fidelidade.Model.UsuarioResponse;
import com.Recirende.Fidelidade.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController extends ExceptionHandlerUsuario {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody UsuarioModel usuarioModel){
    return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuarioModel));
    }

    @PutMapping(path = "/usuarios/{id}")
    public ResponseEntity<UsuarioModel> atualizarUsuario(@RequestBody UsuarioModel usuarioModel, @PathVariable Long id){
        return ResponseEntity.ok(usuarioService.atualizarUsuario(usuarioModel));
    }

    @DeleteMapping(path = "/usuarios/{id}")
    public ResponseEntity<UsuarioModel> deletarUsuario(@PathVariable String id){
        return ResponseEntity.ok(usuarioService.deletarUsuario(id));
    }

    @GetMapping(path = "/usuarios")
    public ResponseEntity<List<UsuarioModel>> mostrarTodos(){
        return ResponseEntity.ok(usuarioService.mostrarUsuarios());
    }

    @GetMapping(path = "/usuarios/{cpf}")
    public ResponseEntity<Optional<UsuarioModel>> mostrarPorId(@PathVariable String cpf){
        return ResponseEntity.ok(usuarioService.buscarPorId(cpf));
    }

    @PutMapping(path = "/usuarios/{cpf}/premios/{idPremio}")
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
