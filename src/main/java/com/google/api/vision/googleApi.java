package com.google.api.vision;

import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class googleApi {

    private static final String TARGET_URL =
            "https://vision.googleapis.com/v1/images:annotate?";
    private static final String API_KEY =
            "key=AIzaSyBDPdnnI-3Xbn9lAy6opQKZvCPyq_nF-o8";


    public static void sendGoogle (File file){
        try {
            URL serverUrl = new URL(TARGET_URL + API_KEY);
            URLConnection urlConnection = serverUrl.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection)urlConnection;

            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json");

            httpConnection.setDoOutput(true);

            BufferedWriter httpRequestBodyWriter = new BufferedWriter(new
                    OutputStreamWriter(httpConnection.getOutputStream()));

            String img_base64 = encodeFileToBase64Binary(file);

            httpRequestBodyWriter.write
                    ("{\"requests\":  " +
                            "[{ \"features\":  " +
                                "[ {\"type\": \"TEXT_DETECTION\""+"}]," +
                            " \"image\": {" +
                                "\"content\":" + " \"" + img_base64 + "\"}}]}");
            httpRequestBodyWriter.close();

            String response = httpConnection.getResponseMessage();

            if (httpConnection.getInputStream() == null) {
                System.out.println("No stream");
            }

            Scanner httpResponseScanner = new Scanner (httpConnection.getInputStream());
            String resp = "";
            while (httpResponseScanner.hasNext()) {
                String line = httpResponseScanner.nextLine();
                resp += line;
                System.out.println(line);  //  alternatively, print the line of response
            }
            httpResponseScanner.close();

        } catch (Exception e) { System.out.println(e);}

    }

    private static String encodeFileToBase64Binary(File file){
        String encodedfile = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(encodedfile);
        return encodedfile;
    }


}
