/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetarchitecture2022.client;

import java.io.File;
import java.io.IOException;

import org.ini4j.*;
import projetarchitecture2022.client.controller.RestClient;
import projetarchitecture2022.client.model.GroupImplementation;
import projetarchitecture2022.client.views.InterfacePrincipale;
/**
 *
 * @author james
 */
public class ProjetArchitectureClient2022 {
    /**
     * @param args the command line arguments
     * @throws IOException 
     * @throws InvalidFileFormatException 
     */
    public static void main(String[] args) throws InvalidFileFormatException, IOException {
    	GroupImplementation group = new GroupImplementation();
    	Ini config = new Ini(new File("urlConfiguration.ini"));
		RestClient restCli = new RestClient(config.get("Server","URL"),config.get("Server","PORT"));
    	group.initRestClient(config.get("Server","URL"),config.get("Server","PORT"));
		InterfacePrincipale p = new InterfacePrincipale(group);
        p.setVisible(true);
    }
    
}
