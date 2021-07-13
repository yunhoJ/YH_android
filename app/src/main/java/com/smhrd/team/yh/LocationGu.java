package com.smhrd.team.yh;

import android.util.Log;

import java.util.ArrayList;

public class LocationGu {

    private static ArrayList<LocationGu> locationGuArrayList;

    private int id;
    private String name;
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public LocationGu(int id, String name, int num) {
        this.id = id;
        this.name = name;
        this.num=num;

    }

    public static void initLocationGus() {

        ArrayList<LocationCity> locationCityArrayList = LocationCity.getLocationCityArrayList();

        locationGuArrayList = new ArrayList<>();

        LocationGu gangnam = new LocationGu(0, "강남구",1);
        locationGuArrayList.add(gangnam);

        LocationGu gangbuk = new LocationGu(0, "강북구",2);
        locationGuArrayList.add(gangbuk);

        /*LocationGu gwangsan = new LocationGu(1, "광산구");
        locationGuArrayList.add(gwangsan);

        LocationGu donggu = new LocationGu(1, "동구");
        locationGuArrayList.add(donggu);*/
    }

    public static void sou(){
        ArrayList<LocationCity> locationCityArrayList = LocationCity.getLocationCityArrayList();

        locationGuArrayList = new ArrayList<>();
        LocationGu gangnam = new LocationGu(0, "강남구",1);
        if(gangnam.name.equals("강남구")){
            gangnam.id = 1;
        }
        locationGuArrayList.add(gangnam);

        LocationGu gangdong = new LocationGu(0, "강동구",2);
        locationGuArrayList.add(gangdong);

        LocationGu gangbuk = new LocationGu(0, "강북구",3);
        locationGuArrayList.add(gangbuk);

        LocationGu gangseo = new LocationGu(0, "강서구",4);
        locationGuArrayList.add(gangseo);

        LocationGu gwanak = new LocationGu(0, "관악구",5);
        locationGuArrayList.add(gwanak);

        LocationGu gwangjin = new LocationGu(0, "광진구",6);
        locationGuArrayList.add(gwangjin);

        LocationGu guro = new LocationGu(0, "구로구",7);
        locationGuArrayList.add(guro);

        LocationGu geomcheon = new LocationGu(0, "금천구",8);
        locationGuArrayList.add(geomcheon);

        LocationGu nowon = new LocationGu(0, "노원구",9);
        locationGuArrayList.add(nowon);

        LocationGu dobong = new LocationGu(0, "도봉구",10);
        locationGuArrayList.add(dobong);

        LocationGu dongdaemoon = new LocationGu(0, "동대문구",11);
        locationGuArrayList.add(dongdaemoon);

        LocationGu dongjak = new LocationGu(0, "동작구",12);
        locationGuArrayList.add(dongjak);

        LocationGu mapo = new LocationGu(0, "마포구",13);
        locationGuArrayList.add(mapo);

        LocationGu seoulbonchung = new LocationGu(0, "본청",14);
        locationGuArrayList.add(seoulbonchung);

        LocationGu seodaemoon = new LocationGu(0, "서대문구",15);
        locationGuArrayList.add(seodaemoon);

        LocationGu seocho = new LocationGu(0, "서초구",16);
        locationGuArrayList.add(seocho);

        LocationGu sungdong = new LocationGu(0, "성동구",17);
        locationGuArrayList.add(sungdong);

        LocationGu sungbuk = new LocationGu(0, "성북구",18);
        locationGuArrayList.add(sungbuk);

        LocationGu songpa = new LocationGu(0, "송파구",19);
        locationGuArrayList.add(songpa);

        LocationGu yangcheon = new LocationGu(0, "양천구",20);
        locationGuArrayList.add(yangcheon);

        LocationGu yungdeongpo = new LocationGu(0, "영등포구",21);
        locationGuArrayList.add(yungdeongpo);

        LocationGu yongsan = new LocationGu(0, "용산구",22);
        locationGuArrayList.add(yongsan);

        LocationGu eanpyung = new LocationGu(0, "은평구",23);
        locationGuArrayList.add(eanpyung);

        LocationGu jongro = new LocationGu(0, "종로구",24);
        locationGuArrayList.add(jongro);

        LocationGu joonggu = new LocationGu(0, "중구",25);
        locationGuArrayList.add(joonggu);

        LocationGu joongranggu = new LocationGu(0, "중랑구",26);
        locationGuArrayList.add(joongranggu);

    }
    public static void gw(){
        ArrayList<LocationCity> locationCityArrayList = LocationCity.getLocationCityArrayList();

        locationGuArrayList = new ArrayList<>();
        LocationGu gwangsan = new LocationGu(1, "광산구",27);
        locationGuArrayList.add(gwangsan);

        LocationGu nam = new LocationGu(1, "남구",28);
        locationGuArrayList.add(nam);

        LocationGu dong = new LocationGu(1, "동구",29);
        locationGuArrayList.add(dong);

        LocationGu gwangjubon = new LocationGu(1, "본청",30);
        locationGuArrayList.add(gwangjubon);

        LocationGu buk = new LocationGu(1, "북구",31);
        locationGuArrayList.add(buk);

        LocationGu seo = new LocationGu(1, "서구",32);
        locationGuArrayList.add(seo);

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
