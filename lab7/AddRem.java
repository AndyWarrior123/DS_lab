package lab7;

import java.rmi.*;  
public interface AddRem extends Remote{  
public int add(int x,int y)throws RemoteException;  
}  