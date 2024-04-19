/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pr22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/**
 *
 * @author ПК
 */
public class HTTPRunnable implements Runnable{
    
    private String address;
    private HashMap<String,String> requestBody;
    private String responseBody;
    
    public HTTPRunnable(String address, HashMap<String,String> requestBody) {
        this.address = address;
        this.requestBody = requestBody;
    }
    
    public String getResponseBody() {
        return responseBody;
    }

    @Override
    public void run() {
        if(this.address != null && !this.address.isEmpty()) {
            try{
                URL url = new URL(this.address);
                URLConnection connection = url.openConnection();
                HttpURLConnection httpConnecton = (HttpURLConnection)connection;
                InputStreamReader isr = new InputStreamReader(httpConnecton.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String currentLine;
                StringBuilder sbResponse = new StringBuilder();
                while((currentLine = br.readLine()) != null) {
                    sbResponse.append(currentLine);
                }
                responseBody = sbResponse.toString();
                }catch(IOException ex){
                    System.out.println("Error" + ex.getMessage());
                }
        }
    }
}
