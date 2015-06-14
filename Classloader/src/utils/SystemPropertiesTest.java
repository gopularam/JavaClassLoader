/*
  (c) 2005, Binildas C. A., biniljava<at>yahoo.co.in
  relased under terms of the GNU public license
  http://www.gnu.org/licenses/licenses.html#TOCGPL
*/

import java.util.Properties;
import java.util.Enumeration;

public class SystemPropertiesTest{

	public static void main(String[] args){

		Properties properties = System.getProperties();
		Enumeration enumeration = properties.propertyNames();

		while(enumeration.hasMoreElements()){
			Object key = enumeration.nextElement();
			log("Key " + "\t" + key + "\t\t=" + properties.getProperty((String) key) );
		}

	}

   private static final void log(Object message){

	   if(message == null)
	   		System.out.println("null");
	   	else
	   		System.out.println(message.toString());
	}

}