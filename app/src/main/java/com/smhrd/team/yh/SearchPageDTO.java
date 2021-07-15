package com.smhrd.team.yh;

public class SearchPageDTO {


    private String search_gu, search_category;

    public SearchPageDTO(String search_gu, String search_category) {
        this.search_gu = search_gu;
        this.search_category = search_category;
    }

    public String getSearch_gu() {
        return search_gu;
    }

    public void setSearch_gu(String search_gu) {
        this.search_gu = search_gu;
    }

    public String getSearch_category() {
        return search_category;
    }

    public void setSearch_category(String search_category) {
        this.search_category = search_category;
    }
}
