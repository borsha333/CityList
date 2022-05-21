package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }
    @Test
    /**
     * testing delete
     */
    public void testdelete()
    {
        CityList cityList=new CityList();
        City city=new City("Jessore", "Khulna");
        City city1=new City("Thakurgaon", "Rangpur");
        cityList.add(city);
        cityList.add(city1);
        cityList.delete(city);
        assertTrue(!cityList.getCities(1).contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    public void testDeleteExcepton(){
        CityList cityList=new CityList();
        City city=new City("Jessore", "Khulna");
        City city1=new City("Thakurgaon", "Rangpur");
        cityList.add(city);
        cityList.add(city1);
        assertEquals(2,cityList.count());
        cityList.delete(city);
        assertEquals(1,cityList.count());
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });

    }

    @Test
    public void testGetCities() {
        CityList cityList = new CityList();
        City city1=new City("ZZZ","CD");
        cityList.add(city1);
        assertEquals(0, city1.compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(2).get(1)));
        assertEquals(0, city1.compareTo(cityList.getCities(2).get(0)));
    }
}
