package com.smhrd.team.yh;

import java.util.ArrayList;

public class LocationGu {

    private static ArrayList<LocationGu> locationGuArrayList;

    private int id;
    private String name;

    public LocationGu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void initLocationGus(){



        locationGuArrayList = new ArrayList<>();

            LocationGu gangnam = new LocationGu(0, "강남구");
            locationGuArrayList.add(gangnam);

            LocationGu gangbuk = new LocationGu(0, "강북구");
            locationGuArrayList.add(gangbuk);

            LocationGu gwangsan = new LocationGu(1,"광산구");
            locationGuArrayList.add(gwangsan);

            LocationGu donggu = new LocationGu(1,"동구");
            locationGuArrayList.add(donggu);

    }

    public static ArrayList<LocationGu> getLocationGuArrayList() {
        return locationGuArrayList;
    }

    public static String[] locationguNames(){
        String[] names = new String[locationGuArrayList.size()];
        for(int i = 0; i< locationGuArrayList.size(); i++){
            names[i] = locationGuArrayList.get(i).name;
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
