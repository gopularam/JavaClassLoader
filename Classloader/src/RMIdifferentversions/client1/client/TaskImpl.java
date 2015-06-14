/*
  (c) 2005, Binildas C. A., biniljava<at>yahoo.co.in
  relased under terms of the GNU public license
  http://www.gnu.org/licenses/licenses.html#TOCGPL
 */

package client;

import java.io.Serializable;
import static java.lang.System.out;
import common.TaskIntf;

public class TaskImpl implements TaskIntf, Serializable {

	static {
		out.println("client.TaskImpl.class.getClassLoader(v1) : "
				+ TaskImpl.class.getClassLoader());
	}

	public void execute() {

		out.println("this = " + this + "; execute(1)");
	}
}