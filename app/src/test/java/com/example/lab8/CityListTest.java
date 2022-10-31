package com.example.lab8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows( IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }


    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        City city2 = new City("Edmonton", "AB");
        assertFalse(cityList.hasCity(city2));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(true, cityList.hasCity(city));
        cityList.delete(city);
        assertEquals(false, cityList.hasCity(city));
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(2, cityList.countCities());
    }
}
