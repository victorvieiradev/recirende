package com.Recirende.Fidelidade.Service;

import com.Recirende.Fidelidade.Exception.PontosInsuficientesException;
import com.Recirende.Fidelidade.Exception.ProdutoNaoEncontradoException;
import com.Recirende.Fidelidade.Exception.UsuarioNaoEncontradoException;
import com.Recirende.Fidelidade.Model.PremiosModel;
import com.Recirende.Fidelidade.Model.UsuarioModel;
import com.Recirende.Fidelidade.Repository.PremioRepository;
import com.Recirende.Fidelidade.Repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PremioRepository premioRepository;

    public UsuarioModel cadastrarUsuario(UsuarioModel usuarioModel){

        if (usuarioRepository.existsById(usuarioModel.getCpf())){
            throw new DuplicateKeyException(usuarioModel.getCpf());
        } else {
            return usuarioRepository.save(usuarioModel);
        }
    }

    public UsuarioModel atualizarUsuario(UsuarioModel usuarioModel){
        if (usuarioRepository.findAll().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }else
        if (usuarioRepository.existsById(usuarioModel.getCpf())){
            return usuarioRepository.save(usuarioModel);
        } else {
            //throw new NoSuchObjectException("usuarioModel");
            return null;
        }

    }

    public UsuarioModel deletarUsuario(String id){
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return null;
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

    }
        public List<UsuarioModel> mostrarTudo(){
        return usuarioRepository.findAll();
        }
        @Transactional
        public void resgatarPremios(Long idPremio, String cpfUsuario) throws ProdutoNaoEncontradoException, UsuarioNaoEncontradoException, PontosInsuficientesException {
          // usuarioRepository.findById(cpfUsuario).get().getPremios().add(premioRepository.findById(idPremio));

            Optional<PremiosModel> premiosModelOptional = premioRepository.findById(idPremio);

            if (!premiosModelOptional.isPresent()){
                throw new ProdutoNaoEncontradoException("O produto informado não existe.");
            }
            PremiosModel premiosModel = new PremiosModel();
            BeanUtils.copyProperties(premiosModelOptional.get(), premiosModel);
            Optional<UsuarioModel> usuarioModelOptional = usuarioRepository.findById(cpfUsuario);
            if (!usuarioModelOptional.isPresent()){
                throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
            }
            UsuarioModel usuarioModel = new UsuarioModel();
            BeanUtils.copyProperties(usuarioModelOptional.get(), usuarioModel);
            if (usuarioModel.getPontos()< premiosModel.getValorPremio()){
                throw new PontosInsuficientesException("Os seus pontos não são suficientes para resgatar o premio.");
            }
            usuarioModel.setPontos(usuarioModel.getPontos() - premiosModel.getValorPremio());

            usuarioModel.setPremios(usuarioModel.getPremios().addAll(premiosModel));

            usuarioRepository.save(usuarioModel);
            premioRepository.deleteById(idPremio);


        }

//        public Optional<UsuarioModel> mostrarResgatados(String cpf){;
//        }


}
