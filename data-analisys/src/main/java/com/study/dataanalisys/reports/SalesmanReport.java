package com.study.dataanalisys.reports;

import java.util.ArrayList;
import java.util.List;

import com.study.dataanalisys.entities.Salesman;
import com.study.dataanalisys.spark.DataAnalisysSpark;

public class SalesmanReport extends Report {

	private List<Salesman> salesmanList = new ArrayList<Salesman>();
	private DataAnalisysSpark spark;

	public SalesmanReport(DataAnalisysSpark spark) {
		this.spark = spark;
		this.salesmanList = getSalesmanList();
	}

	public List<Salesman> getSalesmanList() {
		List<String> lista = spark.getFilterLines(Salesman.idLine);
		for (String string : lista) {
			String[] salesmanArray = string.split(super.SPLITER);
			Salesman salesman = new Salesman(salesmanArray[1], salesmanArray[2], Double.parseDouble(salesmanArray[3]));
			salesmanList.add(salesman);
		}

		return salesmanList;
	}

	public String numberOfSalesman() {
		return "The quantity of salesmen in this file is " + spark.countLines(Salesman.idLine);
	}

	public String worstSalesman() {
		Salesman worstSalesman = null;
		for (Salesman salesman : this.salesmanList) {
			if (worstSalesman == null) {
				worstSalesman = salesman;
			}
			
			if(worstSalesman.compareTo(salesman) == 1) {
				worstSalesman = salesman;
			}
		}
		
		return "The worst salesman is " + worstSalesman.getName() + " wich cpf is " + worstSalesman.getCpf();
	}

}
