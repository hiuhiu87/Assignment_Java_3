/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.repository;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface ModelRepository<T> {

    public int insert(T t);

    public int update(T t);

    public ArrayList<T> getAll();

    public T selectById(String code);
    
    public String generateNextModelCode();

}
