package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import workshoprmi.EmployeeServices;



/**
 *
 * @author Viet Long
 */
public class EmployeeDB extends UnicastRemoteObject implements EmployeeServices {

    private static Connection con;

    public EmployeeDB() throws RemoteException {

    }

    @Override
    public ArrayList<Employee> getAllEmployee() throws RemoteException {
        ArrayList<Employee> list = new ArrayList<>();
        String sql = "select * from Employee";
        try {
            con = ConnectDB.getConnect();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString(1);
                String lastName = rs.getString(2);
                String firstName = rs.getString(3);
                String gender = rs.getString(4);
                String email = rs.getString(5);
                list.add(new Employee(id, lastName, firstName, gender.charAt(0), email));
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public boolean addEmployee(Employee emp) throws RemoteException {
        String sql = "insert into Employee values (?,?,?,?,?)";
        con = ConnectDB.getConnect();
        try {
            PreparedStatement pps = con.prepareStatement(sql);
            pps.setString(1, emp.getEmp_id());
            pps.setString(2, emp.getLastName());
            pps.setString(3, emp.getFirstName());
            pps.setString(4, String.valueOf(emp.getGender()));
            pps.setString(5, emp.getEmail());
            pps.executeUpdate();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean editEmployee(Employee emp) throws RemoteException {
        String sql = "Update Employee "
                + "set ID = ?, LastName = ?, FirstName = ?, Gender = ?, Email = ? "
                + "Where ID = ?";

        con = ConnectDB.getConnect();
        try {
            PreparedStatement pps = con.prepareStatement(sql);
            pps.setString(1, emp.getEmp_id());
            pps.setString(2, emp.getLastName());
            pps.setString(3, emp.getFirstName());
            pps.setString(4, String.valueOf(emp.getGender()));
            pps.setString(5, emp.getEmail());
            pps.setString(6, emp.getEmp_id());
            pps.executeUpdate();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean removeEmployee(String id) throws RemoteException {
        String sql = "delete from Employee where ID = '" + id + "'";
        con = ConnectDB.getConnect();
        try {
            Statement s = con.createStatement();
            s.executeUpdate(sql);
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Employee getEmployee(String id) throws RemoteException {
        String sql = "select * from Employee where Emp_id = '" + id + "'";
        con = ConnectDB.getConnect();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            Employee e = null;
            if (rs.next()) {
                String ids = rs.getString(1);
                String lastName = rs.getString(2);
                String firstName = rs.getString(3);
                char gender = rs.getString(4).charAt(0);
                String email = rs.getString(5);
                e = new Employee(ids, lastName, firstName, gender, email);
                con.close();
            }
            System.out.println(e);
            return e;
        } catch (Exception e) {
            return null;
        }
    }

}
