package mukhtarov.elastic.controller;

import lombok.RequiredArgsConstructor;
import mukhtarov.elastic.document.Vehicle;
import mukhtarov.elastic.search.SearchRequestDTO;
import mukhtarov.elastic.service.VehicleDummyDataService;
import mukhtarov.elastic.service.VehicleService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author 'Mukhtarov Sarvarbek' on 19.12.2022
 * @project elastic
 * @contact @sarvargo
 */

@RestController
@RequestMapping("/api/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    private final VehicleDummyDataService vehicleDummyDataService;

    @PostMapping("")
    public void save(@RequestBody final Vehicle vehicle) {
        Boolean index = vehicleService.index(vehicle);
        System.out.println(
                index
        );
    }

    @GetMapping("/insertdummydata")
    public void insertDummyData() {
        vehicleDummyDataService.insertDummyData();
    }


    @GetMapping("/{id}")
    public Vehicle findById(@PathVariable("id") final String id) {
        return vehicleService.getById(id);
    }

    @PostMapping("/search")
    public List<Vehicle> search(@RequestBody final SearchRequestDTO dto) {
        return vehicleService.search(dto);
    }

    @GetMapping("/search/{date}")
    public List<Vehicle> getAllVehiclesCreatedSince(
            @PathVariable
            @DateTimeFormat(pattern = "yyyy-MM-dd") final Date date) {
        return vehicleService.getAllVehiclesCreatedSince(date);
    }

    @PostMapping("/searchcreatedsince/{date}")
    public List<Vehicle> searchCreatedSince
            (@RequestBody final SearchRequestDTO dto,
             @PathVariable
             @DateTimeFormat(pattern = "yyyy-MM-dd") final Date date) {

        return vehicleService.searchCreatedSince(dto,date);

    }
}
