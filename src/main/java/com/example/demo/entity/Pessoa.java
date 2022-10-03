package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;


@Entity
@Table(name = "Pessoa")
@Data
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Nome")
	private String nome; 
	
	@Column(name = "Identificar")
	private String identificador;

	@Column(name = "Tipo_Identificador")
	private TipoPessoa tipo;
	
	@Getter
	public enum TipoPessoa {
		CPF("CPF"),
		CNPJ("CNPJ");
		
	   String tipoDocumento;
	   
		TipoPessoa(String tipoPessoa) {
			this.tipoDocumento= tipoPessoa;
		}
	
	}

}
