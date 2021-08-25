package com.proj01.services;

import com.proj01.models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;



public class ReimbursementService implements ReimRepository<Reimbursement, Integer>{


	static Logger log = Logger.getLogger(ReimRepository.class.getName());

	 private PostgresConnector connector;

	    public ReimbursementService(PostgresConnector connector) {
	        this.connector = connector;
	    }


	    @Override
	    public List<Reimbursement> getEmpPendAll(String Owner) {
	        String sql = "";
	        List<Reimbursement> reimbursements = null;
	        try(Connection connection = connector.getConnection("user1", "user1", "jdbc:postgresql://localhost:5432/postgres")) {
	            sql = "SELECT * from REIMBURSEMENT WHERE reimOwner = '"+Owner+"' AND reimStatus = 'pending' ";
	            PreparedStatement ps = connection.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();

	            reimbursements = new ArrayList<>();
	            while(rs.next()) {
	                int id = rs.getInt("reim_id");
	                String reimOwner = rs.getString("reimOwner");
	                String reimResolver = rs.getString("reimResolver");
	                double reimAmount = rs.getDouble("reimAmount");
	                String reimStatus = rs.getString("reimStatus");
	                Reimbursement r = new Reimbursement(id, reimOwner, reimResolver, reimAmount, reimStatus);
	                reimbursements.add(r);
	            }
	            return reimbursements;


	        } catch(SQLException e) {
	            System.out.println("Failed to get all pending reimbursements " + e.getMessage());
	            log.info("Failed to get all pending reimbursements");
	        }
	        return reimbursements;
	    }


	    @Override
	    public List<Reimbursement> getReimsByEmpAll(String Owner) {
	        String sql = "";
	        List<Reimbursement> reimbursements = null;
	        try(Connection connection = connector.getConnection("user1", "user1", "jdbc:postgresql://localhost:5432/postgres")) {
	            sql = "SELECT * from REIMBURSEMENT WHERE reimOwner = '"+Owner+"'";
	            PreparedStatement ps = connection.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();

	            reimbursements = new ArrayList<>();
	            while(rs.next()) {
	                int id = rs.getInt("reim_id");
	                String reimOwner = rs.getString("reimOwner");
	                String reimResolver = rs.getString("reimResolver");
	                double reimAmount = rs.getDouble("reimAmount");
	                String reimStatus = rs.getString("reimStatus");
	                Reimbursement r = new Reimbursement(id, reimOwner, reimResolver, reimAmount, reimStatus);
	                reimbursements.add(r);
	            }
	            return reimbursements;


	        } catch(SQLException e) {
	            System.out.println("Failed to get reimbursements by employee " + e.getMessage());
	            log.info("Failed to get reimbursements by  employee");
	        }
	        return reimbursements;
	    }



	    @Override
		    public List<Reimbursement> getEmpResAll(String Owner) {
		        String sql = "";
		        List<Reimbursement> reimbursements = null;
		        try(Connection connection = connector.getConnection("user1", "user1", "jdbc:postgresql://localhost:5432/postgres")) {
		            sql = "SELECT * from REIMBURSEMENT WHERE reimOwner = '"+Owner+"' AND reimStatus='resolved' ";
		            PreparedStatement ps = connection.prepareStatement(sql);
		            ResultSet rs = ps.executeQuery();

		            reimbursements = new ArrayList<>();
		            while(rs.next()) {
		                int id = rs.getInt("reim_id");
		                String reimOwner = rs.getString("reimOwner");
		                String reimResolver = rs.getString("reimResolver");
		                double reimAmount = rs.getDouble("reimAmount");
		                String reimStatus = rs.getString("reimStatus");
		                Reimbursement r = new Reimbursement(id, reimOwner, reimResolver, reimAmount, reimStatus);
		                reimbursements.add(r);
		            }
		            return reimbursements;


		        } catch(SQLException e) {
		            System.out.println("Failed to get resolved reimbursements by employee " + e.getMessage());
		            log.info("Failed to get resolved reimbursements by employee");
		        }
		        return reimbursements;
	        }


