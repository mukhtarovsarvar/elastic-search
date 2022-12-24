package mukhtarov.elastic.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mukhtarov.elastic.document.Vehicle;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @author 'Mukhtarov Sarvarbek' on 23.12.2022
 * @project elastic
 * @contact @sarvargo
 * @
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class VehicleDummyDataService {

    private final VehicleService vehicleService;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public void insertDummyData() {
        vehicleService.index(buildVehicle("Audi 1","AAA-123","2010-01-01"));
        vehicleService.index(buildVehicle("Audi 2","AAA-124","2011-01-01"));
        vehicleService.index(buildVehicle("Audi 3","AAA-125","2011-01-02"));
        vehicleService.index(buildVehicle("Gentra 1","AAA-777","2014-12-12"));
        vehicleService.index(buildVehicle("Cobalt 1","AAA-666","2015-12-13"));
        vehicleService.index(buildVehicle("Matiz 1","AAC-124","2022-01-01"));
        vehicleService.index(buildVehicle("Orlando 2","AAS-124","2020-01-01"));
        vehicleService.index(buildVehicle("Malibu 1","AAB-124","2019-01-01"));
        vehicleService.index(buildVehicle("Malibu 2","AAT-124","2009-01-01"));
        vehicleService.index(buildVehicle("Cobalt 2","AAK-124","2003-01-01"));
        vehicleService.index(buildVehicle("Maztiz 2","AAY-124","2018-01-01"));
        vehicleService.index(buildVehicle("Gentra 2","AAL-124","2017-01-01"));
    }

    private static Vehicle buildVehicle(final String name,
                                        final String number,
                                        final String date) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(UUID.randomUUID().toString());
        vehicle.setName(name);
        vehicle.setName(number);
        try {
            vehicle.setCreated(DATE_FORMAT.parse(date));
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }

        return vehicle;
    }
}
