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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserAdministrator implements Administrator{
	
	User user;
	CommasFileManager cFileManager = new CommasFileManager();

	@Override
	public boolean userExist(User user) {
		File file = new File("C:/Users/dan_1/Desktop/Files/demo.txt");

		try {
		    Scanner scanner = new Scanner(file);

		    while (scanner.hasNextLine()) {
		        String line = scanner.nextLine();
		        line = line.substring(0, line.indexOf(","));
		        System.out.println(line);
		        if(line.equals(user.getMail())) { 
		        	System.out.println("YA ESTÃ? EL USUARIO");
		        	return true;
		        }else{
		        	System.out.println("NO ESTÃ? EL USUARIO");
		        }
		    }
		} catch(FileNotFoundException e) { 
		    //handle this
		}
		return false;		
	}

	@Override
	public void createAccount(String name, String mail) {
		
		user = new User(name, mail);
			
		if(!this.userExist(user)){
			cFileManager.writeFile(user);
		}
		
	}

        @Override
	public void deleteAccount(String id) {

		File inputFile = new File("C:/Users/dan_1/Desktop/Files/demo.txt");
		File tempFile = new File("C:/Users/dan_1/Desktop/Files/tempDemo.txt");

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String lineToRemove = id;
			String currentLine;

			while((currentLine = reader.readLine()) != null) {
			    // trim newline when comparing with lineToRemove
			    String trimmedLine = currentLine.trim();
			    if(trimmedLine.substring(0, trimmedLine.indexOf("@")).equals(lineToRemove)) continue;
			    writer.write(currentLine + System.getProperty("line.separator"));
			}
			writer.close(); 
			reader.close(); 
			
			inputFile.delete();
			
			//Path source = tempFile.toPath();
                        //Files.move(source, source.resolveSibling("demo.txt"));
                        Path source = Paths.get("C:/Users/dan_1/Desktop/Files/demo.txt");
                        Files.move(source, source.resolveSibling("demo.txt"));
				

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
       public String getAccount(String id){
         
         File file = new File("C:/Users/dan_1/Desktop/Files/demo.txt");

		try {
		    Scanner scanner = new Scanner(file);

		    do {
		    	System.out.println(id);
		        String line = scanner.nextLine();
		        System.out.println(line);
		        String lineShort = line.substring(0, line.indexOf("@"));
		        System.out.println(lineShort);
		     
		        if(lineShort.equals(id)) { 
		        	
		        	return line;
		        }
		    }while (scanner.hasNextLine());
		} catch(FileNotFoundException e) { 
		    //handle this
		}
         
         return null;
     }

}

