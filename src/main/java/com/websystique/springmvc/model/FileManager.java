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
public interface FileManager {
    
    public void createFile();
	public boolean fileExist();
	public void writeFile(User user);
    
}
