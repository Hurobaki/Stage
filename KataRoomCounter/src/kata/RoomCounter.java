package kata;

import java.util.Stack;

public class RoomCounter {
	private Plan _plan;
	private int _line;
	private int _column;
	private int _roomCounter;
	
	private int[][] _copyPlan;
	
	public RoomCounter(Plan plan){
		_plan = plan;
		_line = _plan.getLine();
		_column = _plan.getColumn();
		_roomCounter = 0;
		_copyPlan = plan.getMap();
	}
	
	public int count(){
		
		_roomCounter = 0;
		for (int line = 0; line < _line; line++) {
			for (int column = 0; column < _column; column++) {
				if(followPath(line, column)) {
					_roomCounter++;
				}
			}
		}
		return _roomCounter;
	}

	private boolean followPath(int x, int y) {
		if(_copyPlan[x][y] != 0)
		{
			return false;
		}
		_copyPlan[x][y] = -1;
		followPath(x - 1, y);
		followPath(x + 1, y);
		followPath(x, y - 1);
		followPath(x, y + 1);
		
        return true;
	}
	
	public int newCount() {
		_roomCounter = 0;
		
		Stack<Point> stockPoint = new Stack<Point>(); 
		
		for (int line = 0; line < _line; line++) {
			for (int column = 0; column < _column; column++) {
				if(_copyPlan[line][column] == 0)
				{
					stockPoint.push(new Point(line, column));
					_roomCounter++;
				}
				
				while(stockPoint.size() > 0)
				{
					Point currentPoint = (Point) stockPoint.pop();
					
					if(_copyPlan[currentPoint.getX()][currentPoint.getY()] == 0)
					{
						_copyPlan[currentPoint.getX()][currentPoint.getY()] = -1;
						stockPoint.push(new Point(currentPoint.getX() - 1, currentPoint.getY()));
						stockPoint.push(new Point(currentPoint.getX() + 1, currentPoint.getY()));
						stockPoint.push(new Point(currentPoint.getX(), currentPoint.getY() - 1));
						stockPoint.push(new Point(currentPoint.getX(), currentPoint.getY() + 1));
					}
				}
			}
		}
		
		return _roomCounter;
	}
}