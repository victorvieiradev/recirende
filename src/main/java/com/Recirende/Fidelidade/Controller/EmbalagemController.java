package com.Recirende.Fidelidade.Controller;

import com.Recirende.Fidelidade.Model.EmbalagemModel;
import com.Recirende.Fidelidade.Model.enuns.EstadoEnum;
import com.Recirende.Fidelidade.Service.EmbalagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/embalagem")
public class EmbalagemController {
    @Autowired
    private EmbalagemService embalagemService;
    @GetMapping
    public ResponseEntity<List<EmbalagemModel>> listarEmbalagens(){
        return ResponseEntity.status(HttpStatus.OK).body(embalagemService.listarEmbalagens());
    }
    @PostMapping
    public ResponseEntity<?> cadastrarEmbalagem(@RequestBody EmbalagemModel embalagemModel){
        if (embalagemModel.getLocalDeColeta() != EstadoEnum.SP || embalagemModel.getLocalDeColeta() != EstadoEnum.MG ||
                embalagemModel.getLocalDeColeta() != EstadoEnum.ES || embalagemModel.getLocalDeColeta() != EstadoEnum.DF){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O Estado informado não possui local de coleta, apenas os estados: SP, MG, ES e DF são permitidos.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(embalagemService.cadastrarEmbalagem(embalagemModel));
    }
    @GetMapping(path = "{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable(value = "id") Long id){
        Optional<EmbalagemModel> embalagemModelOptional = embalagemService.buscarPorId(id);
        if (embalagemModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A embalagem não foi cadastrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(embalagemModelOptional.get());
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> excluir(@PathVariable(value = "id") Long id){
        Optional<EmbalagemModel> embalagemModelOptional = embalagemService.buscarPorId(id);
        if (embalagemModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A Embalagem solicitada para ser excluída não está cadastrada.");
        }
        embalagemService.excluir(embalagemModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("A embalagem foi excluída com sucesso!");
    }
    @PutMapping(path = "{id}")
    public ResponseEntity<?> atualizarEmbalagem(@RequestBody @PathVariable EmbalagemModel embalagemModel, Long id){
        Optional<EmbalagemModel> embalagemModelOptional = embalagemService.buscarPorId(id);
        if (embalagemModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A embalagem solicitada para ser atualizada não existe.");
        }
        embalagemModel.setId(embalagemModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(embalagemService.cadastrarEmbalagem(embalagemModel));
    }

}
