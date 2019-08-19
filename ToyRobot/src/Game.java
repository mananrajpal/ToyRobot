
public class Game {
	private int GameBoard [][];
	private int Robot;
	private Directions Facing;
	final int Max = 4;
	final int Min = 0;
	
	public Game()
	{
		GameBoard = new int [5][5];			//setting game board to 5X5 grid
		Robot = 0;							//Robot which acts as a integer to represent position
		for(int i = 0; i <= Max; i++)
		{
			for(int j=0 ; j <= Max; j++)
			{
				GameBoard[i][j] = 0;		//initializing game board to 0 initially
			}
		}
	}
	
	public void setGame()
	{
		/*
		 * 20 21 22 23 24
		 * 15 16 17 18 19
		 * 10 11 12 13 14
		 * 05 06 07 08 09
		 * 00 01 02 03 04
		 */
		int position = 0;					//local variable to set position 0 to 24 for each 2d array value
		for(int i=0; i <= Max; i++)						
		{
			for(int j = 0; j <= Max; j++)
			{
				GameBoard[i][j] = position++;
			}
		}
		Robot= 0;							//initializing robot position to be 0 initially
	}
	
	public int getPosition()
	{
		//return the position of the Robot in the grid
		return Robot;
	}
	
	public Boolean PlaceRobot(int location, String direction)
	{
		for(int i = 0; i <= Max; i++)
		{
			for(int j = 0; j <= Max; j++)
			{
				if((GameBoard[i][j] == location) && (validateDirection(direction)))	//checks if GameBoard has the value equivalent to the location input by user
				{
					// if correct location within GameBoard
					this.Robot = location;
					this.Facing = matchDirection(direction);
					return true;
				}
			}
		}
		return false;
	}
	
	public void turnLeft()
	{
		switch(Facing)
		{
			case North:
				Facing = Directions.West;
				return;
			case South:
				Facing = Directions.East;
				return;
			case East:
				Facing = Directions.North;
				return;
			case West:
				Facing = Directions.South;
			return;
			default:
				Facing = Directions.West;
				return;
		}
	}
	
	public void turnRight()
	{
		switch(Facing)
		{
			case North:
				Facing = Directions.East;
				return;
			case South:
				Facing = Directions.West;
				return;
			case West:
				Facing = Directions.North;
				return;
			case East:
				Facing = Directions.South;
				return;
			default:
				Facing = Directions.East;
				return;
		}
	}
	
	public boolean validateDirection(String direction)
	{
		//validation method to check against string
		//direction inserted by user
		switch(direction)
		{
		case "NORTH":
			return true;
		case "SOUTH":
			return true;
		case "EAST":
			return true;
		case "WEST":
			return true;
		default:
			return false;
		}
	}
	
	public Directions matchDirection(String direction)
	{
		switch(direction)
		{
		case "NORTH":
			return Directions.North;
		case "SOUTH":
			return Directions.South;
		case "EAST":
			return Directions.East;
		case "WEST":
			return Directions.West;
		default:
			return Directions.North;
		}
	}
	public Boolean moveRobot()
	{
		switch(Facing)
		{
			case North:
				if((Robot + 5) <= GameBoard[Max][Max])		// If New position of Robot is less than the maximum position of the grid
				{
					//set Robot to the new position of North which is 5 value higher than current
					Robot = Robot + 5;
					return true;
				}
				return false;
			case South:
				if((Robot - 5) >= GameBoard[Min][Min])		//If new position of Robot is higher than the minimum position of the grid
				{
					//set Robot to the new position of South which is 5 value lower than current
					Robot = Robot - 5;
					return true;
				}
				return false;
			case East:
				for(int i=0; i <= Max; i++)
				{
					if(GameBoard[i][4] == Robot )			//If new position of Robot is equivalent to the edge of value of the grid
					{
						//don't make Robot move in that direction
						return false;
					}
				}
				Robot = Robot + 1;
				return true;
				
			case West:										//If new position of Robot is equivalent to the edge of value of the grid
				for(int i = 0; i <= Max; i++)
				{
					//don't make Robot move in that direction
					if(GameBoard[i][0] == Robot)
					{
						return false;
					}
				}
				Robot = Robot - 1;
				return true;
				
			default:
				return false;
		}
	}
	
	public String getXY()
	{
		for(int i = 0; i <= Max; i++)
		{
			for(int j = 0; j <= Max; j++)
			{
				/*
				 * 20 21 22 23 24
				 * 15 16 17 18 19
				 * 10 11 12 13 14
				 * 05 06 07 08 09
				 * 00 01 02 03 04
				 */
				//get the robot location and compare it to the i and j value of Gameboard
				//return i and j value so that it can be reported back
				if(GameBoard[i][j] == this.Robot)
				{
					return i + ", " + j;
				}
			}
		}
		return "";
	}
	
	public void setDirection(Directions direction)
	{
		this.Facing = direction;
	}
	
	public int getGameBoardValue(int x, int y)
	{
		return this.GameBoard[x][y];
	}
	
	public String getDirection()
	{
		switch(Facing)
		{
			case North:
				return "North";
			case South:
				return "South";
			case West:
				return "West";
			case East:
				return "East";
			default:
				return "North";
		}
	}
	
}
