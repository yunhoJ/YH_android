package com.smhrd.team.yh;

import android.util.Log;

import java.util.ArrayList;

public class LocationGu {

    private static ArrayList<LocationGu> locationGuArrayList;

    private int id;
    private String name;

    public LocationGu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void initLocationGus() {

        ArrayList<LocationCity> locationCityArrayList = LocationCity.getLocationCityArrayList();

        locationGuArrayList = new ArrayList<>();

        LocationGu gangnam = new LocationGu(0, "강남구");
        locationGuArrayList.add(gangnam);

        LocationGu gangbuk = new LocationGu(0, "강북구");
        locationGuArrayList.add(gangbuk);

        /*LocationGu gwangsan = new LocationGu(1, "광산구");
        locationGuArrayList.add(gwangsan);

        LocationGu donggu = new LocationGu(1, "동구");
        locationGuArrayList.add(donggu);*/
    }

    public static void sou(){
        ArrayList<LocationCity> locationCityArrayList = LocationCity.getLocationCityArrayList();

        locationGuArrayList = new ArrayList<>();
        LocationGu gangnam = new LocationGu(0, "강남구");
        if(gangnam.name.equals("강남구")){
            gangnam.id = 1;
        }
        locationGuArrayList.add(gangnam);

        LocationGu gangdong = new LocationGu(0, "강동구");
        locationGuArrayList.add(gangdong);

        LocationGu gangbuk = new LocationGu(0, "강북구");
        locationGuArrayList.add(gangbuk);

        LocationGu gangseo = new LocationGu(0, "강서구");
        locationGuArrayList.add(gangseo);

        LocationGu gwanak = new LocationGu(0, "관악구");
        locationGuArrayList.add(gwanak);

        LocationGu gwangjin = new LocationGu(0, "광진구");
        locationGuArrayList.add(gwangjin);

        LocationGu guro = new LocationGu(0, "구로구");
        locationGuArrayList.add(guro);

        LocationGu geomcheon = new LocationGu(0, "금천구");
        locationGuArrayList.add(geomcheon);

        LocationGu nowon = new LocationGu(0, "노원구");
        locationGuArrayList.add(nowon);

        LocationGu dobong = new LocationGu(0, "도봉구");
        locationGuArrayList.add(dobong);

        LocationGu dongdaemoon = new LocationGu(0, "동대문구");
        locationGuArrayList.add(dongdaemoon);

        LocationGu dongjak = new LocationGu(0, "동작구");
        locationGuArrayList.add(dongjak);

        LocationGu mapo = new LocationGu(0, "마포구");
        locationGuArrayList.add(mapo);

        LocationGu seoulbonchung = new LocationGu(0, "본청");
        locationGuArrayList.add(seoulbonchung);

        LocationGu seodaemoon = new LocationGu(0, "서대문구");
        locationGuArrayList.add(seodaemoon);

        LocationGu seocho = new LocationGu(0, "서초구");
        locationGuArrayList.add(seocho);

        LocationGu sungdong = new LocationGu(0, "성동구");
        locationGuArrayList.add(sungdong);

        LocationGu sungbuk = new LocationGu(0, "성북구");
        locationGuArrayList.add(sungbuk);

        LocationGu songpa = new LocationGu(0, "송파구");
        locationGuArrayList.add(songpa);

        LocationGu yangcheon = new LocationGu(0, "양천구");
        locationGuArrayList.add(yangcheon);

        LocationGu yungdeongpo = new LocationGu(0, "영등포구");
        locationGuArrayList.add(yungdeongpo);

        LocationGu yongsan = new LocationGu(0, "용산구");
        locationGuArrayList.add(yongsan);

        LocationGu eanpyung = new LocationGu(0, "은평구");
        locationGuArrayList.add(eanpyung);

        LocationGu jongro = new LocationGu(0, "종로구");
        locationGuArrayList.add(jongro);

        LocationGu joonggu = new LocationGu(0, "중구");
        locationGuArrayList.add(joonggu);

        LocationGu joongranggu = new LocationGu(0, "중랑구");
        locationGuArrayList.add(joongranggu);

    }
    public static void gw(){
        ArrayList<LocationCity> locationCityArrayList = LocationCity.getLocationCityArrayList();

        locationGuArrayList = new ArrayList<>();
        LocationGu gwangsan = new LocationGu(1, "광산구");
        locationGuArrayList.add(gwangsan);

        LocationGu nam = new LocationGu(1, "남구");
        locationGuArrayList.add(nam);

        LocationGu dong = new LocationGu(1, "동구");
        locationGuArrayList.add(dong);

        LocationGu gwangjubon = new LocationGu(1, "본청");
        locationGuArrayList.add(gwangjubon);

        LocationGu buk = new LocationGu(1, "북구");
        locationGuArrayList.add(buk);

        LocationGu seo = new LocationGu(1, "서구");
        locationGuArrayList.add(seo);
    }





    public static ArrayList<LocationGu> getLocationGuArrayList() {
        return locationGuArrayList;
    }

    public static String[] locationguNames() {
        String[] names = new String[locationGuArrayList.size()];
        String[] names2 = new String[LocationCity.getLocationCityArrayList().size()];
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
