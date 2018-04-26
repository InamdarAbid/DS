/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.*;


/**
 *
 * @author Student
 */
public interface RmiExample extends Remote{
      public int validate(String user ,String pass) throws RemoteException;
}   
