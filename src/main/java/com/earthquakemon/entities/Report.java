package com.earthquakemon.entities;

import java.util.Date;
import java.util.List;


public class Report {
	//Codigo del Report
	//private String codigo;
	//Fecha generada en objeto Date (a partir del Longint de Metadata de FeatureCollection)
	private Date fechagenerado;
	//Numero de earthquakes contenidos en el reporte
	private int contador;
	
	//Lista de Sismos
	private List<Earthquake> earthquakes;

	public Report(Date fechagenerado, int contador, List<Earthquake> earthquakes) {

		//this.codigo = codigo;
		this.fechagenerado = fechagenerado;
		this.contador = contador;
		this.earthquakes = earthquakes;
	}

	public Date getFechagenerado() {
		return fechagenerado;
	}

	public void setFechagenerado(Date fechagenerado) {
		this.fechagenerado = fechagenerado;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public List<Earthquake> getEarthquakes() {
		return earthquakes;
	}

	public void setEarthquakes(List<Earthquake> earthquakes) {
		this.earthquakes = earthquakes;
	}

}
