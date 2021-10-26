package com.sapient.Airport_Application.functions;

import com.sapient.Airport_Application.domain.*;

public class TransformerFunctions {

    /**
     * Private method to restrict object invocation....
     */
    private TransformerFunctions() {
    }

    /**
     * @param airport
     * @return Airport
     */
    public static Airport stringToAirport(String airport) {
        if (airport == null)
            throw new IllegalArgumentException();
        var datas = airport.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        var airportObject = new Airport();
        if (datas != null && datas.length > 0) {
            airportObject.setId(Long.parseLong(datas[0].replace("\"", "")));
            airportObject.setIdent(datas[1].replace("\"", ""));
            airportObject.setType(datas[2].replace("\"", ""));
            airportObject.setName(datas[3].replace("\"", ""));
            airportObject.setLatitude(Double.parseDouble(datas[4].replace("\"", "")));
            airportObject.setLongitude(Double.parseDouble(datas[5].replace("\"", "")));
            airportObject.setElevation(Long.parseLong(datas[6].equals("") ? String.valueOf(datas[6].length()) :datas[6].replace("\"", "")));
            airportObject.setCountryName(datas[8].replace("\"", ""));
            airportObject.setRegionName(datas[9].replace("\"", ""));
            airportObject.setMunicipality(datas[10].replace("\"", ""));
        }
        return airportObject;
    }

    /**
     * @param country
     * @return Country
     */
    public static Country stringToCountry(String country) {
        if (country == null)
            throw new IllegalArgumentException();
        String[] datas = country.split(",");
        var countryObject = new Country();
        if (datas != null && datas.length > 0) {
            countryObject.setId(Long.parseLong(datas[0].replace("\"", "")));
            countryObject.setCode(datas[1].replace("\"", ""));
            countryObject.setName(datas[2].replace("\"", ""));
            countryObject.setContinent(datas[3].replace("\"", ""));
        }
        return countryObject;
    }

    /**
     * @param region
     * @return Region
     */
    public static Region stringToRegion(String region) {
        if (region == null)
            throw new IllegalArgumentException();
        String[] datas = region.split(",");
        var regionObject = new Region();
        if (datas != null && datas.length > 0) {
            regionObject.setId(Long.parseLong(datas[0].replace("\"", "")));
            regionObject.setCode(datas[1].replace("\"", ""));
            regionObject.setName(datas[3].replace("\"", ""));
            regionObject.setContinent(datas[4].replace("\"", ""));
            regionObject.setIsoCountry(datas[5].replace("\"", ""));
        }
        return regionObject;
    }


    /**
     * @param navaid
     * @return NavAid
     */
    public static NavAid stringToNavaid(String navaid) {
        if (navaid == null)
            throw new IllegalArgumentException();
        String[] datas = navaid.split(",");
        var navaidObject = new NavAid();
        if (datas != null && datas.length > 0) {
            navaidObject.setId(Long.parseLong(datas[0].replace("\"", "")));
            navaidObject.setName(datas[3].replace("\"", ""));
            navaidObject.setLatitude(Double.parseDouble(datas[6]));
            navaidObject.setLongitude(Double.parseDouble(datas[7]));
        }
        return navaidObject;
    }

    /**
     * @param runway
     * @return Runway
     */
    public static Runway stringToRunway(String runway) {
        if (runway == null)
            throw new IllegalArgumentException();
        String[] datas = runway.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        var runwayObject = new Runway();
        if (datas != null && datas.length > 0) {
            runwayObject.setId(Long.parseLong(datas[0].replace("\"", "")));
            runwayObject.setAirport_ref(Long.parseLong(datas[1].replace("\"", "")));
            runwayObject.setAirport_ident(datas[2].equals("")?"":datas[2].replace("\"", ""));
            runwayObject.setLength_ft(Long.parseLong(datas[3].equals("") ? String.valueOf(0) :datas[3].replace("\"", "")));
            runwayObject.setWidth_ft(Long.parseLong(datas[4].equals("") ? String.valueOf(0) :datas[4].replace("\"", "")));
            runwayObject.setLighted(Integer.parseInt(datas[6].equals("") ? String.valueOf(0) :datas[6].replace("\"", "")));
            runwayObject.setClosed(Integer.parseInt(datas[7].equals("") ? String.valueOf(0) :datas[7].replace("\"", "")));
        }
        return runwayObject;
    }

    /**
     * @param airportFrequency
     * @return AirportFrequency
     */
    public static AirportFrequency stringToAirportFrequency(String airportFrequency) {
        if (airportFrequency == null)
            throw new IllegalArgumentException();
        String[] datas = airportFrequency.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        var airportFrequencyObject = new AirportFrequency();
        if (datas != null && datas.length > 0) {
            airportFrequencyObject.setId(Long.parseLong(datas[0].replace("\"", "")));
            airportFrequencyObject.setAirport_ref(Long.parseLong(datas[1].replace("\"", "")));
            airportFrequencyObject.setAirport_ident(datas[2].equals("")?"":datas[2].replace("\"", ""));
            airportFrequencyObject.setType(datas[3].equals("") ? String.valueOf(0) :datas[3].replace("\"", ""));
            airportFrequencyObject.setDescription(datas[4].equals("") ? String.valueOf(0) :datas[4].replace("\"", ""));
            airportFrequencyObject.setFrequency(Double.parseDouble(datas[5].equals("") ? String.valueOf(0) :datas[5].replace("\"", "")));
        }
        return airportFrequencyObject;
    }

}

