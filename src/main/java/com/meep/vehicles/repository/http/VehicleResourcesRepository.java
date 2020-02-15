package com.meep.vehicles.repository.http;

import com.meep.vehicles.service.dto.Vehicle;

import java.util.List;

public interface VehicleResourcesRepository {
    List<Vehicle> getVehicles();
}
