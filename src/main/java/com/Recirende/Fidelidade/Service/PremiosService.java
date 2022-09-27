package com.Recirende.Fidelidade.Service;

import com.Recirende.Fidelidade.Model.PremiosModel;
import com.Recirende.Fidelidade.Repository.PremioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PremiosService {

    @Autowired
    private PremioRepository premioRepository;

    public PremiosModel cadastrarPremio(PremiosModel premiosModel){
        return premioRepository.save(premiosModel);
    }

    public List<PremiosModel> verPremios(){
        if (premioRepository.findAll().isEmpty()){
            throw new NullPointerException();
        }else
            return premioRepository.findAll();
    }

    public PremiosModel alterarPremio(PremiosModel premiosModel){
        if (!(premioRepository.findById(premiosModel.getId()).isPresent())){
          throw new NoSuchElementException();
        }else {
        return  premioRepository.save(premiosModel);
        }
    }

    public PremiosModel deletarPremio(Long id){
        if (premioRepository.existsById(id)){
            premioRepository.deleteById(id);
            return null;
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
    }

}
