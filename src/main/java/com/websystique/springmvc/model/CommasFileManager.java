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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommasFileManager implements FileManager{

	@Override
	public void createFile(){
		PrintWriter writer;
		
            try {
                writer = new PrintWriter("C:/Users/dan_1/Desktop/Files/demo.txt", "UTF-8");
                writer.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CommasFileManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(CommasFileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
			
		
		
	}

	@Override
	public boolean fileExist() {
		
		File f = new File("C:/Users/dan_1/Desktop/Files/demo.txt");
		
		if(f.exists()){
			System.out.println("Existe");
			return true;
		}else{
			System.out.println("Nel prro");
			return false;
		}
	}

	@Override
	public void writeFile(User user) {
		System.out.println("hey");
		
		if(!this.fileExist()){
			this.createFile();
		}
		
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("C:/Users/dan_1/Desktop/Files/demo.txt", true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
		    printWriter.print(user.getMail()+",");
		    printWriter.println(user.getName());
                    fileWriter.close();
		    printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

