package com.earthquakemon.usgs;

import com.earthquakemon.usgs.models.FeatureCollection;
import com.google.gson.Gson;

public class FeatureCollectionMapper {
    /**
     * Metodo para convertir el JSON en un objeto FeatureCollection
     * FeatureCollection es una clase con la siguiente estructura
     * <p>
     * private String type; //Valor Fijo FeatureCollection
     * private Metadata metadata -- Datos adicionales del Report
     * private List<Feature> features --Aqui estan los sismos en forma de Arreglo
     * <p>
     * private double [] bbox // No se usara
     * <p>
     * Cada Feauture tiene la estructura
     * private String id;
     * private String type; //Valor fijo= "Feature"
     * private Properties properties;
     * private Geometry geometry;
     *
     * @param json String conteniendo el JSON
     * @return featureCollection
     */
    public static FeatureCollection mapperRow(String json) {
        FeatureCollection featurecollection = null;
        Gson gson = new Gson();

        if (json.isEmpty()) {
            System.out.println("Error en el String , esta vacio");
        } else {
            featurecollection = gson.fromJson(json, FeatureCollection.class);
        }

        return featurecollection;
    }

}
