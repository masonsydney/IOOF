package com.ioof;

public interface iCommand {

	/**
	* <b>Description:</b><br>
	* Move active robot to particular direction 1 step 
	* @return true:move correctly, false:move incorrectly
	* @Note if false, there should be with message (getMessage())
	* <b>Author:</b> Mason Zhang
	* <br><b>Date:</b> Jul 4, 2022
	* <br><b>Version:</b> 1.0
	*/
	public boolean move();
	
	/**
	* <b>Description:</b><br>
	* Place active robot to a place 
	* @param position the position with format {x,y,f} 
	* @return true:place correctly, false:place incorrectly
	* @Note if false, there should be with message (getMessage())
	* <b>Author:</b> Mason Zhang
	* <br><b>Date:</b> Jul 4, 2022
	* <br><b>Version:</b> 1.0
	*/
	public boolean place(String position);
	
	/**
	* <b>Description:</b><br>
	* Change direction to left side 
	* @Note
	* <b>Author:</b> Mason Zhang
	* <br><b>Date:</b> Jul 4, 2022
	* <br><b>Version:</b> 1.0
	*/
	public void left();
	
	/**
	* <b>Description:</b><br>
	* Change direction to right side 
	* @Note
	* <b>Author:</b> Mason Zhang
	* <br><b>Date:</b> Jul 4, 2022
	* <br><b>Version:</b> 1.0
	*/
	public void right();
	
	/**
	* <b>Description:</b><br>
	* Report current position and direction 
	* @return {x},{y},{direction}
	* @Note
	* <b>Author:</b> Mason Zhang
	* <br><b>Date:</b> Jul 4, 2022
	* <br><b>Version:</b> 1.0
	*/
	public String report();
	
	/**
	* <b>Description:</b><br>
	*  Get error message
	* @return
	* @Note
	* <b>Author:</b> Mason Zhang
	* <br><b>Date:</b> Jul 4, 2022
	* <br><b>Version:</b> 1.0
	*/
	public String getMessage();
}
