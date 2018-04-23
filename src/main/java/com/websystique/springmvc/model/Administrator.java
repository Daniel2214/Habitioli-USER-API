/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.model;

/**
 *
 * @author Daniel Jimenez <daniel2214 at gmail.com>
 */
public interface Administrator {
    
    public boolean userExist(User user);
    public void createAccount(String name, String mail);
    public void deleteAccount(String id);

    
}
