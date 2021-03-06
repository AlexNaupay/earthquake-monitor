package com.earthquakemon.services.impl;

import com.earthquakemon.entities.Earthquake;
import com.earthquakemon.entities.Report;
import com.earthquakemon.entities.mappers.ReportMapper;
import com.earthquakemon.repositories.EarthquakeRepository;
import com.earthquakemon.services.EarthquakeService;
import com.earthquakemon.usgs.FeatureCollectionMapper;
import com.earthquakemon.usgs.models.FeatureCollection;
import com.earthquakemon.utils.ServerRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EarthquakeServiceImpl implements EarthquakeService {

    private static Log logger = LogFactory.getLog(EarthquakeServiceImpl.class);

    private final EarthquakeRepository earthquakeRepository;

    @Autowired
    public EarthquakeServiceImpl(EarthquakeRepository earthquakeRepository) {
        this.earthquakeRepository = earthquakeRepository;
    }

    @Override
    public Report fetchHigher(float magnitude) {
        String report = ServerRequest.request(URL_CONSULTA);
        FeatureCollection featureCollection = FeatureCollectionMapper.mapperRow(report);

        return ReportMapper.mapper(featureCollection);
    }

    @Override
    public Report fetchHigher() {
        String report = ServerRequest.requestString(URL_CONSULTA);
        logger.debug("Earthquake report:"+report);
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
