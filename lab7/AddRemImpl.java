package lab7;

import java.rmi.*;
import java.rmi.server.*;

public class AddRemImpl extends UnicastRemoteObject implements AddRem {
	AddRemImpl() throws RemoteException {
		super();
	}

	public int add(int x, int y) {
		return x + y;
	}
}