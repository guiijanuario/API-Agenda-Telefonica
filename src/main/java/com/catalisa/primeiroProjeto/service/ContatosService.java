package com.catalisa.primeiroProjeto.service;

import com.catalisa.primeiroProjeto.model.ContatosModel;
import com.catalisa.primeiroProjeto.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatosService {
    @Autowired
    ContatosRepository contatosRepository;

    //método que busca todos os contatos no banco
    public List<ContatosModel> buscarTodos(){
        return contatosRepository.findAll();
    }

    //método que busca um contato no banco pelo id
    public Optional<ContatosModel> buscarPorId(Long id){
        return contatosRepository.findById(id);
    }

    //método que cadastra um novo contato dentro do banco
    public ContatosModel cadastrar(ContatosModel contatosModel){
        return contatosRepository.save(contatosModel);
    }

    //método que altera um contato já existente no banco
    public ContatosModel alterar(Long id, ContatosModel contatosModel) {
        ContatosModel contatos = buscarPorId(id).get();

        if(contatosModel.getNome() != null) {
            contatos.setNome(contatosModel.getNome());
        }
        if(contatosModel.getTelefone() != null) {
            contatos.setTelefone(contatosModel.getTelefone());
        }
        return contatosRepository.save(contatos);
    }

    //método que deleta um contato já existente no banco
    public void deletar(Long id){
        contatosRepository.deleteById(id);
    }
}
