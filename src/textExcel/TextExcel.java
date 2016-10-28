package textExcel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Scanner;
import textExcel.TestsALL.Helper;

// Update this file with your own code.
public class TextExcel
{
	public static void main(String[] args)
	{
		Spreadsheet grid = new Spreadsheet();
		
		Scanner console = new Scanner(System.in);
		String x = console.nextLine();
		
		while (!(x.equalsIgnoreCase("quit"))) {
			String print1 = grid.processCommand(x);
			System.out.println(print1);
			x = console.nextLine();
	        

		}
		
	}
}
