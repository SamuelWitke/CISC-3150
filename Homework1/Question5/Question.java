import java.util.*;
class Point {
	public int x;
	public int y;
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
}

class Question {

	public static double length(Point side1,Point side2){
		int x1 = side1.x;
		int x2 = side2.x;
		int y1 = side1.y;
		int y2 = side2.y;
		return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));	
	}
	
	public static boolean isReal(double triangle[]){
		double a = triangle[0];
		double b = triangle[1];
		double c = triangle[2];
		return !( (a + b <= c) || (a + c <= b) || (b + c <= a));
	}

	public static void main(String []args) {
		Scanner input = new Scanner(System.in);
		String line;
		String[] lineArr;
		Point points[] = new Point[3];
		double triangle[] = new double[3];

		System.out.println(" Enter 3 2D Points Seperated By Comma ex. 2,3");
		for(int i=0;i<3;i++){
			line = input.nextLine();
			lineArr = line.split(",");
			points[i] = new Point(Integer.parseInt(lineArr[0]),Integer.parseInt(lineArr[1]));
		}
		
		triangle[0] = length(points[0],points[1]);
		triangle[1] = length(points[0],points[2]);
		triangle[2] = length(points[1],points[2]);
		for(int i=0;i<3;i++){
			System.out.printf("Length = %f \n",triangle[i]);
		}
		System.out.println(isReal(triangle) ? "Real" : "Not Real");
	}
}
