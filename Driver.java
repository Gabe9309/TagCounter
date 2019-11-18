import java.io.FileNotFoundException;

public class Driver {
	
	public static void main(String[] args) {
		String fileName = args[0];
		Manager manager = new Manager(fileName);
		
		try {
			manager.Manage();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
