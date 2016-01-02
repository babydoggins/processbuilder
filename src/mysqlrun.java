import java.io.BufferedReader;
import java.io.IOException;
//import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class mysqlrun { 
    public static void main(String [] args) throws IOException {
        
    	 List<String> commands = new ArrayList<String>();
         String[] command = {"/bin/bash", "-c", "echo rinsin | sudo -S /etc/init.d/mysql start"};
    	 commands.add("bash");
    	 commands.add("-c");
    	 commands.add("echo rinsin | sudo -S /etc/init.d/mysql start");

         System.out.println("ProcessBuilder commands: " + commands);
    	    	
        ProcessBuilder probuilder = new ProcessBuilder( commands );
        //You can set up your work directory
     //   probuilder.directory(new File("c:\\xyzwsdemo"));
        
        Process process = probuilder.start();
        
        //Read out dir output
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
      //  System.out.printf("Output of running %s is:\n",
         //       list.toString(commands));
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        
        //Wait to get exit value
        try {
            int exitValue = process.waitFor();
            System.out.println("\n\nExit Value is " + exitValue);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}