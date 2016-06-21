package com.earthquakemon.usgs.models;

public class Geometry {

	private String type; //Valo fijo= "Point"

	//Vector tamaño 3  [ longitude, latitude, depth ]
	private double[] coordinates;

	public Geometry() {
	}

	public Geometry(String type, double[] coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(double[] coordinates) {
		this.coordinates = coordinates;
	}
	
	
	
}
