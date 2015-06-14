/*
  (c) 2005, Binildas C. A., biniljava<at>yahoo.co.in
  relased under terms of the GNU public license
  http://www.gnu.org/licenses/licenses.html#TOCGPL
*/

package client;

import java.io.Serializable;

import common.TaskIntf;

public class TaskImpl implements TaskIntf, Serializable{

	static{
		log("client.TaskImpl.class.getClassLoader(v1) " + TaskImpl.class.getClassLoader());
	}

	public void execute(){

		log("this = " + this + "; execute(1)");
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