package com.study.dataanalisys.process;

import com.study.dataanalisys.reports.CustumerReport;
import com.study.dataanalisys.reports.SalesmanReport;
import com.study.dataanalisys.spark.DataAnalisysSpark;

public class ProcessFile {

	private SalesmanReport sales;
	private CustumerReport custumer;
	private DataAnalisysSpark spark;
	
	public ProcessFile() {
		this.spark = new DataAnalisysSpark();
		
		this.sales = new SalesmanReport(this.spark);
		this.custumer = new CustumerReport(this.spark);
		System.out.println(sales.numberOfSalesman());
		System.out.println(sales.worstSalesman());
		System.out.println(custumer.numberOfCustumer());
	}
}
