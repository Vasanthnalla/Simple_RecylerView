package com.an.trailers.utils;

public class Singleton {
    String kartresume;
    private static final Singleton ourInstance = new Singleton();
    public static Singleton getInstance() {
        return ourInstance;
    }
    private Singleton() { }
    public void setKartresume(String kartresume) {
        this.kartresume = kartresume;
    }
    public String getKartresume() {
        return kartresume;
    }

}
