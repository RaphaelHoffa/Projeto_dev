package com.gvendas.gestaovendas.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	@Column(name = "logradouro")
	private Long logradouro;

	@Column(name = "numero")
	private String numero;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "bairro")
	private Boolean bairro;

	@Column(name = "cep")
	private Boolean cep;

	@Column(name = "cidade")
	private Boolean cidade;

	@Column(name = "estado")
	private Boolean estado;

	public Long getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Long logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Boolean getBairro() {
		return bairro;
	}

	public void setBairro(Boolean bairro) {
		this.bairro = bairro;
	}

	public Boolean getCep() {
		return cep;
	}

	public void setCep(Boolean cep) {
		this.cep = cep;
	}

	public Boolean getCidade() {
		return cidade;
	}

	public void setCidade(Boolean cidade) {
		this.cidade = cidade;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, complemento, estado, logradouro, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Endereco)) {
			return false;
		}
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(estado, other.estado) && Objects.equals(logradouro, other.logradouro)
				&& Objects.equals(numero, other.numero);
	}

}