package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.request.CadastrarPessoaRequest;
import com.example.demo.entity.Pessoa;
import com.example.demo.entity.Pessoa.TipoPessoa;
import com.example.demo.jpa.PessoaRepository;
import com.example.demo.utils.ValidacaoDocumento;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CadastrarPessoaServiceImpl implements CadastrarPessoaService{

	@Autowired
	private PessoaRepository repository;
	private static final Logger log = LoggerFactory.getLogger(CadastrarPessoaServiceImpl.class);

	@Override
	public String cadastrarPessoa(CadastrarPessoaRequest request) throws Exception {
		ObjectMapper map = new ObjectMapper(); 
		String retorno;
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(request.getNome());

		
		if(request.getIdentificador() == null || request.getIdentificador().isBlank()) {
			log.error("CPF ou CNPJ não informado");
			retorno = "CPF ou CNPJ não informado";
		}else {
			if(request.getIdentificador().length() == 11  && 
					ValidacaoDocumento.isCPF(request.getIdentificador())) {
				
				pessoa.setIdentificador(request.getIdentificador());
				pessoa.setTipo(TipoPessoa.CPF);
				retorno = map.writeValueAsString(repository.save(pessoa));
				
			}else if(request.getIdentificador().length() == 14  && 
					ValidacaoDocumento.isCNPJ(request.getIdentificador())) {
				
				pessoa.setIdentificador(request.getIdentificador());
				pessoa.setTipo(TipoPessoa.CNPJ);
				retorno = map.writeValueAsString(repository.save(pessoa));
				
			}else {
				log.error("CPF ou CNPJ indicado incorretamente");
				retorno = "erro no campo identificador";
			}
		}
		
		log.info("salvando pessoa {}", retorno);
		return retorno;
		
	}
	
	
}
