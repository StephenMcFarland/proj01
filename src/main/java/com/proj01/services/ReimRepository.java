package com.proj01.services;

import java.util.List;

import com.proj01.models.Reimbursement;

public interface ReimRepository <T, ID>{
	List<T> getPendAll();
	List<T> getReimsAll();
	List<T> getEmpPendAll(String reimOwner);
	List<T> getEmpResAll(String reimOwner);
	List<T> getReimsByEmpAll(String Owner);
	void saveReim(int reim_id,String reimOwner,String reimResolver,double reimAmount,String reimStatus);
	void reimUpdate(int reim_id, String reimResolver, String reimStatus);


}
