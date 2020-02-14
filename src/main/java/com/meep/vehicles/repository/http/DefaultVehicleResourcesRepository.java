package com.meep.vehicles.repository.http;

import com.meep.vehicles.service.dto.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
@Slf4j
public class DefaultVehicleResourcesRepository implements VehicleResourcesRepository {

    @Value("${vehicle.resources.endpoint}")
    private String vehicleResourcesEndpoint;

    private final RestTemplate restTemplate;

    public DefaultVehicleResourcesRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Vehicle> getVehicles() {
        String URL = vehicleResourcesEndpoint;
        log.debug("URL endpoint: " + URL);
        Vehicle[] transportResources = restTemplate.getForObject(URL, Vehicle[].class);
        return Arrays.asList(Objects.requireNonNull(transportResources));
    }

}
