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
import java.io.*;

import common.ServerIntf;
import common.TaskIntf;
import common.FileSystemClassLoader;

public class Client {

	public static void main(String[] args) {

		ServerIntf serverIntf = null;
		TaskIntf taskIntf = new TaskImpl();
		try {
			serverIntf = (ServerIntf) Naming.lookup("Hello");
			
			byte[] code = getClassDefinition("client.TaskImpl");
			serverIntf.execute("client.TaskImpl", code);
		} catch (NotBoundException | MalformedURLException | RemoteException e) {
			e.printStackTrace();
		}

	}

	private static byte[] getClassDefinition(String codeName) {

		String userDir = System.getProperties().getProperty("BytePath");
		FileSystemClassLoader fscl1 = null;

		try {
			fscl1 = new FileSystemClassLoader(userDir);
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}
		return fscl1.findClassBytes(codeName);
	}
}