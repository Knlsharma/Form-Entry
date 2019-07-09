package com.orane.registration.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orane.registration.entity.User;
import com.orane.registration.repository.Repository;




// NOTE: here response entity is used in all below functions
@CrossOrigin(origins = "*")
@RestController
public class ControllerClass
{
	
	@Autowired 
	private Repository repo;
	
	
	
	public ControllerClass() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	 
	/**********  GET MAPPING **********/
	
	
	@GetMapping("/view")
	public ResponseEntity<List<User>> getAll()
	{
		List<User> user = new ArrayList<>();
		try {
			repo.findAll().forEach(user::add);
			if (user.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(user, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		
		
	}
	
	/**********  GET MAPPING for particular Id **********/
	
	@GetMapping( value = "/view/{id}")
	  public ResponseEntity<List<User>> getFormDataById(@PathVariable int id) {
	    try {
	      List<User> formData = repo.findById(id);
	 
	      if (formData.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(formData, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	
	
	/**********  POST MAPPING **********/
	
	@PostMapping(value = "/add" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addData(@RequestBody JsonNode formNode )
	{
		HttpHeaders posthead = new HttpHeaders();
		
		   posthead.add("Lang", "en-Us");
		   posthead.getDate();
		
			ObjectMapper objectMapper = new ObjectMapper();
			String formJsonData = formNode.toString();
			try {
				
				User use = objectMapper.readValue(formJsonData, User.class);
	              repo.save(use);
			} 
			
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(formJsonData);
			
			 return new ResponseEntity<>(formJsonData,posthead ,HttpStatus.OK);
		}
		
	
	
	/**********  PUT MAPPING **********/
	
	@PutMapping("/update/{id}")
    public ResponseEntity<Object> updateForm(@PathVariable int id, @Valid @RequestBody JsonNode formNode) {
		List<User> userdata = repo.findById(id);
		 
	      if (userdata == null) {
	        return new ResponseEntity<>("Id not found",HttpStatus.NOT_FOUND);
	      }
	    	 // formRepository.deleteById(id);
	  	   	 ObjectMapper objectMapper = new ObjectMapper();
	  	   	 String formJsonData = formNode.toString();
	  	   try {
	  	   	User use = objectMapper.readValue(formJsonData, User.class);
	  	   	 int UserId=use.getId();
	  	   	 if(id!=UserId)
	  	   		 return new ResponseEntity<>("Id mismatch",HttpStatus.BAD_REQUEST);
	  	 
	  			repo.save(use);
	  		
	  		} catch (IOException e) {
	  			e.printStackTrace();
	  		}
	  		System.out.println("JSON DATA = "+ formJsonData);
	  		return new ResponseEntity<>(formJsonData, HttpStatus.OK);  
	      	
    }
	
	
	
	
	/**********  DELETE MAPPING **********/
	
	@DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Object> deleteData(@PathVariable int id) {
        repo.delete(id);
        HttpHeaders delHead = new HttpHeaders();
        delHead.add("Language" , "en-US");
		delHead.getDate();
	//	delHead.setLocation();
	//	delHead.USER_AGENT;
	
       return new ResponseEntity<>("Record Deleted", delHead,HttpStatus.OK);
    }
	
	/**********  Expose ALL MAPPING **********/
	/*
	@GetMapping("/expose")
	public ResponseEntity<List<User>> getAll(value =  )
	{
	
	}
	*/
}
