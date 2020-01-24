package com.example.DailyReport.domain;

public class Companies {

    private Integer id;

    private String name;

    private String kana;

    private String remarks;

    private Integer adminsId;

    public Companies(Integer id, String name, String kana, String remarks, Integer adminsId) {
        this.id = id;
        this.name = name;
        this.kana = kana;
        this.remarks = remarks;
        this.adminsId = adminsId;
    }

    public Companies() {
    }

    @Override
    public String toString() {
        return "Companies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kana='" + kana + '\'' +
                ", remarks='" + remarks + '\'' +
                ", adminsId=" + adminsId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKana() {
        return kana;
    }

    public void setKana(String kana) {
        this.kana = kana;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getAdminsId() {
        return adminsId;
    }

    public void setAdminsId(Integer adminsId) {
        this.adminsId = adminsId;
    }
}
