package com.meep.vehicles.service.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Vehicle {
    private String id;
    private String name;
    private double x;
    private double y;
    private String licencePlate;
    private int range;
    private int batteryLevel;
    private int seats;
    private String model;
    private String resourceImageId;
    private double pricePerMinuteParking;
    private double pricePerMinuteDriving;
    private boolean realTimeData;
    private String engineType;
    private String resourceType;
    private int companyZoneId;
}
