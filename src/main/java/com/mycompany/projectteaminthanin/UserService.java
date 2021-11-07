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

    private static User currentUser = null;
    private static ArrayList<String> userName = new ArrayList<>();
    private static ArrayList<String> Password = new ArrayList<>();

    DaoUser daoUser;

    public UserService() {
        daoUser = new DaoUser();
        for (User dao : daoUser.getAll()) {
            userName.add(dao.getUsername());
            Password.add(dao.getPassword());
        }

    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        UserService.currentUser = currentUser;
    }

    public boolean checkLogin(String username, String password) {
        ArrayList<User> daou = daoUser.getAll();

        for (int i = 0; i < daou.size(); i++) {
            if (daou.get(i).getUsername().equals(username) && daou.get(i).getPassword().equals(password)) {
                currentUser = daou.get(i);
                System.out.println(currentUser);
                return true;

            }
        }
        return false;
    }

    public static void clearUserName() {
        userName.clear();
    }

    public static void clearPassword() {
        Password.clear();
    }

    public static ArrayList<String> getUserName() {
        return userName;
    }

    public static void setUserName(ArrayList<String> userName) {
        UserService.userName = userName;
    }

    public static ArrayList<String> getPassword() {
        return Password;
    }

    public static void setPassword(ArrayList<String> Password) {
        UserService.Password = Password;
    }

}
