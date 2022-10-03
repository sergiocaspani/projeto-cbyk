package com.example.demo.service;

import com.example.demo.api.request.CadastrarPessoaRequest;

public interface CadastrarPessoaService {

	String cadastrarPessoa(CadastrarPessoaRequest request)  throws Exception;
}
