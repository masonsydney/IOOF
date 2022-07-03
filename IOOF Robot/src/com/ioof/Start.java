package com.ioof;

import java.util.ArrayList;
import java.util.Scanner;

/**
* <b>Description:</b><br>
* 
*  Main class of Project. 
*  Re-run application for choosing multiple robots module.
*  Lowercase input is not acceptable (Lazy to implement ^_^)
* @author Mason Zhang</a>
* @version 1.0
* @Note
* <b>ProjectName:</b> IOOF Robot
* <br><b>PackageName:</b> com.ioof
* <br><b>ClassName:</b> Start
* <br><b>Date:</b> Jul 4, 2022
*/
public class Start {
	
	private static ArrayList<Robot> _robot_queue = null; // Robot queue for Multiple Robots module
	private static int _active_robot = 0; // current active robot, 0 is default
	private static boolean _multi_robot = false; // Multiple Robots module, close is default 
	private static Scanner _scanner; 

	/**
	* <b>Description:</b><br> 
	* Main method
	* @param args
	* @Note
	* <b>Author:</b> Mason Zhang
	* <br><b>Date:</b> Jul 4, 2022
	* <br><b>Version:</b> 1.0
	*/
	public static void main(String[] args) {
		_scanner = new Scanner(System.in);
		_robot_queue = new ArrayList<Robot>();
		Robot robot = null;
		String input = "";
		
		// Select Multiple Robots module
		System.out.println("Do you want to start the multiple robots module? Please input YES/NO ");
		input = _scanner.nextLine();
		
		if (input.equals("YES")) {
			_multi_robot = true;
		}
		
		System.out.println("Please input your command one by one.");
		
		// Infinite loop for waiting user inputs command
		while (true) {
			
			input = _scanner.nextLine();
			if (input.startsWith("PLACE")) { // Trigger Place command
				 robot = new Robot();
				 input = input.replace("PLACE", "").trim();
				 
				 if (input.length() == 0 || !robot.place(input)) {
					 System.out.printf("Incorrect place.");
				 } else {
					 if (_multi_robot) _robot_queue.add(robot);
				 }
			} else if (input.equals("MOVE")) {	// Trigger Move command
				robot = _multi_robot ? _robot_queue.get(_active_robot) : robot;
				if (!robot.move()) {
					System.out.printf(robot.getMessage());
				}
			} else if (input.equals("LEFT")) {	// Trigger Left Command
				robot = _multi_robot ? _robot_queue.get(_active_robot) : robot;
				robot.left();
			} else if (input.equals("RIGHT")) {	// Trigger Right Command
				robot = _multi_robot ? _robot_queue.get(_active_robot) : robot;
				robot.right();
			} else if (input.equals("REPORT")) {	// trigger Report Command
				robot = _multi_robot ? _robot_queue.get(_active_robot) : robot;
				System.out.printf("Output: " + (_multi_robot ? "Active Robot" + (_active_robot + 1) + " " + robot.report() : ""));
			} else if (input.startsWith("ROBOT") && _multi_robot) {	// Trigger select active robot 
				input = input.replace("ROBOT", "").trim();
				int active = Common.parseInt(input) - 1;
				if (Common.parseInt(input) == Common.WRONG_PARSE) {
					 System.out.printf("Incorrect number.");
				 } else {
					 _active_robot = active;
				 }
			}
		}

	}

}
