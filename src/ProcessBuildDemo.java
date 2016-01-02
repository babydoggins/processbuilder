import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProcessBuildDemo {
	public static void main(String[] args) {

		// Wait to get exit value
		try {
			startProcess();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void startProcess() throws IOException, InterruptedException  {
		String[] command = { "ls", "/home/redwolfe" };
		ProcessBuilder probuilder = new ProcessBuilder(command);
		// You can set up your work directory
		// probuilder.directory(new File("c:\\xyzwsdemo"));

		Process process = probuilder.start();

		// Read out dir output
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		System.out.printf("Output of running %s is:\n", Arrays.toString(command));
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		int exitValue = process.waitFor();
		System.out.println("\n\nExit Value is " + exitValue);
	}
}