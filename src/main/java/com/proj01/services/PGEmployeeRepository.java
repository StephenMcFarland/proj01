package com.proj01.services;


import com.proj01.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PGEmployeeRepository implements Repository<Employee, Integer>{
    private PostgresConnector connector;

    public PGEmployeeRepository(PostgresConnector connector) {
        this.connector = connector;
    }

    @Override
    public List<Employee> getAll() {
        String sql = "";
        List<Employee> employees = null;
        try(Connection connection = connector.getConnection("user1", "user1", "jdbc:postgresql://localhost:5432/postgres")) {
            sql = "SELECT user_id, empName, empPhone, empAddress, email from EMPLOYEEs ORDER BY user_id";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            employees = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt("user_id");
                String name = rs.getString("empName");
                long phone = rs.getLong("empPhone");
                String address = rs.getString("empAddress");
                String email = rs.getString("email");
                Employee e = new Employee(id, name, phone, address, email);
                employees.add(e);
            }
            return employees;


        } catch(SQLException e) {
            System.out.println("Failed to get all employees " + e.getMessage());
        }

        return employees; // employees is null here
    }
    @Override
    public List<Employee> getEmpUp(String email) {
        String sql = "";
        List<Employee> employee = null;
        try(Connection connection = connector.getConnection("user1", "user1", "jdbc:postgresql://localhost:5432/postgres")) {
            sql = "SELECT user_id, empName, empPhone, empAddress, email from EMPLOYEEs where email='"+email+"'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            employee = new ArrayList<>();
            while(rs.next()) {
                int id = rs.getInt("user_id");
                String name = rs.getString("empName");
                long phone = rs.getLong("empPhone");
                String address = rs.getString("empAddress");
                String email2 = rs.getString("email");
                Employee e = new Employee(id, name, phone, address, email2);
                employee.add(e);
            }
            return employee;


        } catch(SQLException e) {
            System.out.println("Failed to get employee " + e.getMessage());
        }

        return employee; // employees is null here
    }

    @Override
    public List<Employee> getById(Integer id) {
        String sql = "";
        List<Employee> employees = null;
        try(Connection connection = connector.getConnection("user1", "user1", "jdbc:postgresql://localhost:5432/postgres")) {
            sql = "SELECT user_id, empName, empPhone, empAddress, email from EMPLOYEE where user_id="+id;
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            employees = new ArrayList<>();
            while(rs.next()) {
                int userid = rs.getInt("user_id");
                String name = rs.getString("empName");
                long phone = rs.getLong("empPhone");
                String address = rs.getString("empAddress");
                String email = rs.getString("email");
                Employee e = new Employee(id, name, phone, address, email);
                employees.add(e);
            }
            return employees;


        } catch(SQLException e) {
            System.out.println("Failed to get all employees by id:\n" + e.getMessage());
        }

       return null;//employees; // employees is null here
    }


    @Override
    public void update(int user_id,String empName,long empPhone,String empAddress) {
        String sql = "";
        //List<Employee> employees = null;
        try(Connection connection = connector.getConnection("user1", "user1", "jdbc:postgresql://localhost:5432/postgres")) {
            //sql = "SELECT user_id, empName, empPhone, empAddress, email from EMPLOYEE where user_id="+id;
            sql = "UPDATE employees SET empName = '"+empName+"', empPhone = '"+empPhone+"',empAddress = '"+empAddress+"' ,password = 'pw' WHERE user_id='"+user_id+"'";

            PreparedStatement ps = connection.prepareStatement(sql);
       		ps.executeQuery();


        } catch(SQLException e) {
            System.out.println("Failed to update employee by id:\n" + e.getMessage());
        }

   }

    @Override
    public void delete(Integer id) {
        String sql = "";

        try(Connection connection = connector.getConnection("user1", "user1", "jdbc:postgresql://localhost:5432/postgres")) {
            sql = "DELETE from EMPLOYEEs where user_id="+id;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeQuery();

        } catch(SQLException e) {
            System.out.println("Failed to get delete employee by id:\n" + e.getMessage());
        }

    }

    @Override
    public void save(String empName,long empPhone,String empAddress,String email) {
    //public void save(int user_id,String empName,long empPhone,String empAddress,String email) {
        String sql = "";

        try(Connection connection = connector.getConnection("user1", "user1", "jdbc:postgresql://localhost:5432/postgres")) {

        	sql = "INSERT INTO employees VALUES (DEFAULT,'"+empName+"','"+empPhone+"','"+empAddress+"','pw', '"+email+"')";
        	//sql = "INSERT INTO employee VALUES ('"+user_id+"','"+empName+"','"+empPhone+"','"+empAddress+"','pw', '"+email+"')";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeQuery();

        } catch(SQLException e) {
            System.out.println("Failed to save\n" + e.getMessage());
        }


    }
}

