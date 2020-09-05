package com.study.dataanalisys.entities;

public class Salesman implements Comparable<Salesman>{

	public final static String idLine = "001";
	private String cpf;
	private String name;
	private Double salary;
	
	public Salesman(String cpf, String name, Double salary) {
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
	}

	public String getCpf() {
		return cpf;
	}

	public String getName() {
		return name;
	}

	public Double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "[cpf=" + cpf + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Salesman salesman) {
		return this.salary.compareTo(salesman.salary);
	}
	
	
	
}
