package lab7;

import java.rmi.*;
import java.rmi.registry.*;

public class AddServer {
	public static void main(String args[]) {
		try {
			AddRem stub = new AddRemImpl();
			Naming.rebind("rmi://localhost:5000/sonoo", stub);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}