package textExcel;

//*******************************************************
// DO NOT MODIFY THIS FILE!!!
//*******************************************************

public interface Cell
{
	String abbreviatedCellText(); // text for spreadsheet cell display, must be exactly length 10
	String fullCellText(); // text for individual cell inspection, not truncated or padded
}
