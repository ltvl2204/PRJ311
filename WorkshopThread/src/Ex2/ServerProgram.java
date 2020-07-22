/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

import java.io.IOException;
import java.net.ServerSocket;



/**
 *
 * @author macbook
 */
public class ServerProgram  { 
    
    public static void main(String[] args) throws IOException {
        ServerSocket listener = null;
        int clientNumber = 0;
        try {
            listener = new ServerSocket(7777);
            System.out.println("Server is waiting to accept user...");
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        try {
            while (true) {
                ServiceThread st = new ServiceThread(clientNumber++, listener.accept() );
                st.start();
            }
        }
        finally {
        listener.close();
        }
    }
    
}
