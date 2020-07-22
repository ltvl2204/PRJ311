/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macbook
 */
public class Thread1 extends Thread {
    
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        boolean check;
        do{
            for(int i = 100; i >= 0; i--){
                System.out.println(i);
                try {
                    Thread1.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.print("Do you want to continue or stop(Y/N): ");
            check = scanner.nextLine().charAt(0) == 'Y';
        }while(check);
    }
    
    public static void main(String[] args) {
        Thread1 thread = new Thread1();
        thread.start();
    }
    
    
}
