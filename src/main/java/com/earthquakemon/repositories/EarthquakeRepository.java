package com.earthquakemon.repositories;

import com.earthquakemon.entities.Earthquake;
import com.earthquakemon.entities.Report;

import java.util.List;

public interface EarthquakeRepository {

    /**
     * Retrieve all earthquakes from db
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
