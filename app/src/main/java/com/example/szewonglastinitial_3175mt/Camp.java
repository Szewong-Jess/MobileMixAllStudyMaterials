package com.example.szewonglastinitial_3175mt;

public class Camp {
    private String CampTime;
    private  int CampTimePics;
    private String CampName;
    private int CampImage;
    private int ThemeSong;
    private double CampBaseCost;

    public Camp(String campTime, int campTimePics) {
        CampTime = campTime;
        CampTimePics = campTimePics;
    }

    public Camp(String campName, int campImage, int themeSong, double campBaseCost) {
        CampName = campName;
        CampImage = campImage;
        ThemeSong = themeSong;
        CampBaseCost = campBaseCost;
    }

    public int getCampTimePics() {
        return CampTimePics;
    }

    public void setCampTimePics(int campTimePics) {
        CampTimePics = campTimePics;
    }

    public String getCampTime() {
        return CampTime;
    }

    public void setCampTime(String campTime) {
        CampTime = campTime;
    }

    public String getCampName() {
        return CampName;
    }

    public void setCampName(String campName) {
        CampName = campName;
    }

    public int getCampImage() {
        return CampImage;
    }

    public void setCampImage(int campImage) {
        CampImage = campImage;
    }

    public int getThemeSong() {
        return ThemeSong;
    }

    public void setThemeSong(int themeSong) {
        ThemeSong = themeSong;
    }

    public double getCampBaseCost() {
        return CampBaseCost;
    }

    public void setCampBaseCost(double campBaseCost) {
        CampBaseCost = campBaseCost;
    }
}
