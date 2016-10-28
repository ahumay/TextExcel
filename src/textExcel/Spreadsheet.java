package textExcel;

import java.util.Arrays;
import java.util.StringTokenizer;

import sun.invoke.empty.Empty;

public class Spreadsheet implements Grid{
	private static final int ROWS = 20;
	private static final int COLUMNS = 12; 
	private static final String LETTERS[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",};
	private Cell[][] arr = new Cell[ROWS][COLUMNS];
	public Spreadsheet() {
		arr = new Cell[ROWS][COLUMNS];
		empty();
	}
	private void empty() {
		for (int i = 0; i < this.arr.length; i++) {
			for (int j = 0; j < this.arr[0].length; j++) {
				arr[i][j] = new Emptycell();
			}
		}
	}
	public String processCommand(String command) {
		String result = "";
		
		StringTokenizer str = new StringTokenizer(command);
		if (str.hasMoreTokens()) {
			result = str.nextToken();
		}
		else {
			result = "";
		}
		
		if (result.equalsIgnoreCase("print")) {
			result = getGridText();
		}
		if (result.equalsIgnoreCase("clear")) {
			if (str.hasMoreTokens()) {
				String answer = str.nextToken();
				if (answer.matches("[a-lA-L][1-9][0-9]?")) {
					Location x = new SpreadsheetLocation(answer);
					this.arr[x.getRow()][x.getCol()] = new Emptycell();
					result = "";
				}
				
			}
			else {
				empty();
				result = "";
			}

		}
		if (result.matches("[a-lA-L][1-9][0-9]?")){
			Location x = new SpreadsheetLocation(result);
			if (str.hasMoreTokens()) {
				String answer= str.nextToken();
				answer = str.nextToken();
				while(str.hasMoreTokens()){
					answer += " " + str.nextToken();
				}
				this.arr[x.getRow()][x.getCol()] = new TextCell(answer);
				result = "";
			}
			else {
				
				result = getCell(new SpreadsheetLocation(result)).fullCellText();
			}
		}


		
		return result;

	}


	public int getRows() {
		return this.ROWS;
	}


	public int getCols() {
		return this.COLUMNS;
	}


	public Cell getCell(Location loc) {
		int row = loc.getRow();
		int col = loc.getCol();
		return arr[row][col];
	}


	public String getGridText() {

		String spaces9 = "         ";
		int number = 1;
		String total ="";
		total = "   |";
		for (int row = 0; row < arr[0].length; row++) {
			total +=  LETTERS[row] + spaces9 + "|";
		}

		for (int column = 0; column < arr.length; column++) {
			if (number >= 10) {
				total += "\n" + number + " |";
				for (int row = 0; row < arr[0].length; row++) {
					total +=  this.arr[column][row].abbreviatedCellText() + "|";
				}
			}
			if (number < 10) {
				total += "\n" + number + "  |";
				for (int row = 0; row < arr[0].length; row++) {
					total +=  this.arr[column][row].abbreviatedCellText() + "|";
				}

			}
			number++;
		}


		total += "\n";
		return total;
	}

}
