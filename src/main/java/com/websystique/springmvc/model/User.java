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
public class User {
    
        
    	private String name;
	private String mail;
		
        public User (String name, String mail){
                this.name = name;
                this.mail = mail;
        }

        public User() {
        }

        public String getName(){
                return this.name;
        }
        public String getMail(){
                return this.mail;
        }
       
}
