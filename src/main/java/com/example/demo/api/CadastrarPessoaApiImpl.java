package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.api.request.CadastrarPessoaRequest;
import com.example.demo.entity.Pessoa;
import com.example.demo.service.CadastrarPessoaService;

@Component
public class CadastrarPessoaApiImpl implements CadastrarPessoaApi {

	@Autowired
	CadastrarPessoaService service;
	
	@Override
	public String cadastraPessoa(CadastrarPessoaRequest request)  throws Exception{
		return service.cadastrarPessoa(request);
	}

}
