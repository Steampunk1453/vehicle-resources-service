package com.meep.vehicles.service;

import com.meep.vehicles.service.dto.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleResourcesServiceIT {

    @Autowired
    private VehicleResourcesService vehicleResourcesService;

    @Test
    public void givenTwoNumbersThenReturnsNegativeResult() {
        List<Vehicle> result = vehicleResourcesService.getVehicles();
        assertThat(result.size(), notNullValue());
        assertThat(result.isEmpty(), is(false));
    }

}

