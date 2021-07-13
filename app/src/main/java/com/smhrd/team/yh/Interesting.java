package com.smhrd.team.yh;

import java.util.ArrayList;

public class Interesting {
    private static ArrayList<Interesting> interestingArrayList;
    private static ArrayList<Interesting> itrArrayList;
    private int id;
    private String name;

    public Interesting(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static  void initInterestings(){ // interestingArrayList에 id, name 초기화 해서 넣기

        interestingArrayList = new ArrayList<>();

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

//    public static String getInteresting(String area, int selectIndex){
//
//        String itr = null;
//
//        if(area.equals("서울")){
//            itr = interestingArrayList.get(selectIndex).getName();
//        }else if(area.equals("광주")){
//            itr = interestingArrayList.get(selectIndex).getName();
//        }
//        return itr;
//    }


//    public static void itr(){
//        ArrayList<Interesting> itrArraylist = Interesting.getInterestingArrayList();
//        interestingArrayList = new ArrayList<>();
//
//        String itr[] = {"교육","고용","주거","건강","문화","서민금융"};
//        for(int i = 0; i < itr.length; i++){
//        Interesting t = new Interesting(i,itr[i]);
//        interestingArrayList.add(t);
//        }
//    }

    public static  ArrayList<Interesting> getInterestingArrayList(){
        return interestingArrayList;
    }

    public static String[] interestingNames(){
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
