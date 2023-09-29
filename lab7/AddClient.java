package lab7;

import java.rmi.*;  
public class AddClient{  
public static void main(String args[]){  
try{  
AddRem stub=(AddRem)Naming.lookup("rmi://localhost:5000/sonoo");  
System.out.println(stub.add(34,4));  
}catch(Exception e){}  
}  
} 