package com.meep.vehicles.service;

import com.meep.vehicles.service.dto.Vehicle;

import java.util.List;

public interface ComparatorService {
    List<Vehicle> compareVehicleLists(List<Vehicle> list1, List<Vehicle> list2);
}
