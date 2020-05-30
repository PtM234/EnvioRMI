/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acr_practicarmi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

/**
 *
 * @author tapia
 */
public class Cliente {
    public static void main(String[] args) throws RemoteException, NotBoundException, Exception {
        RemoteInterfaceEnvioArchivos riea;
        Registry reg = LocateRegistry.getRegistry("localhost", 1234);
        riea = (RemoteInterfaceEnvioArchivos) reg.lookup("Envio");
        String nombreArchivo = "Maria.mp3";
        String directorioDeArchivos = "C:\\Users\\tapia\\Documents\\NetBeansProjects\\ACR_Practica10\\src\\ArchivosParaRecibir\\";
        byte[] archivoARecibir = null;
        
        System.out.println("Prueba uno:");
        
        riea.devolverArchivos().forEach(System.out::println);
        
        System.out.println("Prueba dos:");
        archivoARecibir = riea.archivoAEnviar(nombreArchivo);
        File file;
        FileOutputStream fos = null;
        
        try{
            file = new File(directorioDeArchivos + nombreArchivo);
            fos = new FileOutputStream(file);
            
            if (!file.exists()){
                file.createNewFile();
            }
            System.out.println(archivoARecibir.length);
            fos.write(archivoARecibir);
            fos.flush();
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Prueba tres: ");
        String[] strarray = riea.devolverArchivos().toArray(new String[0]);
        System.out.println(Arrays.toString(strarray));
        
        /*try (FileOutputStream fos = new FileOutputStream("C:\\Users\\tapia\\Documents\\NetBeansProjects\\ACR_Practica10\\src\\ArchivosParaRecibir")){
            fos.write(riea.archivoAEnviar("Maria.mp3"));
        }*/
        
    }
}
