package com.study.dataanalisys.entities;

public class Custumer {

	public final static String idLine = "002";
	private String cpf;
	private String name;
	
	public Custumer(String cpf, String name) {
		this.cpf = cpf;
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "[cpf=" + cpf + ", name=" + name + "]";
	}
	
}
