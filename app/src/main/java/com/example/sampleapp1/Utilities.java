package com.example.sampleapp1;

public class Utilities {

    public static String createFlickrImageUrl(String farm, String serverid, String photoid, String secretid) {

        //http://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg

        StringBuilder sb = new StringBuilder();

        sb.append("http://farm");
        sb.append(farm);
        sb.append(".staticflickr.com/");
        sb.append(serverid).append("/");
        sb.append(photoid).append("_");
        sb.append(secretid);
        sb.append(".jpg");

        return sb.toString();

    }
}
