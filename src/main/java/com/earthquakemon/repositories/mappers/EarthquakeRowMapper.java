package com.earthquakemon.repositories.mappers;


import com.earthquakemon.entities.Earthquake;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EarthquakeRowMapper implements RowMapper<Earthquake>{

    @Override
    public Earthquake mapRow(ResultSet result, int i) throws SQLException {
        Earthquake earthquake = new Earthquake();

        earthquake.setIdPk(result.getLong("id_pk"));
        earthquake.setId(result.getString("id"));
        earthquake.setAlerta(result.getString("alerta"));
        earthquake.setTitulo(result.getString("titulo"));
        earthquake.setMagnitud(result.getDouble("magnitud"));
        earthquake.setLugar(result.getString("lugar"));
        earthquake.setTiempo(result.getTimestamp("tiempo"));
        earthquake.setActualizacion(result.getTimestamp("actualizacion"));
        earthquake.setUrl(result.getString("url"));
        earthquake.setUrldetalle(result.getString("urldetalle"));
        earthquake.setTsunami(result.getInt("tsunami"));
        earthquake.setTipo(result.getString("tipo"));
        earthquake.setSignificancia(result.getInt("significancia"));
        earthquake.setLongitud(result.getDouble("longitud"));
        earthquake.setLatitud(result.getDouble("latitud"));
        earthquake.setProfundidad(result.getDouble("profundidad"));

        return earthquake;
    }
}
