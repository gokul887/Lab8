package com.example.lab8;

/**
 * This class defines a city. It defines a city {@link String } and a province {@link String }
 */
public class City implements Comparable{
    private String city;
    private String province;

    /**
     * @param city - stores city name
     * @param province - stores province name
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * @return
     * returns city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * @return
     * returns province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * @param o - object to compare {@link Object}
     * @return
     * returns comparison with object o
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
}