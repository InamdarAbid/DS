/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.*;
import java.rmi.server.*;

/**
 *
 * @author Student
 */
public class Server {
    public static void main(String[]arg) throws RemoteException
    {
        RmiImpl Obj = new RmiImpl();
        try
        {
                Naming.rebind("validate",Obj);
        }
        catch(Exception e){}
        System.out.println("Server Started...");
    }
}
