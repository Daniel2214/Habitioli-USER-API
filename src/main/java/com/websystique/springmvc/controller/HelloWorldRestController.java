package com.websystique.springmvc.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.UserAdministrator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class HelloWorldRestController {

	
        UserAdministrator userAdministrator = new UserAdministrator();
	
		
	//-------------------Create a User--------------------------------------------------------
	
	@RequestMapping(value = "/signup/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, 	UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + user.getName());
                
                
		userAdministrator.createAccount(user.getName(), user.getMail());

		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
        
        
        @RequestMapping("/signup/")
	public @ResponseBody String createUser() {
		
            return "creado";
	}
        
        
        @RequestMapping(value = "/login/", method = RequestMethod.POST)
	public ResponseEntity createUser(@RequestBody User user) {
		
                if(userAdministrator.userExist(user)){
                    
                    String id;
                    id = user.getMail().substring(0, user.getMail().indexOf("@"));
                    
                    return new ResponseEntity(id ,HttpStatus.OK);
                }
                    return new ResponseEntity(HttpStatus.BAD_REQUEST);
              
	}
        
        
        //______________________Get specific user___________________________
         @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
            public ResponseEntity<String> getUser(@PathVariable("id") String id) {

                String data;
                
                data=userAdministrator.getAccount(id);
                
               return new ResponseEntity<String>(data,HttpStatus.OK);
               
               
            }
            
            
        //____________________Delete User______________________________________
         @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
             public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
             
                 userAdministrator.deleteAccount(id);
            
                 
                 return new ResponseEntity<String>(HttpStatus.OK);
                 
                 
             }
            
        
        
        
        
        
        

        
	
}
