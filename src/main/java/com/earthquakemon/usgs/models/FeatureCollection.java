package com.earthquakemon.usgs.models;

import java.util.List;

//Objeto que devuelve la consulta al JSON.
public class FeatureCollection {

	private String type; //Valor Fijo FeatureCollection
	private Metadata metadata;
	private List<Feature> features;
	private double [] bbox;

	public FeatureCollection(String type, Metadata metadata,
			List<Feature> feautures, double[] bbox) {
		super();
		this.type = type;
		this.metadata = metadata;
		this.features = feautures;
		this.bbox = bbox;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public List<Feature> getFeautures() {
		return features;
	}

	public void setFeautures(List<Feature> feautures) {
		this.features = feautures;
	}

	public double[] getBbox() {
		return bbox;
	}

	public void setBbox(double[] bbox) {
		this.bbox = bbox;
	}
	
	
}
