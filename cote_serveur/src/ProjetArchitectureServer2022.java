/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;

import controller.connectionDB;

import static spark.Spark.*;

/**
 *
 * @author james
 */
public class ProjetArchitectureServer2022 {

    public static void main(String[] args) {

    	get("/students/studentId/:id/first:", (request, response) -> {
    	    return "Hello: " + request.params(":name");
    	});
  	
    	Connection con = connectionDB.getConnection();
    	
    }
    
}
