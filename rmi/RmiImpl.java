/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;
import java.rmi.server.*;
public class RmiImpl extends UnicastRemoteObject implements RmiExample
{
    public RmiImpl() throws RemoteException
    {}    
    public int validate(String user, String pass) throws RemoteException {
        String[] uname = {"Abid","Aman","Adheesh"};
        String[] pwd = {"Abid","Aman","Adheesh"};
        int flag = 0;
        for(int i=0;i<3;i++)
        {
            if( uname[i] == user)
            {
                if(pwd[i] == pass)
                {
                    System.out.println("Suceessfully Loged In ");
                    flag = 1;
                    break;
                }
            }
        }
        if(flag == 0)
        {
            System.out.println("Login failed");
        }
        
        return 0;
    }
}

