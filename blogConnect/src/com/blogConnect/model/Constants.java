package com.blogConnect.model;

public class Constants {
    /*
      Logging flag
     */
    public static final boolean LOGGING = false;

    /*
      Your imgur client id. You need this to upload to imgur.
      More here: https://api.imgur.com/
     */
    public static final String MY_IMGUR_CLIENT_ID = "f188f8f55443e00";
    public static final String MY_IMGUR_CLIENT_SECRET = "5bb72ff3a4b3aa8a814bc2cb29779ca7c99fabfd";
   
    /*
      Redirect URL for android.
     */
    public static final String MY_IMGUR_REDIRECT_URL = "http://android";

    /*
      Client Auth
     */
    public static String getClientAuth() {
        return "Client-ID " + MY_IMGUR_CLIENT_ID;
    }

}