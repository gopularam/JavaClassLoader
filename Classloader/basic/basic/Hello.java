package basic;

import static java.lang.System.out;

/**
 * Class loading basic example
 * 
 * @author bgopular
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
	}

	protected class Simple {
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
