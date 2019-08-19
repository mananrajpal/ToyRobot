import java.io.Console;
public class Robot {

	public static void main(String[] args) {
		
		boolean firstcommand = false;
		boolean end = true;
		Game g1 = new Game();
		for(int i = 0; i < args.length; i++)
		{
			String command = args[i];
			if(command.equals("PLACE"))
			{
				command = command + " " + args[i+1];
				i++;
			}
			if(command.equals( "MOVE"))
			{
				if(firstcommand == true)
				{
					g1.moveRobot();
				}	
			}
			else if(command.equals("LEFT"))
			{
				if(firstcommand == true)
				{
					g1.turnLeft();
				}	
			}
			else if(command.equals("RIGHT"))
			{
				if(firstcommand == true)
				{
					g1.turnRight();
				}	
			}
			else if(command.equals("REPORT"))
			{
				if(firstcommand == true)
				{
					System.out.println(g1.getXY() + ", " + g1.getDirection());
				}	
			}
			else
			{
				if(firstcommand == false)
				{
					firstcommand = true;
					g1.setGame();
				}
				String[] userinput = command.split(" ");
				String[] params;
				int x = 0;
				int y = 0;
				params = userinput[1].split(",");
				x = Integer.parseInt(params[0]);
				y = Integer.parseInt(params[1]);
				String direction= params[2];
				g1.PlaceRobot(g1.getGameBoardValue(x, y), direction);
			}
		}
		

	}

}
