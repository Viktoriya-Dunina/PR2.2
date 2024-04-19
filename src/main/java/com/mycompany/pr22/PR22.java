/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pr22;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ПК
 */
public class PR22 {

    public static void main(String[] args) {
        System.out.println("Дунина Виктория РИБО-02-22");
        String server = "https://www.mirea.ru";
        HTTPRunnable hTTPRunnable = new HTTPRunnable(server ,null);
        Thread th = new Thread(hTTPRunnable);
        th.start();
        try{
            th.join();
        } catch (InterruptedException ex) {
            
        }finally{
            try {
                FileWriter fw = new FileWriter("C:\\Users\\ПК\\Downloads\\file.html");
                fw.write(hTTPRunnable.getResponseBody());
                fw.close();
                System.out.println("Response from server:" + server);  
            } catch(IOException ex){
                System.out.println("Error response saving" + ex.getMessage());
            }
        }    
    }
}
