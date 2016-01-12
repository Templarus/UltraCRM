package yandexPack;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RusTe
 */
public class YandexRequest {

    private byte[] incoming;
    private int length = 0;
    private InputStream in;
    private URLConnection conn;
    private OutputStreamWriter out;
    private double lat;
    private double lon;

    private int mcc;
    private int mnc;
    private int lac;
    private int cid;
    private String Adress;
    private String geoRequest;

    public YandexRequest() {
        //  sendDataURL();
    }

    public String getLocation(String message, boolean isGPS) {
        System.out.println("yandex message="+ message);
        if (isGPS) {
            geoRequest = "https://geocode-maps.yandex.ru/1.x/?format=json&geocode=" + message.split(";")[0]+","+message.split(";")[1];
        } else {
            splitCellData(message);
            getCellCoordinates();

        }
        getLocation();
        return Adress;
    }
public String getCellLocation(String message)
{
     splitCellData(message);
      getCellCoordinates();
      String answer=Double.toString(lat)+";"+Double.toString(lon);
     return answer;
}
    private void splitCellData(String message) {
        String paramsbody[] = message.split(",");
        HashMap<String, String> parameters = new HashMap<String, String>();
        for (String paramsbody1 : paramsbody) {
            String[] value = paramsbody1.split(":");
            if (paramsbody1.length() > 2) {
                parameters.put(value[0], value[2]);
            }
        }
        for (String key : parameters.keySet()) {
            switch (key) {

                case "MCC":
                    this.mcc = Integer.parseInt(parameters.get(key));
                    break;
                case "MNC":
                    this.mnc = Integer.parseInt(parameters.get(key));
                    break;
                case "LAC":
                    this.lac = Integer.parseInt(parameters.get(key));
                    break;
                case "CID":
                    this.cid = Integer.parseInt(parameters.get(key));
                    break;

            }

        }
    }

