package com.smhrd.team.yh;

import java.util.ArrayList;

public class Interesting {
    private static ArrayList<Interesting> interestingArrayList;

    private int id;
    private String name;

    public Interesting(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static  void initInterestings(){

        interestingArrayList = new ArrayList<>();

        Interesting select = new Interesting(0,"선택");
        interestingArrayList.add(select);

        Interesting education = new Interesting(0,"교육");
        interestingArrayList.add(education);

        Interesting hire = new Interesting(0,"고용");
        interestingArrayList.add(hire);

        Interesting residential = new Interesting(0,"주거");
        interestingArrayList.add(residential);

        Interesting health = new Interesting(0,"건강");
        interestingArrayList.add(health);

        Interesting culture = new Interesting(0,"문화");
        interestingArrayList.add(culture);

        Interesting finance = new Interesting(0,"서민금융");
        interestingArrayList.add(finance);

    }

    public static  ArrayList<Interesting> getLanguageArrayList(){
        return interestingArrayList;
    }

    public static String[] languageNames(){
        String[] names = new String[interestingArrayList.size()];
        for(int i = 0; i< interestingArrayList.size(); i++){
            names[i] = interestingArrayList.get(i).name;
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
