/*
  (c) 2005, Binildas C. A., biniljava<at>yahoo.co.in
  relased under terms of the GNU public license
  http://www.gnu.org/licenses/licenses.html#TOCGPL
 */

package common;

import java.rmi.RemoteException;
import java.rmi.Remote;

public interface ServerIntf extends Remote {

	void execute(TaskIntf taskIntf) throws RemoteException;

}