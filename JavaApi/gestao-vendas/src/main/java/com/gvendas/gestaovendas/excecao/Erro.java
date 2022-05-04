package com.gvendas.gestaovendas.excecao;

public class Erro {

	private String msgUsuario;
	private String msgDesenvolvimento;

	public Erro(String msgUsuario, String msgDesenvolvimento) {
		this.msgUsuario = msgUsuario;
		this.msgDesenvolvimento = msgDesenvolvimento;
	}

	public String getMsgUsuario() {
		return msgUsuario;
	}

	public String getMsgDesenvolvimento() {
		return msgDesenvolvimento;
	}

}
