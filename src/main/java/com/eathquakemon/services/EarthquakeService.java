package com.eathquakemon.services;

import com.eathquakemon.models.Earthquake;

import java.util.List;

public interface EarthquakeService {

    /**
     * Fetch earthquakes higher than magnitude
     * @param magnitude magnitude of earthquake
     * @return list of earthquakes
     */
    List<Earthquake> fetchHigher(float magnitude);

    /**
     * Retrieve a  especific earthquake info
     * @param id earthquake's info
     * @return Earthquake Object
     */
    Earthquake fetch(String id);
}
