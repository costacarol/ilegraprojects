package com.costacarol.cloudnative.tema09.rest;

public class PowService {
	
	public Double pow(Double a, Double b){
		return Math.round(Math.pow(a, b)*100)/100d;
	}
	
}
