package com.earthquakemon.services;

import com.earthquakemon.entities.Report;
import com.earthquakemon.entities.Earthquake;

import java.util.List;

public interface EarthquakeService {

    String URL_CONSULTA = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_hour.geojson";
    String URL_PRUEBA = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/1.0_hour.geojson";

    /**
     * Fetch earthquakes higher than magnitude from remote server
     * @param magnitude magnitude of earthquake
     * @return Report object
     */
    Report fetchHigher(float magnitude);

    /**
     * Fetch earthquakes higher than magnitude from remote server, using RestTemplate
     * @return Report object
     */
    Report fetchHigher();


    /**
     * Retrieve all earthquakes
     * @param limit max number of earthquakes
     * @return list of earthquakes
     */
    List<Earthquake> findAll(int limit);

    /**
     * Retrieve a  especific earthquake info
     * @param id earthquake's info
     * @return Earthquake Object
     */
    Earthquake findById(String id);

    /**
     * Save an earthquake into db
     * @param earthquake earthquake object
     * @return earthquake saved into db with id autogenerated
     */
    Earthquake save(Earthquake earthquake);

    /**
     * Save a list of earthquakes into db
     * @param earthquakes list of earthquakes
     * @return list of earthquakes saved into db
     */
    List<Earthquake> save(List<Earthquake> earthquakes);

}