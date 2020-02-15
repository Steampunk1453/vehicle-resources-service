package com.meep.vehicles.service;

import com.meep.vehicles.repository.http.VehicleResourcesRepository;
import com.meep.vehicles.service.dto.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class DefaultVehicleResourcesService implements VehicleResourcesService {

    private final VehicleResourcesRepository vehicleResourcesRepository;
    private final ComparatorService comparatorService;

    private List<Vehicle> oldVehicles = new ArrayList<>();

    public DefaultVehicleResourcesService(VehicleResourcesRepository vehicleResourcesRepository, ComparatorService comparatorService) {
        this.vehicleResourcesRepository = vehicleResourcesRepository;
        this.comparatorService = comparatorService;
    }

    @Override
    @Scheduled(fixedDelayString = "${scheduler.delay.execution.interval}", initialDelayString = "${scheduler.delay.execution.initial}")
    public synchronized List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = null;

        List<Vehicle> newVehicles = vehicleResourcesRepository.getVehicles();
        log.debug("Task performed on: " + new Date() + "n" + "Thread's name: " + Thread.currentThread().getName());

        if (this.oldVehicles != null && newVehicles != null) {
           vehicles = comparatorService.compareVehicleLists(oldVehicles, newVehicles);
        }

        this.oldVehicles = newVehicles;

        return vehicles;
    }

}
