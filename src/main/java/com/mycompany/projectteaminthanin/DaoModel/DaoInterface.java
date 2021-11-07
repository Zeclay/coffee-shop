/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectteaminthanin.DaoModel;

import java.util.ArrayList;

/**
 *
 * @author Mesaya
 */
public interface DaoInterface<T> {

    public int add(T object);

    public ArrayList<T> getAll();

    public T get(int id);

    public int delete(int id);

    public int update(T object);
}
