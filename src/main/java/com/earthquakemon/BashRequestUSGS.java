package com.earthquakemon;

import com.earthquakemon.entities.Earthquake;
import com.earthquakemon.entities.Report;
import com.earthquakemon.repositories.impl.EarthquakeRepositoryImpl;
import com.earthquakemon.services.EarthquakeService;
import com.earthquakemon.websocket.Brodcaster;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class BashRequestUSGS extends Thread{

    @Autowired
    private EarthquakeService earthquakeService;

    private Brodcaster brodcaster;

    private static Log logger = LogFactory.getLog(BashRequestUSGS.class);

    public void setBrodcaster(Brodcaster brodcaster) {
        this.brodcaster = brodcaster;
    }

    public void run(){
        while (true){
            Report report = earthquakeService.fetchHigher(2.3f);

            List<Earthquake> list = report.getEarthquakes();
            if (list != null)
                    list = earthquakeService.save(list);
            report.setEarthquakes(list);

            brodcaster.broadcast(Brodcaster.LATEST_EARTHQUAKE, report);
            logger.info("Request time: " + new Date().toString());
            try {
                // 1000*60*X = X min ; 5min = 300 000
                Thread.sleep(300000);
            } catch (InterruptedException e) {
                logger.error("*** fail sleep method");
            }
        }
    }

}
