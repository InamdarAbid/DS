

import java.rmi.*;
import java.util.*;


public class RMI {

    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        RmiExample r=(RmiExample)Naming.lookup("rmi://localhost/validate");
        System.out.println("Enter the username : ");
        String user = sc.nextLine();
        System.out.println("Enter the PAssword : ");
        String pass = sc.nextLine();
        int result = r.validate(user,pass);
        if(result == 1)
        {
            System.out.println("You are validated");
        }
        else
        {
            System.err.println("Invalid user");
        }
    }
    
}
