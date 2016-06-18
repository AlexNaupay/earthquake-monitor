package com.earthquakemon.repositories.impl;

import com.earthquakemon.entities.Earthquake;
import com.earthquakemon.repositories.EarthquakeRepository;
import com.earthquakemon.repositories.mappers.EarthquakeRowMapper;
import com.earthquakemon.repositories.utils.QueryBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EarthquakeRepositoryImpl implements EarthquakeRepository {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    private static final Log logger = LogFactory.getLog(EarthquakeRepositoryImpl.class);

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(this.dataSource)
                .withTableName("sismos")
                .usingGeneratedKeyColumns("id_pk");
    }



    @Override
    public List<Earthquake> findAll(int limit) {
        return jdbcTemplate.query(QueryBuilder.latestEarthquakesQuery(limit), new EarthquakeRowMapper());
    }

    @Override
    public Earthquake findById(String id) {
        try {
            return jdbcTemplate.queryForObject(QueryBuilder.FIND_BY_ID_QUERY, new Object[]{id}, new EarthquakeRowMapper());
        }catch (EmptyResultDataAccessException erdae){
            logger.error("** EmptyResultDataAccessException in finfById method");
            return null;
        }catch (Exception e){
            logger.error("** Exception in finfById method");
            return null;
        }

    }

    @Override
    public Earthquake save(Earthquake earthquake) {

        if (findById(earthquake.getId()) != null){
            logger.info("Exist earthquake with id " + earthquake.getId());
            return null;
        }

        Map<String, Object> parameters = new HashMap<>(15);
        //parameters.put("id_pk", earthquake.getIdPk());
        parameters.put("id", earthquake.getId());
        parameters.put("titulo", earthquake.getTitulo());
        parameters.put("alerta", earthquake.getAlerta());
        parameters.put("magnitud", earthquake.getMagnitud());
        parameters.put("lugar", earthquake.getLugar());
        parameters.put("tiempo", earthquake.getTiempo());
        parameters.put("actualizacion", earthquake.getActualizacion());
        parameters.put("url", earthquake.getUrl());
        parameters.put("urldetalle", earthquake.getUrldetalle());
        parameters.put("tsunami", earthquake.getTsunami());
        parameters.put("tipo", earthquake.getTipo());
        parameters.put("significancia", earthquake.getSignificancia());
        parameters.put("longitud", earthquake.getLongitud());
        parameters.put("latitud", earthquake.getLatitud());
        parameters.put("profundidad", earthquake.getProfundidad());

        try {
            Number newId = simpleJdbcInsert.executeAndReturnKey(parameters);
            earthquake.setIdPk(newId.longValue());
            return earthquake;

        }catch (org.springframework.dao.DuplicateKeyException dke){
            logger.error("** DuplicateKeyException in save method");
            return null;
        }catch (Exception e){
            logger.error("** Exception in save method");
            return null;
        }

    }

    @Override
    public List<Earthquake> save(List<Earthquake> earthquakes) {
        List<Earthquake> list = new ArrayList<>();
        Earthquake temp = null;

        for (Earthquake earthquake : earthquakes ){
            temp = save(earthquake);
            if ( temp != null)  // save into db without errors
                list.add(temp);
        }

        return list;
    }
}
