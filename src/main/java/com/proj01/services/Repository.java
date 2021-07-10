package com.proj01.services;

import java.util.List;

public interface Repository<T, ID> {
    List<T> getAll();
    List<T> getById(ID id);
    //T getById(ID id);
    void update(int user_id,String empName,long empPhone,String empAddress,String email);
    void delete(ID id);
    void save(int user_id,String empName,long empPhone,String empAddress,String email);

    //void save(T obj);
}
