/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetarchitecture2022.client;

import java.sql.Connection;

import projetarchitecture2022.client.model.GroupImplementation;
import projetarchitecture2022.client.views.InterfacePrincipale;

import static spark.Spark.*;
/**
 *
 * @author james
 */
public class ProjetArchitectureClient2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	GroupImplementation group = new GroupImplementation();
    	group.initRestClient("x", "y");
		InterfacePrincipale p = new InterfacePrincipale(group);
        p.setVisible(true);
    }
    
}
