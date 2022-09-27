package com.Recirende.Fidelidade.Service;

import com.Recirende.Fidelidade.Model.PremiosModel;
import com.Recirende.Fidelidade.Repository.PremioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
