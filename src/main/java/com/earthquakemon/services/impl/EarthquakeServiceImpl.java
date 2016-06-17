package com.earthquakemon.services.impl;

import com.earthquakemon.entities.Earthquake;
import com.earthquakemon.entities.Report;
import com.earthquakemon.entities.mappers.ReportMapper;
import com.earthquakemon.repositories.EarthquakeRepository;
import com.earthquakemon.services.EarthquakeService;
import com.earthquakemon.usgs.FeatureCollectionMapper;
import com.earthquakemon.usgs.models.FeatureCollection;
import com.earthquakemon.utils.ServerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EarthquakeServiceImpl implements EarthquakeService {

    @Autowired
    private EarthquakeRepository earthquakeRepository;

    @Override
    public Report fetchHigher(float magnitude) {
        String report = ServerRequest.request(URL_CONSULTA);
        FeatureCollection featureCollection = FeatureCollectionMapper.mapperRow(report);

        return ReportMapper.mapper(featureCollection);
    }

    @Override
    public List<Earthquake> findAll(int limit) {
        return earthquakeRepository.findAll(limit);
    }

    @Override
    public Earthquake findById(String id) {
        return earthquakeRepository.findById(id);
    }

    @Override
    public Earthquake save(Earthquake earthquake) {
        return earthquakeRepository.save(earthquake);
    }

    @Override
    public List<Earthquake> save(List<Earthquake> earthquakes) {
        return earthquakeRepository.save(earthquakes);
    }
}
