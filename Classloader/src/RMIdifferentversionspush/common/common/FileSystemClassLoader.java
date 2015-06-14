/*
  (c) 2005, Binildas C. A., biniljava<at>yahoo.co.in
  relased under terms of the GNU public license
  http://www.gnu.org/licenses/licenses.html#TOCGPL
*/

package common;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;

public class FileSystemClassLoader extends ClassLoader {

    private String currentRoot = null;

    public FileSystemClassLoader()throws FileNotFoundException{
        this(FileSystemClassLoader.class.getClassLoader(), System.getProperties().getProperty("java.home"));
    }

    public FileSystemClassLoader(String root)throws FileNotFoundException{
        this(FileSystemClassLoader.class.getClassLoader(), root);
    }

    public FileSystemClassLoader(ClassLoader parent)throws FileNotFoundException{
        this(parent, System.getProperties().getProperty("java.home"));
    }

    public FileSystemClassLoader(ClassLoader parent, String root)throws FileNotFoundException{
        super(parent);
        File f = new File(root);
        if (f.isDirectory()){
            currentRoot = root;
		}
        else{
            throw new FileNotFoundException();
		}
    }

	public void execute(String codeName, byte[] code){

		Class klass = null;
		try{
			klass = findClass(codeName, code);
			TaskIntf task = (TaskIntf) klass.newInstance();
			task.execute();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}

    public byte[] findClassBytes(String className){

        try{
            String pathName = currentRoot + File.separatorChar +
                className.replace('.', File.separatorChar) +
                ".class";

            FileInputStream inFile =
                new FileInputStream(pathName);
            byte[] classBytes = new byte[inFile.available()];
            inFile.read(classBytes);

            return classBytes;
        }
        catch (java.io.IOException ioEx)
        {
            return null;
        }
    }

    public URL findResourceURL(String resourceName){
        return null;
    }

    public java.util.Enumeration findResourcesEnum(String resourceName){
        return null;
    }

    public String findLibraryPath(String libraryName){
        return null;
    }

    public Class findClass(String name)throws ClassNotFoundException{

        byte[] classBytes = findClassBytes(name);
        if (classBytes==null){
            throw new ClassNotFoundException();
        }
        else{
            return defineClass(name, classBytes, 0, classBytes.length);
        }
    }

    public Class findClass(String name, byte[] classBytes)throws ClassNotFoundException{

        if (classBytes==null){
            throw new ClassNotFoundException("(classBytes==null)");
        }
        else{
            return defineClass(name, classBytes, 0, classBytes.length);
        }
    }
}