package com.proj01.services;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.proj01.models.Employee;
import com.proj01.models.Reimbursement;

public class TestPGEmployeeRepository {

	@Test
	public void getAllTest() {


		List<Employee> employees = null;
		Employee e = new Employee(1, "name", 1112223333L, "address", "email");
		Employee e2 = new Employee(1, "name", 1112223333L, "address", "email");
		employees = new ArrayList<>();
        employees.add(e);
        employees.add(e2);

        assertEquals(1, e.getUserId());
        assertEquals("name", e.getEmpName());
        assertEquals(1112223333L, e.getEmpPhone());
        assertEquals("address", e.getEmpAddress());
        assertEquals("email", e.getEmail());
        assertEquals(employees.size(), 2);
        assertNotNull("should not be null", employees);

	}

	@Test
	public void getEmpPendAllTest() {


		List<Reimbursement> reimbursements = null;
		Reimbursement r = new Reimbursement(1, "owner", "resolver", 123.5, "status");
		Reimbursement r2 = new Reimbursement(1, "owner","resolver", 65.7, "status");
		reimbursements = new ArrayList<>();
        reimbursements.add(r);
        reimbursements.add(r2);

        assertEquals(1, r.getReimId());
        assertEquals("owner", r.getReimOwner());
        assertEquals("resolver", r.getReimResolver());
        //assertEquals(123.5, r.getReimAmount());
        assertEquals("status", r.getReimStatus());

        assertEquals(1, r2.getReimId());
        assertEquals("owner", r2.getReimOwner());
        assertEquals("resolver", r2.getReimResolver());
        //assertEquals(65.7, r.getReimAmount());
        assertEquals("status", r2.getReimStatus());
        assertEquals(reimbursements.size(), 2);
        assertNotNull("should not be null", reimbursements);

	}

	@Test
	public void getReimsByEmpAllTest() {


		List<Reimbursement> reimbursements = null;
		Reimbursement r = new Reimbursement(1, "owner", "resolver", 123.5, "status");
		Reimbursement r2 = new Reimbursement(1, "owner","resolver", 65.7, "status");
		reimbursements = new ArrayList<>();
        reimbursements.add(r);
        reimbursements.add(r2);

        assertEquals(1, r.getReimId());
        assertEquals("owner", r.getReimOwner());
        assertEquals("resolver", r.getReimResolver());
        //assertEquals(123.5, r.getReimAmount());
        assertEquals("status", r.getReimStatus());

        assertEquals(1, r2.getReimId());
        assertEquals("owner", r2.getReimOwner());
        assertEquals("resolver", r2.getReimResolver());
        //assertEquals(65.7, r.getReimAmount());
        assertEquals("status", r2.getReimStatus());
        assertEquals(reimbursements.size(), 2);
        assertNotNull("should not be null", reimbursements);

	}

	@Test
	public void getEmpResAllTest() {


		List<Reimbursement> reimbursements = null;
		Reimbursement r = new Reimbursement(1, "owner", "resolver", 123.5, "status");
		Reimbursement r2 = new Reimbursement(1, "owner","resolver", 65.7, "status");
		reimbursements = new ArrayList<>();
        reimbursements.add(r);
        reimbursements.add(r2);

        assertEquals(1, r.getReimId());
        assertEquals("owner", r.getReimOwner());
        assertEquals("resolver", r.getReimResolver());
        //assertEquals(123.5, r.getReimAmount());
        assertEquals("status", r.getReimStatus());

        assertEquals(1, r2.getReimId());
        assertEquals("owner", r2.getReimOwner());
        assertEquals("resolver", r2.getReimResolver());
        //assertEquals(65.7, r.getReimAmount());
        assertEquals("status", r2.getReimStatus());
        assertEquals(reimbursements.size(), 2);
        assertNotNull("should not be null", reimbursements);

	}


	@Test
	public void getReimsAllTest() {


		List<Reimbursement> reimbursements = null;
		Reimbursement r = new Reimbursement(1, "owner", "resolver", 123.5, "status");
		Reimbursement r2 = new Reimbursement(1, "owner","resolver", 65.7, "status");
		reimbursements = new ArrayList<>();
        reimbursements.add(r);
        reimbursements.add(r2);

        assertEquals(1, r.getReimId());
        assertEquals("owner", r.getReimOwner());
        assertEquals("resolver", r.getReimResolver());
        //assertEquals(123.5, r.getReimAmount());
        assertEquals("status", r.getReimStatus());

        assertEquals(1, r2.getReimId());
        assertEquals("owner", r2.getReimOwner());
        assertEquals("resolver", r2.getReimResolver());
        //assertEquals(65.7, r.getReimAmount());
        assertEquals("status", r2.getReimStatus());
        assertEquals(reimbursements.size(), 2);
        assertNotNull("should not be null", reimbursements);

	}

	@Test
	public void getPendAllTest() {


		List<Reimbursement> reimbursements = null;
		Reimbursement r = new Reimbursement(1, "owner", "resolver", 123.5, "status");
		Reimbursement r2 = new Reimbursement(1, "owner","resolver", 65.7, "status");
		reimbursements = new ArrayList<>();
        reimbursements.add(r);
        reimbursements.add(r2);

        assertEquals(1, r.getReimId());
        assertEquals("owner", r.getReimOwner());
        assertEquals("resolver", r.getReimResolver());
        //assertEquals(123.5, r.getReimAmount());
        assertEquals("status", r.getReimStatus());

        assertEquals(1, r2.getReimId());
        assertEquals("owner", r2.getReimOwner());
        assertEquals("resolver", r2.getReimResolver());
        //assertEquals(65.7, r.getReimAmount());
        assertEquals("status", r2.getReimStatus());
        assertEquals(reimbursements.size(), 2);
        assertNotNull("should not be null", reimbursements);

	}

	@Test
	public void getByIdTest() {


		List<Employee> employees = null;
		Employee e = new Employee(1, "name", 1112223333L, "address", "email");
		employees = new ArrayList<>();
        employees.add(e);

        assertEquals(1, e.getUserId());
        assertEquals("name", e.getEmpName());
        assertEquals(1112223333L, e.getEmpPhone());
        assertEquals("address", e.getEmpAddress());
        assertEquals("email", e.getEmail());
        assertNotNull("should not be null", e.getUserId());

	}


	@Test
	public void updateTest() {


		List<Employee> employees = null;
		Employee e = new Employee(1, "name", 1112223333L, "address", "email");
		employees = new ArrayList<>();
        employees.add(e);

        assertEquals(1, e.getUserId());
        assertEquals("name", e.getEmpName());
        assertEquals(1112223333L, e.getEmpPhone());
        assertEquals("address", e.getEmpAddress());
        assertEquals("email", e.getEmail());

	}

	@Test
	public void saveTest() {


		List<Employee> employees = null;
		Employee e = new Employee(1, "name", 1112223333L, "address", "email");
		employees = new ArrayList<>();
        employees.add(e);

        assertEquals(1, e.getUserId());
        assertEquals("name", e.getEmpName());
        assertEquals(1112223333L, e.getEmpPhone());
        assertEquals("address", e.getEmpAddress());
        assertEquals("email", e.getEmail());






	}

}
