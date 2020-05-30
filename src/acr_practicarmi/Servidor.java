/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acr_practicarmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author tapia
 */
public class Servidor {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        try{
            ImplementacionEnvioArchivos iea = new ImplementacionEnvioArchivos();
            Registry reg = LocateRegistry.createRegistry(1234);
            reg.bind("Envio", iea);
            System.out.println("Server: ON");
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
}
