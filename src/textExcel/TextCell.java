package textExcel;

public class TextCell implements Cell{
	private String full = " ";
	private String abbreviated = " ";

	public TextCell(String x) {

		this.full = x;
		this.abbreviated = x;

	}

	public String abbreviatedCellText() {
		String x = this.abbreviated;
		if (x.startsWith("\"") && x.endsWith("\"")) {
			x = x.substring(0, x.length() -1);
		}
		
		if (x.length() > 10) {
			this.abbreviated = x.substring(1, 11);
		}
		else if (this.full.length() <= 10){
			for (int i = x.length(); i < 10; i++){
					x += " ";
			}
			this.abbreviated = x;
			
			 
		}
		
		return this.abbreviated;
	}


	public String fullCellText() {
		return this.full;
	}

}

