package com.Recirende.Fidelidade.Controller;

import com.Recirende.Fidelidade.Model.PremiosModel;
import com.Recirende.Fidelidade.Service.PremiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PremioController {

    @Autowired
    private PremiosService premiosService;

    @PostMapping(path = "/premios")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PremiosModel> cadastrarPremios(@RequestBody PremiosModel premiosModel){
        return ResponseEntity.ok(premiosService.cadastrarPremio(premiosModel));
    }

    @GetMapping(path = "/premios")
    public ResponseEntity<List<PremiosModel>> mostrarPremios(){
        return ResponseEntity.ok(premiosService.verPremios());
    }

    @PutMapping(path = "/premios/{id}")
    public ResponseEntity<PremiosModel> alterarPremio(@PathVariable Long id, @RequestBody PremiosModel premiosModel){
       return ResponseEntity.ok(premiosService.alterarPremio(premiosModel));
    }

    @DeleteMapping(path = "/premios/{id}")
    public ResponseEntity<PremiosModel> deletarPremio(@PathVariable Long id){
        return ResponseEntity.ok(premiosService.deletarPremio(id));
    }
}
