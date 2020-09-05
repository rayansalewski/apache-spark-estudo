package com.study.dataanalisys.reports;

import java.util.ArrayList;
import java.util.List;

import com.study.dataanalisys.entities.Custumer;
import com.study.dataanalisys.spark.DataAnalisysSpark;

public class CustumerReport extends Report{

	private List<Custumer> custumerList = new ArrayList<Custumer>();
	private DataAnalisysSpark spark;

	public CustumerReport(DataAnalisysSpark spark) {
		this.spark = spark;
		this.custumerList = getCustumerList();
	}
	
	public List<Custumer> getCustumerList() {
		List<String> lista = spark.getFilterLines(Custumer.idLine);
		for (String string : lista) {
			String[] salesmanArray = string.split(super.SPLITER);
			Custumer salesman = new Custumer(salesmanArray[1], salesmanArray[2]);
			custumerList.add(salesman);
		}

		return custumerList;
	}

	public String numberOfCustumer() {
		return "The quantity of custumer in this file is " + spark.countLines(Custumer.idLine);
	}
}
