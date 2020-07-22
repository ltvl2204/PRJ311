/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshoprmi;

import java.rmi.Remote ;
import java.rmi.RemoteException ;
import java.util.ArrayList;
import model.Employee;
/**
 *
 * @author Viet Long
 */
public interface EmployeeServices extends Remote {
    
     ArrayList<Employee> getAllEmployee() throws RemoteException;
    
     Employee getEmployee(String id) throws RemoteException;
    
     boolean addEmployee(Employee emp) throws RemoteException;

     boolean editEmployee(Employee emp) throws RemoteException;
     boolean removeEmployee(String id) throws RemoteException;
}

