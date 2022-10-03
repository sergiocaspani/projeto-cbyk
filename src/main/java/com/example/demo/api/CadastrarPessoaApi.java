package com.example.demo.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.request.CadastrarPessoaRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Pessoa")
@RestController
public interface CadastrarPessoaApi {
	
	
	@ApiOperation(value="Api Cadastrar Pessoa")
	@RequestMapping(value= "/cadastrarPessoa", method = RequestMethod.POST, headers = "Accept=application/json")
	public String cadastraPessoa(@RequestBody CadastrarPessoaRequest request) throws Exception;

}