    public void getCellCoordinates() {

//   json={"common": {"version": "1.0","api_key": "AAwkGkwBAAAA9muWLAMAKp9XjTBZtmOLeiBQJqHX6YEqNdUAAAAAAAAAAAAoEP1ZsBlcVFA_OpP55MK3Ek1r8A=="},
//   "gsm_cells": [{"countrycode": 250,"operatorid": 1,"cellid": 29016,"lac": 717,"signal_strength": -80,"age": 5555}],
//       
        String host = "http://api.lbs.yandex.net/geolocation";

        try {
            conn = new URL(host).openConnection();
        } catch (MalformedURLException ex) {
            System.err.println("YandexRequest:getCellCoordinates:MalformedURLException: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("YandexRequest:getCellCoordinates:IOException: " + ex.getMessage());
        }
        String jsonA = "json=" + makeJson().toString();
        int k = jsonA.getBytes().length;
        conn.setDoOutput(true);// Triggers POST.
        //conn.setRequestProperty("POST", "/geolocation HTTP/1.1\n");
        conn.setRequestProperty("Host", "api.lbs.yandex.net");
        conn.setRequestProperty("Accept-Encoding", "identity");
        conn.setRequestProperty("Content-length", k + "");
        conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Cache-Control", "no-cache");
        conn.setRequestProperty("Postman-Token", "f7308c39-1a7f-4326-459e-305d491d65c4");

        // пишем туда HTTP request
        String request = jsonA;
        try {
            out = new OutputStreamWriter(conn.getOutputStream(), "ASCII");
            out.write(request);
            out.write("\r\n");
            out.flush();
            out.close();
        } catch (IOException ex) {
            System.err.println("YandexRequest:getCellCoordinates:IOException2: " + ex.getMessage());
        }

        try {
            in = conn.getInputStream();
            incoming = new byte[64 * 1024];
            length = in.read(incoming);
        } catch (IOException ex) {
            System.err.println("YandexRequest:getCellCoordinates:IOException3: " + ex.getMessage());
        }
        System.out.println("Client query(" + length + " bytes):\n" + new String(incoming).trim());
        JSONObject jAnsw = new JSONObject(new String(incoming));
        System.out.println("jAnsw=" + jAnsw);
        try {
            out.close();
            in.close();
        } catch (IOException ex) {
            System.err.println("YandexRequest:getCellCoordinates:IOException4: " + ex.getMessage());
        }

        JSONObject jAnsw1 = jAnsw.getJSONObject("position");
        lat = (Double) jAnsw1.getDouble("latitude");
        lon = (Double) jAnsw1.getDouble("longitude");
        geoRequest = "https://geocode-maps.yandex.ru/1.x/?format=json&geocode=" + lon + "," + lat + "";
    }

    private void getLocation() {

        try {
            conn = new URL(geoRequest).openConnection();
        } catch (MalformedURLException ex) {
            System.err.println("YandexRequest:getLocation:MalformedURLException: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("YandexRequest:getLocation:IOException: " + ex.getMessage());
        }
        // conn.setDoOutput(false);
        conn.setDoInput(true);

        StringBuilder strBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            while ((line = in.readLine()) != null) {
                strBuilder.append(line).append('\n');
            }
        } catch (IOException ex) {
            System.err.println("YandexRequest:getLocation:IOException2: " + ex.getMessage());
        }
        System.out.println(strBuilder);
        System.err.println("--=-=-=-=-=-=-=-=-=-=-=-=");
        JSONObject jAnsw = new JSONObject(strBuilder.toString());

        System.out.println("jAnsw=" + jAnsw.toString());
//        try {
//            out.close();
//            in.close();
//
//        } catch (IOException ex) {
//            System.err.println("YandexRequest:getLocation:IOException3: " + ex.getMessage());
//        }
        getAdressfromReceivedJson(jAnsw);

        System.out.println("Adress: " + Adress);

    }

    private String getAdressfromReceivedJson(JSONObject jsonObj) {

        JSONObject response = jsonObj.getJSONObject("response");
        JSONObject GeoObjectCollection = response.getJSONObject("GeoObjectCollection");
        JSONObject metaDataProperty = GeoObjectCollection.getJSONObject("metaDataProperty");
        JSONObject GeocoderResponseMetaData = metaDataProperty.getJSONObject("GeocoderResponseMetaData");

        int results = GeocoderResponseMetaData.getInt("results");
        JSONArray featureMember = GeoObjectCollection.getJSONArray("featureMember");


        for (int i = 0; i < results; i++) {
            JSONObject GeoObject = featureMember.getJSONObject(0);

            if (GeoObject.getJSONObject("GeoObject").getJSONObject("metaDataProperty").getJSONObject("GeocoderMetaData").getString("kind").equals("street")) {
                Adress = GeoObject.getJSONObject("GeoObject").getJSONObject("metaDataProperty").getJSONObject("GeocoderMetaData").getString("text");
            }
            if (GeoObject.getJSONObject("GeoObject").getJSONObject("metaDataProperty").getJSONObject("GeocoderMetaData").getString("kind").equals("house")) {
                Adress = GeoObject.getJSONObject("GeoObject").getJSONObject("metaDataProperty").getJSONObject("GeocoderMetaData").getString("text");
            }
        }
        return Adress;
    }

    private JSONObject makeJson() {
        JSONObject json = new JSONObject();
        Map common = new LinkedHashMap();

        common.put("api_key", "AAwkGkwBAAAA9muWLAMAKp9XjTBZtmOLeiBQJqHX6YEqNdUAAAAAAAAAAAAoEP1ZsBlcVFA_OpP55MK3Ek1r8A==");
        common.put("version", "1.0");

        Map gsm_cell = new LinkedHashMap();
        gsm_cell.put("countrycode", mcc);
        gsm_cell.put("operatorid", mnc);
        gsm_cell.put("cellid", cid);
        gsm_cell.put("lac", lac);
        // gsm_cell.put("signal_strength", "-100");
        // gsm_cell.put("age", "4555");

        JSONArray gsm_cells = new JSONArray();
        gsm_cells.put(gsm_cell);

        json.put("common", common);
        json.put("gsm_cells", gsm_cells);
        // System.out.println(json);
        return json;
    }
}
