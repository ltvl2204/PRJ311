/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;



/**
 *
 * @author macbook
 */
public class ServiceThread extends Thread {
    
    private int clientNumber;
    private Socket socketOfServer;

    public ServiceThread(int clientNumber, Socket socketOfServer) {
        this.clientNumber = clientNumber;
        this.socketOfServer = socketOfServer;
        
        log("New connection with client# " + this.clientNumber + " at " + socketOfServer);
    }
    
    private static void log(String message) {
        System.out.println(message); 
    }

    @Override
    public void run() {
        try {
            BufferedReader is = new BufferedReader(new
            InputStreamReader(socketOfServer.getInputStream()));
            BufferedWriter os = new BufferedWriter(new
            OutputStreamWriter(socketOfServer.getOutputStream()));
            while (true) {
            String line = is.readLine();
            System.out.println("" + clientNumber +":" + line);
            os.write("" + clientNumber + ">> " + line);
            os.newLine();
            os.flush();
            if (line.equals("QUIT")) {
                os.write("" + clientNumber + ">> OK");
                os.newLine();
                os.flush(); break;
            }
            }
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }    
}
