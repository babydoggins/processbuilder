import java.io.*;
 
public class JavaRunCommand {
 
    public static void main(String args[]) {
 
        String s = null;
 
        try {
             
//        	String[] cmdarray = {"/bin/sh","-c", "/etc/init.d/mysql start"};
        	String[] cmdarray = {"/bin/bash","-c","echo rinsin | sudo -S ls"};
        	Process p = Runtime.getRuntime().exec(cmdarray);
        	
        	
        	// run the Unix "ps -ef" command
            // using the Runtime exec method:
        
             
            BufferedReader stdInput = new BufferedReader(new
                 InputStreamReader(p.getInputStream()));
 
            BufferedReader stdError = new BufferedReader(new
                 InputStreamReader(p.getErrorStream()));
 
            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
             
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
             
            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}