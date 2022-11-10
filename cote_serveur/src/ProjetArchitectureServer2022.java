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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    	Connection con = connectionDB.getConnection();
       
    }
    
}
