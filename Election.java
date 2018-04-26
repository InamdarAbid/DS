
package client_server;

import java.util.*;
public class Election_Algo {    
    static List pro;
    static List sta;    
    static int election(int p1,int n)
    {
        int max_prior = -1;
        for(int i=0;i<n;i++)
        {
            int temp = (Integer)sta.get(i);           ;
            int temp2 = (Integer)pro.get(i);
                      if(temp == 1)
            {
                if(temp2 > max_prior)
                {
                    max_prior = i;
                }
            }
            
        } 
               return (max_prior + 1);
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of process : ");
        int n = sc.nextInt();
        int coordinator = 0;
        pro = new ArrayList(n);
        sta = new ArrayList(n);
        int temp = -1;
        for(int i=0;i<n;i++)
        {
            System.out.println("For a process "+(i+1)+":");
            System.out.print("Status (0/1) : ");       //0 is down and 1 is live      
            sta.add(i,sc.nextInt());
            System.out.print("and Priority (greter than 0) : ");
            pro.add(i,sc.nextInt());   }
        int ch = 0;
        int max_prior = pro.indexOf(Collections.max(pro));
        coordinator = max_prior +1;
        System.out.println("Process" + (max_prior +1)+ " is your default coordinator");
        do{
            System.out.println("****** Menu ***** ");
            System.out.println(" 1. Request \n 2. Change status \n 3. Exit");
            ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                {
                    int flag = 0;
                    do{
                        int new_cord = -1;
                        System.out.print("Enter requesting process number : ");
                        int p1 = sc.nextInt();
                        Integer i = (Integer)sta.get(p1-1);
                        if(i.intValue() != 0)
                        {
                            flag = 1;
                            Integer j = (Integer) sta.get(coordinator-1);
                            if(j.intValue() != 0)
                            {
                                System.out.println("Communication Successful.");
                                break;
                            }                                
                            else{
                                System.out.println("Process " + (max_prior+1) + "(coordinator) is down.");
                                System.out.println(p1 + " is helding elections now.");
                                coordinator = election(p1-1,n);
                                System.out.println(coordinator + " is new coordinator.");
                                break;
                            }
                        }                        
                        if(flag == 0)
                        {
                            System.out.println(p1 + " is down");
                            System.out.println("Select any other process or change status of process " + p1);
                            break;
                        }
                    }while(true);                    
                    break;
                }                
                case 2:
                {
                    System.out.print("Enter process number to cahnge status : ");
                    int p1 = sc.nextInt();  
                    int i = (Integer)sta.get(p1-1);
                    i = (i+1) % 2;
                    sta.set((p1-1), i);
                    System.out.println("Status changed successfully new status : "+ (Integer)sta.get(p1-1));                    
                    if(i == 1)
                    {
                        temp = pro.indexOf(Collections.max(pro));                        
                        if(temp == (p1-1))
                        {
                            System.out.println("The old coordinator is up.");
                            System.out.println("Coordinator sent the coordinator message to everyone.");
                        }
                        else
                        {
                            System.out.println(p1 + " is helding elections now.");
                            int new_cord = election(p1-1,n);
                            System.out.println(new_cord + " is new coordinator.");
                        }
                    }
                    break;
                }
            }
        }while(ch!=3);
    }   
}
