/*
  (c) 2005, Binildas C. A., biniljava<at>yahoo.co.in
  relased under terms of the GNU public license
  http://www.gnu.org/licenses/licenses.html#TOCGPL
*/

package server;

import common.ServerIntf;
import common.TaskIntf;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Server{

	public static void main(String args[]) {

		ServerImpl obj = null;
		ServerIntf stub = null;
		Registry registry = null;

		try {
			log("Creating ServerImpl...");
			obj = new ServerImpl();
			log("Exporting...");
			stub = (ServerIntf) UnicastRemoteObject.exportObject(obj);

			try{
				registry = LocateRegistry.createRegistry(1099);
			}
			catch(RemoteException remoteException){
				registry = LocateRegistry.getRegistry(1099);
			}
			log("Binding ServerImpl...");
			registry.rebind("Hello", stub);

			log("Server ready");
		} catch (Exception e) {
			log("Server exception: " + e.toString());
			e.printStackTrace();
		}
    }

	private static final void log(Object message){
		if(null != message){
			System.out.println(message.toString());
		}
		else{
			System.out.println("null");
		}
	}

}