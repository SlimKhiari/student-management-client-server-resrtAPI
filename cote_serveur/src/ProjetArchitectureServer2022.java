/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.RestServer;

/**
 *
 * @author james
 */
public class ProjetArchitectureServer2022 {

    public static void main(String[] args) {
    	RestServer restServer = new RestServer();
    	restServer.deleteStudent();
    	restServer.getStudents();
    	restServer.getSubjects();
    	restServer.getTU();
    	restServer.getGroups();
    	restServer.getTUByTitle();
    	restServer.getSubjectByTitle();
    	restServer.getStudentById();
    	restServer.createStudent();
    	restServer.createSubjects();
    	restServer.creatTU();


    }
    
}
