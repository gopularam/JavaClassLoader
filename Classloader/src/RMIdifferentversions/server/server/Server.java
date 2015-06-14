/*
  (c) 2005, Binildas C. A., biniljava<at>yahoo.co.in
  relased under terms of the GNU public license
  http://www.gnu.org/licenses/licenses.html#TOCGPL
 */

package server;

import static java.lang.System.out;
import common.ServerIntf;
import common.TaskIntf;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Server {

	public static void main(String args[]) {

		ServerImpl obj = null;
		ServerIntf stub = null;
		Registry registry = null;

		out.println("Creating ServerImpl...");
		obj = new ServerImpl();
		out.println("Exporting...");
		stub = (ServerIntf) UnicastRemoteObject.exportObject(obj);

		try {
			registry = LocateRegistry.createRegistry(1099);
		} catch (RemoteException remoteException) {
			registry = LocateRegistry.getRegistry(1099);
		}
		out.println("Binding ServerImpl...");
		registry.rebind("Hello", stub);

		out.println("Server ready");
	}
}