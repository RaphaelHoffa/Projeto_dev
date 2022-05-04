package com.gvendas.gestaovendas.dto;

import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Categoria retorno DTO")
public class CategoriaResponseDTO {

	@ApiModelProperty(value = "Coódigo")
	private Long codigo;
	
	@ApiModelProperty(value = "Nome")
	private String nome;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
