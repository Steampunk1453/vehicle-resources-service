package com.meep.vehicles.service;

import com.meep.vehicles.service.dto.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DefaultComparatorService implements ComparatorService {

    @Override
    public List<Vehicle> compareVehicleLists(List<Vehicle> list1, List<Vehicle> list2) {
        List<Vehicle> removed = list1.stream().filter(v1 -> list2.stream().noneMatch(v2 -> v2.getId().equals(v1.getId())))
                .collect(Collectors.toList());

        if (!removed.isEmpty()) {
            log.info("Vehicles removed");
            removed.forEach((vehicle) -> {log.info(vehicle.toString());});
            return removed;
        }

        List<Vehicle> added = list2.stream().filter(v1 -> list1.stream().noneMatch(v2 -> v2.getId().equals(v1.getId())))
                .collect(Collectors.toList());

        if (!added.isEmpty()) {
            log.info("Vehicles added");
            added.forEach((vehicle) -> {log.info(vehicle.toString());});
            return added;
        }

        log.info("Same vehicles");

        return list2;
    }
}
