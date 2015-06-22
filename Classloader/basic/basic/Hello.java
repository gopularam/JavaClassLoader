package basic;

import static java.lang.System.out;

/**
 * Classloader basic example
 * 
 */
public class Hello {

	private void test() {

		Integer integer = 12;
		String string = new String();
		Simple simpleObject = new Simple();
		Thread thread = new Thread(new MyThread());
		
		out.println("integer class-FQDN is :" + integer.getClass());
		
		out.println("integer classloader:" + integer.getClass().getClassLoader());

		out.println("string classloader:" + string.getClass().getClassLoader());
		
		out.println("SimpleObj classloader:" + simpleObject.getClass().getClassLoader());
		
		out.println("MyThread classloader:" + thread.getContextClassLoader());
		
		thread.setContextClassLoader(new MyCL());
		
		out.println("MyThread classloader:" + thread.getContextClassLoader());

	}

	
	protected class Simple {
	}

	
	protected class MyCL extends ClassLoader {
		public MyCL() {
			super();
		}
		public String toString() {
			return "MyClassLoader";
		}
	}
	
	protected class MyThread implements Runnable {
		public void run() {
			out.println("MyThread.run()");
		}
	}
	
	public static void main(String[] main) {
		Hello first = new Hello();
		first.test();
	}

}
