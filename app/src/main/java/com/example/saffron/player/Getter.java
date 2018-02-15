package com.example.saffron.player;

/**
 * Created by saffron on 2/15/2018.
 */

public class Getter {

    private static String header;
    private static String banner;

    public Getter(String header,String banner) {
        this.header=header;
        this.banner=banner;
    }

    public static String getHeader() {
        return header;
    }



    public static String getBanner() {
        return banner;
    }





}
