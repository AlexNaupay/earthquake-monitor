package com.earthquakemon.repositories.utils;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import com.earthquakemon.entities.Report;
import com.earthquakemon.entities.Earthquake;
import org.apache.commons.lang3.StringUtils;

public class QueryBuilder {

    //BD se llama bdsismos, tabla sismos
    public static final String CONSULTA_INSERT = "INSERT INTO `sismos` " +
            "(`id`, `titulo`, `magnitud`, `lugar`, `tiempo`, `actualizacion`, `url`," +
            " `urldetalle`, `tsunami`, `tipo`, `significancia`, `longitud`, `latitud`, " +
            "`profundidad`) VALUES ";

    public static final String LATEST_QUERY = "SELECT * FROM (SELECT * FROM sismos ORDER BY id_pk DESC LIMIT #limit#)  tbl ORDER BY tbl.id_pk";
    public static final String FIND_BY_ID_QUERY = "SELECT * FROM sismos WHERE id = ?";

    public static final String CONSULTA_SELECT_TIEMPO = "SELECT * FROM sismos " + "WHERE tiempo ";

    public static final String ORDEN_FECHA = " ORDER BY tiempo";


    public static String latestEarthquakesQuery(int limit){
        return StringUtils.replace(LATEST_QUERY,"#limit#", String.valueOf(limit));
    }

    //Usar solo este metodo despues de comprobar que el report no tenga su
    //Lista de sismos= nulo
    public static String insertarSismos(Report report) {

        StringBuilder consulta = new StringBuilder();
        consulta.append(CONSULTA_INSERT);

        List<Earthquake> earthquakes = report.getEarthquakes();

        //Recorre la lista de earthquakes para generar el insert
        for (int i = 0; i < earthquakes.size(); i++) {
            consulta.append("(");

            consulta.append("\'").append(earthquakes.get(i).getId()).append("\' , ");
            consulta.append("\'").append(earthquakes.get(i).getTitulo()).append("\' , ");
            consulta.append("\'").append(earthquakes.get(i).getMagnitud()).append("\' , ");
            consulta.append("\'").append(earthquakes.get(i).getLugar()).append("\' , ");
            consulta.append("\'").append(fechaFormato(earthquakes.get(i).getTiempo())).append("\' , ");
            consulta.append("\'").append(fechaFormato(earthquakes.get(i).getActualizacion())).append("\' , ");
            consulta.append("\'").append(earthquakes.get(i).getUrl()).append("\' , ");
            consulta.append("\'").append(earthquakes.get(i).getUrldetalle()).append("\' , ");
            consulta.append("\'").append(earthquakes.get(i).getTsunami()).append("\' , ");
            consulta.append("\'").append(earthquakes.get(i).getTipo()).append("\' , ");
            consulta.append("\'").append(earthquakes.get(i).getSignificancia()).append("\' ,");
            consulta.append("\'").append(earthquakes.get(i).getLongitud()).append("\' , ");
            consulta.append("\'").append(earthquakes.get(i).getLatitud()).append("\' , ");
            consulta.append("\'").append(earthquakes.get(i).getProfundidad()).append("\'");

            consulta.append(")");

            if (i < earthquakes.size() - 1) {
                consulta.append(" , ");
            } else {
                consulta.append(" ");
            }
        }

        return consulta.toString();

    }


    //Retorna todos los datos de un tipo Earthquake segun el rango de fechas,
    //Ordena los resultados por fecha

    public static String retornarSismos(Date inicio, Date fin) {
        StringBuilder consulta = new StringBuilder();

        consulta.append(CONSULTA_SELECT_TIEMPO);
        consulta.append(" BEETWEN ");
        consulta.append("\'").append(fechaFormato(inicio)).append("\'");
        consulta.append(" AND ");
        consulta.append("\'").append(fechaFormato(fin)).append("\' ");
        consulta.append(ORDEN_FECHA);

        return consulta.toString();
    }

    /**
     * Metodo para convertir Date a fecha para guardado en la BD. Usado en el metodo que genera
     * el INSERT
     * @param fecha
     * @return
     */
    public static String fechaFormato(Date fecha) {
        String fechaformato = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        fechaformato = sdf.format(fecha);
        return fechaformato;
    }

}
