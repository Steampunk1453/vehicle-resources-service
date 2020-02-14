package com.meep.vehicles.service;

import com.meep.vehicles.repository.http.VehicleResourcesRepository;
import com.meep.vehicles.service.dto.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehicleResourcesServiceTest {

    @InjectMocks
    private DefaultVehicleResourcesService vehicleResourcesService;

    @Mock
    private VehicleResourcesRepository vehicleResourcesRepository;
    @Mock
    private ComparatorService comparatorService;

    @Test
    public void whenGetVehiclesThenReturnsVehicleList() {
        List<Vehicle> vehicles = buildVehicles();

        when(vehicleResourcesRepository.getVehicles()).thenReturn(vehicles);
        when(comparatorService.compareVehicleLists(anyList(), anyList())).thenReturn(vehicles);

        List<Vehicle> result = vehicleResourcesService.getVehicles();

        assertThat(result.size(), is(1));
        assertThat(result.get(0).getId(), is("DriveNow_13673269"));
        assertThat(result.get(0).getName(), is("M-DX7749"));
        assertThat(result.get(0).getX(), is(-9.1627));
        assertThat(result.get(0).getY(), is(38.7582));
        assertThat(result.get(0).getLicencePlate(), is("M-DX7749"));
        assertThat(result.get(0).getRange(), is(0));
        assertThat(result.get(0).getBatteryLevel(), is(50));
        assertThat(result.get(0).getSeats(), is(4));
        assertThat(result.get(0).getModel(), is("BMW X1"));
        assertThat(result.get(0).getResourceImageId(), is("vehicle_gen_dn"));
        assertThat(result.get(0).getPricePerMinuteDriving(), is(15.0));
        assertThat(result.get(0).getPricePerMinuteParking(), is(29.0));
        assertThat(result.get(0).isRealTimeData(), is(true));
        assertThat(result.get(0).getEngineType(), is("DIESEL"));
        assertThat(result.get(0).getResourceType(), is("CAR"));
        assertThat(result.get(0).getCompanyZoneId(), is(545));
    }

    private List<Vehicle> buildVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle = Vehicle.builder()
                .id("DriveNow_13673269")
                .name("M-DX7749")
                .x(-9.1627)
                .y(38.7582)
                .licencePlate("M-DX7749")
                .range(0)
                .batteryLevel(50)
                .seats(4)
                .model("BMW X1")
                .resourceImageId("vehicle_gen_dn")
                .pricePerMinuteDriving(15.0)
                .pricePerMinuteParking(29.0)
                .realTimeData(true)
                .engineType("DIESEL")
                .resourceType("CAR")
                .companyZoneId(545)
                .build();

        vehicles.add(vehicle);

        return vehicles;
    }

}