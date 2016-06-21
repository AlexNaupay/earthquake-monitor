package com.earthquakemon.entities.mappers;


import com.earthquakemon.entities.Earthquake;
import com.earthquakemon.entities.Report;
import com.earthquakemon.usgs.models.Feature;
import com.earthquakemon.usgs.models.FeatureCollection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportMapper {

    /**
     * Metodo para convertir un objeto tipo  FeatureCollection del JSON a un objeto tipo Reporte
     * que se usara en la base de datos y en la aplicacion.
     * @param objetosjson El objeto FeatureCollection obtenido del Json
     * @return Un objeto tipo reporte debidamente llenado con sus datos y sismos, si los hubiera
     */
    public static Report mapper(FeatureCollection objetosjson) {

        Report reporte = null;
        List<Earthquake> sismos;

        //Capturar datos desde el Objeto JSON convertido
        Date fechagenerado = new Date(objetosjson.getMetadata().getGenerated());
        int contador = objetosjson.getMetadata().getCount();

        //Count retorna si hubo resultados de sismos en la consulta o no
        if (contador == 0) {
            //Si no hubo resultados en la consulta;
            //Se retornara un objeto reporte con fecha, contador y lista de sismos null
            //Comprobar en el controlador q si List<Sismo> es null, mostrar q no hay sismos +2.5 en el periodo de 5 minutos.
            reporte = new Report(fechagenerado, contador, null);
        } else {
            //Hay sismos en el reporte
            sismos = featuresToEarquakes(objetosjson.getFeautures(), contador);
            //Se guarda en objeto reporte  fecha, contador y lista de sismos
            reporte = new Report(fechagenerado, contador, sismos);
        }

        //Comprobar si lista de sismos es nulo
        return reporte;
    }

    /**
     * Metodo interno para convertir la List<Feature> en una lista de Sismos.
     * Este metodo es usado por el metodo superior mapper()
     *
     * @param objetosfeatures Una Lista de Feature
     * @param contador Numero de resultados, tiene que ser mayor a cero
     * @return
     */
    public static List<Earthquake> featuresToEarquakes(List<Feature> objetosfeatures, int contador) {
        List<Earthquake> sismos = null;

        //Creacion de la lista de Sismos
        sismos = new ArrayList<Earthquake>();

        String id;
        String alerta;
        String titulo;
        double magnitud;
        String lugar;
        Date tiempo;
        Date actualizacion;
        String url;
        String urldetalle;
        int tsunami;
        String tipo;
        double longitud;
        double latitud;
        double profundidad;
        int significancia;

        double[] coordenadas;

        Earthquake temporal;

        for (int i = 0; i < contador; i++) {
            //Capturar variables desde la lista de Features del Json Original.
            id = objetosfeatures.get(i).getId();
            alerta = objetosfeatures.get(i).getProperties().getAlert();
            titulo = objetosfeatures.get(i).getProperties().getTitle();
            magnitud = objetosfeatures.get(i).getProperties().getMag();
            lugar = objetosfeatures.get(i).getProperties().getPlace();
            tiempo = new Date(objetosfeatures.get(i).getProperties().getTime());
            actualizacion = new Date(objetosfeatures.get(i).getProperties().getUpdated());
            url = objetosfeatures.get(i).getProperties().getUrl();
            urldetalle = objetosfeatures.get(i).getProperties().getDetail();
            tsunami = objetosfeatures.get(i).getProperties().getTsunami();
            tipo = objetosfeatures.get(i).getProperties().getType();

            coordenadas = objetosfeatures.get(i).getGeometry().getCoordinates();

            longitud = coordenadas[0];
            latitud = coordenadas[1];
            profundidad = coordenadas[2];

            significancia = objetosfeatures.get(i).getProperties().getSig();

            temporal = new Earthquake(id, alerta,titulo, magnitud, lugar, tiempo, actualizacion, url, urldetalle, tsunami, tipo, longitud, latitud, profundidad, significancia);
            sismos.add(temporal);
        }

        return sismos;
    }

}
