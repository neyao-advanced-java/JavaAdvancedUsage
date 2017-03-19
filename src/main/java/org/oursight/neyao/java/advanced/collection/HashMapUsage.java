package org.oursight.neyao.java.advanced.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapUsage {

    public static void main(String[] args) {
        Country india = new Country("India", 1000);
        Country japan = new Country("Japan", 10000);

        Country france = new Country("France", 2000);
        Country russia = new Country("Russia", 20000);

        HashMap<Country, String> countryCapitalMap = new HashMap<Country, String>();
        countryCapitalMap.put(india, "Delhi");
        countryCapitalMap.put(japan, "Tokyo");
        countryCapitalMap.put(france, "Paris");
        countryCapitalMap.put(russia, "Moscow");

        Iterator<Country> countryCapitalIter = countryCapitalMap.keySet().iterator();//put debug point at this line
        while (countryCapitalIter.hasNext()) {
            Country countryObj = countryCapitalIter.next();
            String capital = countryCapitalMap.get(countryObj);
            System.out.println(countryObj.getName() + "----" + capital);
        }
    }
}

class Country {

    String name;
    long population;

    public Country(String name, long population) {
        super();
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    // If length of name in country object is even then return 31(any random number) and if odd then return 95(any random number).
    // This is not a good practice to generate hashcode as below method but I am doing so to give better and easy understanding of hashmap.
    @Override
    public int hashCode() {
        if (this.name.length() % 2 == 0)
            return 31;
        else
            return 95;
    }

    @Override
    public boolean equals(Object obj) {

        Country other = (Country) obj;
        if (name.equalsIgnoreCase((other.name)))
            return true;
        return false;
    }

}