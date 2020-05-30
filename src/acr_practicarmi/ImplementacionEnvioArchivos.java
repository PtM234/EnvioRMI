/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acr_practicarmi;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author tapia
 */
public class ImplementacionEnvioArchivos extends UnicastRemoteObject implements RemoteInterfaceEnvioArchivos{
    
    List<String> result;
    String PATH = "C:\\Users\\tapia\\Documents\\NetBeansProjects\\ACR_Practica10\\src\\ArchivosParaEnviar\\"; 
    
    public ImplementacionEnvioArchivos() throws Exception{
        System.out.println("Todo ok");
    }
    
    public List<String> devolverArchivos() throws Exception {
        try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\tapia\\Documents\\NetBeansProjects\\ACR_Practica10\\src\\ArchivosParaEnviar\\"))) {

	result = walk.filter(Files::isRegularFile).map(x -> x.toString().substring(80)).collect(Collectors.toList());
        
        return result;

	//result.forEach(System.out::println);

} catch (IOException e) {
	e.printStackTrace();
}
        return result;
    }

    @Override
    public byte[] archivoAEnviar(String nombreArchivo) throws Exception {
        byte[] filebytes = null;
        String path = PATH+nombreArchivo;
        FileInputStream fileInput = null;
        BufferedInputStream bi = null;
        String newString = path.substring(80);
        System.out.println(newString);
        
        try{
            File file = new File(path);
            fileInput = new FileInputStream(file);
            bi = new BufferedInputStream(fileInput);
            filebytes = new byte[(int) file.length()];
            bi.read(filebytes, 0, filebytes.length);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return filebytes;
    }
    
}
