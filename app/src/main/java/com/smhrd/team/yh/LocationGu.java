package com.smhrd.team.yh;

import android.util.Log;

import java.util.ArrayList;

public class LocationGu {

    private static ArrayList<LocationGu> locationGuArrayList;
    private static ArrayList<LocationGu> locationSouArrayList;
    private static ArrayList<LocationGu> locationGwArrayList;

    private int id;
    private String name;


    public LocationGu(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public static void initLocationGus() {

        ArrayList<LocationCity> locationCityArrayList = LocationCity.getLocationCityArrayList();

        locationGuArrayList = new ArrayList<>();

        LocationGu gangnam = new LocationGu(0, "구");
        locationGuArrayList.add(gangnam);

        LocationGu gangbuk = new LocationGu(0, "");
        locationGuArrayList.add(gangbuk);


    }

    public static String getLocationGu(String area, int selectIndex){

        String gu = null;

        if(area.equals("서울")){
            gu = locationGuArrayList.get(selectIndex).getName();
        }else if(area.equals("광주")){
            gu = locationGuArrayList.get(selectIndex).getName();
        }
        return gu;
    }


    public static void sou(){
        ArrayList<LocationCity> locationCityArrayList = LocationCity.getLocationCityArrayList();

        String[] sou = {"강남구", "강동구", "강북구","강서구","관악구","광진구","구로구","금천구","노원구","도봉구","동대문구","동작구","마포구",
                "본청","서대문구","서초구","성동구","성북구","송파구","양천구","영등포구","용산구","은평구","종로구","중구","중랑구"};

        locationGuArrayList = new ArrayList<>();

        for(int i=0; i<sou.length; i++) {
            LocationGu s = new LocationGu(i, sou[i]);
            locationGuArrayList.add(s);

        }
    }

    public static void gw(){
        ArrayList<LocationCity> locationCityArrayList = LocationCity.getLocationCityArrayList();

        locationGuArrayList = new ArrayList<>();

        String gw[] = {"광산구","남구","동구","본청","북구","서구"};

        for(int i=0; i<gw.length; i++) {
            LocationGu g = new LocationGu(i, gw[i]);
            locationGuArrayList.add(g);

        }

    }

    public static ArrayList<LocationGu> getLocationGuArrayList() {
        return locationGuArrayList;
    }

    public static String[] locationguNames() {
        String[] names = new String[locationGuArrayList.size()];
        for (int i = 0; i < locationGuArrayList.size(); i++) {
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
