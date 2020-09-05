package com.study.dataanalisys.spark;

import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.stereotype.Component;

public class DataAnalisysSpark {
	private static final String PATH = System.getProperty("user.home") + "\\data\\in\\teste.txt";
	private JavaRDD<String> file;
	private JavaSparkContext ctx;

	public DataAnalisysSpark() {
		System.out.println(PATH);
		SparkConf conf = new SparkConf().setMaster("local").setAppName("IlegraDataAnalisys");
		this.ctx = new JavaSparkContext(conf);
		this.file = ctx.textFile(PATH);
	}

	public int countLines(String idLine) {
		return getFilterLines(idLine).size();
	}

	public List<String> getFilterLines(String idLine) {
		JavaRDD<String> filtered = file.filter(s -> s.startsWith(idLine));
		return filtered.collect();
	}

	public void closeStream() {
		ctx.close();
	}
}
