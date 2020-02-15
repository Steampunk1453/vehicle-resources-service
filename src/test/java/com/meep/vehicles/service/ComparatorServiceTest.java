package com.meep.vehicles.service;

import com.meep.vehicles.service.dto.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ComparatorServiceTest {

    @InjectMocks
    private DefaultComparatorService comparatorService;

    @Test
    public void givenTwoListsThenReturnsListWithRemoveElements() {
        List<Vehicle> vehicles1 = buildVehiclesWithTwoElements();
        List<Vehicle> vehicles2 = buildVehicles2WithOneElement();

        List<Vehicle> result = comparatorService.compareVehicleLists(vehicles1, vehicles2);

        assertThat(result.size(), is(1));
        assertThat(result.get(0).getId(), is("DriveNow_12708820"));
        assertThat(result.get(0).getName(), is("M-DX8437"));
        assertThat(result.get(0).getX(), is(-9.1873));
        assertThat(result.get(0).getY(), is(38.7392));
        assertThat(result.get(0).getLicencePlate(), is("M-DX8437"));
        assertThat(result.get(0).getRange(), is(0));
        assertThat(result.get(0).getBatteryLevel(), is(50));
        assertThat(result.get(0).getSeats(), is(4));
        assertThat(result.get(0).getModel(), is("MINI"));
        assertThat(result.get(0).getResourceImageId(), is("vehicle_gen_dn"));
        assertThat(result.get(0).getPricePerMinuteDriving(), is(15.0));
        assertThat(result.get(0).getPricePerMinuteParking(), is(29.0));
        assertThat(result.get(0).isRealTimeData(), is(true));
        assertThat(result.get(0).getEngineType(), is("DIESEL"));
        assertThat(result.get(0).getResourceType(), is("CAR"));
        assertThat(result.get(0).getCompanyZoneId(), is(545));
    }

    @Test
    public void givenTwoListsThenReturnsListWithAddedElements() {
        List<Vehicle> vehicles1 = buildVehicles1WithOneElement();
        List<Vehicle> vehicles2 = buildVehicles2WitTwoElements();

        List<Vehicle> result = comparatorService.compareVehicleLists(vehicles1, vehicles2);

        assertThat(result.size(), is(1));
        assertThat(result.get(0).getId(), is("DriveNow_13665647"));
        assertThat(result.get(0).getName(), is("M-DX7761"));
        assertThat(result.get(0).getX(), is(-9.1419));
        assertThat(result.get(0).getY(), is(38.7542));
        assertThat(result.get(0).getLicencePlate(), is("M-DX7761"));
        assertThat(result.get(0).getRange(), is(0));
        assertThat(result.get(0).getBatteryLevel(), is(50));
        assertThat(result.get(0).getSeats(), is(4));
        assertThat(result.get(0).getModel(), is("MINI 5-Door"));
        assertThat(result.get(0).getResourceImageId(), is("vehicle_gen_dn_mini_5_door"));
        assertThat(result.get(0).getPricePerMinuteDriving(), is(15.0));
        assertThat(result.get(0).getPricePerMinuteParking(), is(29.0));
        assertThat(result.get(0).isRealTimeData(), is(true));
        assertThat(result.get(0).getEngineType(), is("DIESEL"));
        assertThat(result.get(0).getResourceType(), is("CAR"));
        assertThat(result.get(0).getCompanyZoneId(), is(545));
    }

    @Test
    public void givenTwoListsThenReturnsListWithSameElements() {
        List<Vehicle> vehicles1 = buildVehiclesWithTwoElements();
        List<Vehicle> vehicles2 = buildVehiclesWithTwoElements();

        List<Vehicle> result = comparatorService.compareVehicleLists(vehicles1, vehicles2);

        assertThat(result.size(), is(2));
        assertThat(result.get(0).getId(), is("DriveNow_13673269"));
        assertThat(result.get(1).getId(), is("DriveNow_12708820"));
    }

    private List<Vehicle> buildVehiclesWithTwoElements() {
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = Vehicle.builder()
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

        Vehicle vehicle2 = Vehicle.builder()
                .id("DriveNow_12708820")
                .name("M-DX8437")
                .x(-9.1873)
                .y(38.7392)
                .licencePlate("M-DX8437")
                .range(0)
                .batteryLevel(50)
                .seats(4)
                .model("MINI")
                .resourceImageId("vehicle_gen_dn")
                .pricePerMinuteDriving(15.0)
                .pricePerMinuteParking(29.0)
                .realTimeData(true)
                .engineType("DIESEL")
                .resourceType("CAR")
                .companyZoneId(545)
                .build();


        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }

    private List<Vehicle> buildVehicles1WithOneElement() {
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

    private List<Vehicle> buildVehicles2WithOneElement() {
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

    private List<Vehicle> buildVehicles2WitTwoElements() {
        List<Vehicle> vehicles = new ArrayList<>();


        Vehicle vehicle1 = Vehicle.builder()
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

        Vehicle vehicle2 = Vehicle.builder()
                .id("DriveNow_13665647")
                .name("M-DX7761")
                .x(-9.1419)
                .y(38.7542)
                .licencePlate("M-DX7761")
                .range(0)
                .batteryLevel(50)
                .seats(4)
                .model("MINI 5-Door")
                .resourceImageId("vehicle_gen_dn_mini_5_door")
                .pricePerMinuteDriving(15.0)
                .pricePerMinuteParking(29.0)
                .realTimeData(true)
                .engineType("DIESEL")
                .resourceType("CAR")
                .companyZoneId(545)
                .build();

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }

}