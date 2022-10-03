package com.example.demo.api.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CadastrarPessoaRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("nome")
	private String nome; 
	
	@JsonProperty("identificador")
	private String identificador;
	
}
