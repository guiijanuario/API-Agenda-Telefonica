package com.catalisa.primeiroProjeto.controller;

import com.catalisa.primeiroProjeto.model.ContatosModel;
import com.catalisa.primeiroProjeto.service.ContatosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api", produces = {"application/json"})
@Tag(name = "API Agenda Telefônica")
public class ContatosController {
    @Autowired
    ContatosService contatosService;


    //Endpoints de consulta
    //Requisição Get - pega todos os contatos no banco
    @GetMapping(path = "/v1/contatos")
    @Operation(summary = " : Pega todos os contatos do banco", method = "GET")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    public List<ContatosModel> buscaTodosContatos(){
        return contatosService.buscarTodos();
    }

    //Requisição Get - pega um contato através do ID
    @GetMapping(path = "/v1/contatos/{id}")
    @Operation(summary = " : Busca um ID especifico dentro do banco de dados", method = "GET")
    @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    public Optional<ContatosModel> buscarContatoPorId(@PathVariable Long id){
        return contatosService.buscarPorId(id);
    }

    //Endpoint de inserção
    //Requisição POST - insere algum dado dentro do banco
    @PostMapping(path = "/v1/contatos")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = " : Cria um novo contato", method = "POST")
    @ApiResponse(responseCode = "201", description = "Contato criado com sucesso")
    public ContatosModel cadastrarNovoContato(@RequestBody ContatosModel contatosModel){
        return contatosService.cadastrar(contatosModel);
    }

    //Endpoint de alteração
    //Requisição PUT - altera algum dado dentro do banco
    @PutMapping(path = "/v1/contatos/{id}")
    @Operation(summary = " : Altera um contato pelo ID", method = "PUT")
    @ApiResponse(responseCode = "200", description = "Contato alterado com sucesso")
        public ContatosModel alteraContato(@PathVariable Long id, @RequestBody ContatosModel contatosModel) {
            return contatosService.alterar(id, contatosModel);
    }

    //Endpoint de deleção
    //Requisição DELETE - deleta algum dado dentro do banco
    @DeleteMapping(path = "/v1/contatos/{id}")
    @Operation(summary = " : Deleta um contato pelo ID", method = "PUT")
    @ApiResponse(responseCode = "200", description = "Contato deletado com sucesso")
    public void deletaContatos(@PathVariable Long id){
        contatosService.deletar(id);
    }

}
