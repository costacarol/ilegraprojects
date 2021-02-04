package com.costacarol.cloudnative.tema09;


public class ShutdownModule extends netflix.karyon.ShutdownModule{
	
	public ShutdownModule() {
	    super(7001);
	}
	
}