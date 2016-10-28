package textExcel;

public class SpreadsheetLocation implements Location{
	private int row;
	private int column;
	
	public SpreadsheetLocation(String location) {
		int i = 0;
		this.column = Character.toUpperCase(location.charAt(i)) - 'A';
		i++;
		this.row = Integer.parseInt(location.substring(i, location.length()));
		
	}
	
	public int getRow() {
		return this.row-1;
	}
	
	public int getCol() {
		return this.column;
	}

}
