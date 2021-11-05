/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectteaminthanin;

import com.mycompany.projectteaminthanin.DaoModel.DaoUser;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author NITRO 5
 */
public class UserService {
    private  static ArrayList<String> userName = new ArrayList<>();
    private  static ArrayList<String> Password = new ArrayList<>();
    private static User currentUser = null;
    DaoUser daoUser;

    public UserService() {
         daoUser = new DaoUser();
         for(User dao : daoUser.getAll()){
             userName.add(dao.getUsername());
             Password.add(dao.getPassword());
         }
        
    }
    
    
}
