package com.ioof;

import java.util.ArrayList;

public class Robot implements iCommand {

	private boolean _PLACED = false;
	private static ArrayList<String> FACE_DIRECTION = null;
	private int _x = 0;
	private int _y = 0;
	private String _FACE = "";
	private String _MESSAGE = "";


	/**
	 * Constructor
	 */
	public Robot() {
		FACE_DIRECTION = new ArrayList<String>();
		FACE_DIRECTION.add(Common.EAST);
		FACE_DIRECTION.add(Common.SOUTH);
		FACE_DIRECTION.add(Common.WEST);
		FACE_DIRECTION.add(Common.NORTH);
	}

	@Override
	public boolean move() {

		if (_PLACED) {
			
			if (this._FACE.equals(Common.EAST)) {
				this._x = (this._x < 3) ? this._x += 1 : this._x;
			} else if (this._FACE.equals(Common.WEST)) {
				this._x = (this._x > 0) ? this._x -=1 : this._x;
			} else if (this._FACE.equals(Common.SOUTH)) {
				this._y = (this._y > 0) ? this._y -=1 : this._y;
			} else if (this._FACE.equals(Common.NORTH)) {
				this._y = (this._y < 3) ? this._y += 1 : this._y;
			}			
		} else {
			_MESSAGE = "Please place the robot at correct position first.";
		}
		return false;
	}

	@Override
	public boolean place(String position) {
		
		String[] parms = position.split(",");
		
		if (parms.length != 3) {
			_MESSAGE = "Please input correct position.";
			return false;
		}
		
		int x = Common.parseInt(parms[0]);
		int y = Common.parseInt(parms[1]);
		String f = parms[2];
		
		if (x == Common.WRONG_PARSE || y == Common.WRONG_PARSE) {
			_MESSAGE = "Please input correct number.";
			return false;
		}

		if (x > 4 || y > 4) {
			_MESSAGE = "This table is 5x5, please place the robot to correct position.";
			return false;
		}

		if (!FACE_DIRECTION.contains(f)) {
			_MESSAGE = "The face must be one of EAST/SOUTH/WEST/NORTH.";
			return false;
		}

		this._x = x;
		this._y = y;
		this._FACE = f;
		this._PLACED = true;

		return true;

	}

	@Override
	public void left() {

		if (this._PLACED) {
			int idx = FACE_DIRECTION.indexOf(_FACE);
			idx -= 1;

			if (idx < 0)
				idx = 3;
			_FACE = FACE_DIRECTION.get(idx);
		}
	}

	@Override
	public void right() {
		if (this._PLACED) {
			int idx = FACE_DIRECTION.indexOf(_FACE);
			idx += 1;

			if (idx > 3)
				idx = 0;
			_FACE = FACE_DIRECTION.get(idx);
		}
	}

	@Override
	public String report() {
		if (this._PLACED) {
			return String.format("%s,%s,%s", this._x, this._y, this._FACE);
		}
		return "";
	}

	@Override
	public String getMessage() {
		return _MESSAGE;
	}

}
