package com.smhrd.team.yh;

import java.util.ArrayList;

public class LocationCity {

    private static ArrayList<LocationCity> locationCityArrayList;

    private int id;
    private String name;

    public LocationCity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void initLocationCitys(){ // interestingArrayList에 id, name 초기화 해서 넣기

        locationCityArrayList = new ArrayList<>();

        LocationCity si = new LocationCity(0,"시");
        locationCityArrayList.add(si);

        LocationCity seoul = new LocationCity(1,"서울");
        locationCityArrayList.add(seoul);

        LocationCity gwangju = new LocationCity(2,"광주");
        locationCityArrayList.add(gwangju);




    }


    public static ArrayList<LocationCity> getLocationCityArrayList() {
        return locationCityArrayList;
    }

    public static String[] locationcityNames(){
        String[] names = new String[locationCityArrayList.size()];
        for(int i = 0; i< locationCityArrayList.size(); i++){
            names[i] = locationCityArrayList.get(i).name;
        }
        return names;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
