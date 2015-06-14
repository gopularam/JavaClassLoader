/*
  (c) 2005, Binildas C. A., biniljava<at>yahoo.co.in
  relased under terms of the GNU public license
  http://www.gnu.org/licenses/licenses.html#TOCGPL
*/

package server;

import common.ServerIntf;
import common.TaskIntf;

import java.rmi.RemoteException;

public class ServerImpl implements ServerIntf{

	public void execute(TaskIntf taskIntf)throws RemoteException{
		taskIntf.execute();
	}

}