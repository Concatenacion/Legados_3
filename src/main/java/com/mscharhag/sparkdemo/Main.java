package com.mscharhag.sparkdemo;

import com.google.api.vision.googleApi;

import java.io.File;

import static spark.SparkBase.setIpAddress;
import static spark.SparkBase.setPort;
import static spark.SparkBase.staticFileLocation;

public class Main {
    private static final String IP_ADDRESS = System.getenv("OPENSHIFT_DIY_IP") != null ? System.getenv("OPENSHIFT_DIY_IP") : "localhost";
    private static final int PORT = System.getenv("OPENSHIFT_DIY_IP") != null ? Integer.parseInt(System.getenv("OPENSHIFT_DIY_IP")) : 8080;

    public static void main(String[] args) {

        setIpAddress(IP_ADDRESS);
        setPort(PORT);
        staticFileLocation("/public");

        //googleApi.sendGoogle(new File("C:\\Users\\pfort\\Desktop\\Legados_3\\src\\main\\resources\\public\\cartel.jpg"));

		new gameController(new gameService());
	}
}
