package com.smhrd.team.yh;

public class CommunityDTO {

    private String users_id;
    private String community_date;
    private String community_content;
    private String community_policy;

    public String getUsers_id() {
        return users_id;
    }

    public void setUsers_id(String users_id) {
        this.users_id = users_id;
    }

    public String getCommunity_date() {
        return community_date;
    }

    public void setCommunity_date(String community_date) {
        this.community_date = community_date;
    }

    public String getCommunity_content() {
        return community_content;
    }

    public void setCommunity_content(String community_content) {
        this.community_content = community_content;
    }

    public CommunityDTO(String users_id, String community_date, String community_content) {
        this.users_id = users_id;
        this.community_date = community_date;
        this.community_content = community_content;
    }
}
