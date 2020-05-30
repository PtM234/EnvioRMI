/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acr_practicarmi;

import java.util.List;
import java.rmi.Remote;

/**
 *
 * @author tapia
 */
public interface RemoteInterfaceEnvioArchivos extends Remote {
    public List<String> devolverArchivos() throws Exception;
    public byte[] archivoAEnviar(String nombreArchivo) throws Exception;
    
}