	        @Override
		    public List<Reimbursement> getReimsAll() {
		        String sql = "";
		        List<Reimbursement> reimbursements = null;
		        try(Connection connection = connector.getConnection("user1", "user1", "jdbc:postgresql://localhost:5432/postgres")) {
		            sql = "SELECT * from REIMBURSEMENT ORDER BY reim_id";
		            PreparedStatement ps = connection.prepareStatement(sql);
		            ResultSet rs = ps.executeQuery();

		            reimbursements = new ArrayList<>();
		            while(rs.next()) {
		                int id = rs.getInt("reim_id");
		                String reimOwner = rs.getString("reimOwner");
		                String reimResolver = rs.getString("reimResolver");
		                double reimAmount = rs.getDouble("reimAmount");
		                String reimStatus = rs.getString("reimStatus");
		                Reimbursement r = new Reimbursement(id, reimOwner, reimResolver, reimAmount, reimStatus);
		                reimbursements.add(r);
		            }
		            return reimbursements;


		        } catch(SQLException e) {
		            System.out.println("Failed to get all reimbursements " + e.getMessage());
		            log.info("Failed to get all reimbursements");
		        }
		        return reimbursements;
	        }





	        @Override
	    public List<Reimbursement> getPendAll() {
	        String sql = "";
	        List<Reimbursement> reimbursements = null;
	        try(Connection connection = connector.getConnection("user1", "user1", "jdbc:postgresql://localhost:5432/postgres")) {
	            sql = "SELECT * from REIMBURSEMENT WHERE reimStatus = 'pending' ";
	            PreparedStatement ps = connection.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();

	            reimbursements = new ArrayList<>();
	            while(rs.next()) {
	                int id = rs.getInt("reim_id");
	                String reimOwner = rs.getString("reimOwner");
	                String reimResolver = rs.getString("reimResolver");
	                double reimAmount = rs.getDouble("reimAmount");
	                String reimStatus = rs.getString("reimStatus");
	                Reimbursement r = new Reimbursement(id, reimOwner, reimResolver, reimAmount, reimStatus);
	                reimbursements.add(r);
	            }
	            return reimbursements;


	        } catch(SQLException e) {
	            System.out.println("Failed to get all pending reimbursements " + e.getMessage());
	            log.info("Failed to get all pending reimbursements");
	        }

	        return reimbursements;
	    }


	    @Override
	    public void reimUpdate(int id,String reimResolver, String status) {
	        String sql = "";

	        try(Connection connection = connector.getConnection("user1", "user1", "jdbc:postgresql://localhost:5432/postgres")) {

	            sql = "UPDATE reimbursement SET reimResolver = '"+reimResolver+"', reimStatus = '"+status+"' WHERE reim_id="+id;

	            PreparedStatement ps = connection.prepareStatement(sql);
	            ps.executeQuery();

	        } catch(SQLException e) {
	            System.out.println("Failed to update reim by id:\n" + e.getMessage());
	            log.info("Failed to update reimbursement by id");
	        }

	   }


	    @Override
	    public void saveReim(String reimOwner, String reimResolver,double reimAmount,String reimStatus) {
	    //public void saveReim(int reim_id,String reimOwner, String reimResolver,double reimAmount,String reimStatus) {
	        String sql = "";

	        try(Connection connection = connector.getConnection("user1", "user1", "jdbc:postgresql://localhost:5432/postgres")) {

	        	sql = "INSERT INTO reimbursement VALUES (DEFAULT,'"+reimOwner+"','','"+reimAmount+"','pending')";
	        	//sql = "INSERT INTO reimbursement VALUES ('"+reim_id+"','"+reimOwner+"','','"+reimAmount+"','pending')";

	            PreparedStatement ps = connection.prepareStatement(sql);
	            ps.executeQuery();

	        } catch(SQLException e) {
	            System.out.println("Failed to save reimbursement\n" + e.getMessage());
	            log.info("Failed to save reimbursement");
	        }


	    }
}
