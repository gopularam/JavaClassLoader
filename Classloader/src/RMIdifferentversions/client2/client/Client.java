/*
  (c) 2005, Binildas C. A., biniljava<at>yahoo.co.in
  relased under terms of the GNU public license
  http://www.gnu.org/licenses/licenses.html#TOCGPL
 */

package client;

import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;

import common.ServerIntf;
import common.TaskIntf;

public class Client {

	public static void main(String[] args) {
		ServerIntf serverIntf = null;
		TaskIntf taskIntf = new TaskImpl();
		try {
			serverIntf = (ServerIntf) Naming.lookup("Hello");
			serverIntf.execute(taskIntf);
		} catch (NotBoundException | MalformedURLException | RemoteException e) {
			e.printStackTrace();
		}
	}

}