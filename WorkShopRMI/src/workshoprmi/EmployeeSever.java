/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshoprmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import model.EmployeeDB;

/**
 *
 * @author Hi
 */
public class EmployeeSever {
    
    public static void main(String[] args) {
        String host = "rmi://localhost:1098/Employee";
        EmployeeDB emp;
        try {
            emp = new EmployeeDB(){};
            LocateRegistry.createRegistry(1098);
            Naming.rebind(host, emp);
            System.out.println("Server is opened, waitting for client");
        } catch (MalformedURLException | RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
