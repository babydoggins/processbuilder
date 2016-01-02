import java.io.IOException;
import java.io.BufferedReader;
//import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;



public class ProcessBuilderExample { 
    public static void main(String [] args) throws IOException {
        
        String[] command = {"/bin/bash", "-c", "echo rinsin | sudo -S /etc/init.d/mysql start"};
    
    	
        
        ProcessBuilder probuilder = new ProcessBuilder( command );
        //You can set up your work directory
     //   probuilder.directory(new File("c:\\xyzwsdemo"));
        
        Process process = probuilder.start();
        
        //Read out dir output
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        System.out.printf("\nOutput of running command%s is:\n\n",
                Arrays.toString(command));
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