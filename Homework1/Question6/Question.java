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
	/*
	//http://paulbourke.net/geometry/circlesphere/
	public static boolean intersects(Point centers[],int radii[]){
		int x = centers[0].x - centers[1].x;
		int y = centers[0].y - centers[1].y;
		int radius = radii[0] + radii[1];
	    return (x * x + y * y <= radius * radius);
	}
	*/
	public static String Test(Point centers[],int radii[]){
		int x1 = centers[0].x;
		int x2 = centers[1].x;
		int y1 = centers[0].y;
		int y2 = centers[1].y;
 		double distance = Math.sqrt(  Math.pow((x1-x2),2) + Math.pow((y1 - y2),2) );
		//System.out.printf("%f, %d",distance,Math.abs(radii[0] + radii[1]));
		if(x1 == x2 && y1 == y2 && radii[0] == radii[1]){
			return " completely within";
		}else if (distance > (radii[0] + radii[1])) {
			return "separate from" ;
		} else if (distance == Math.abs(radii[0] + radii[1])) {
			return "touching";
		} else {
			return "overlapping";
		}
	}
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);                                                          
        String line;                                                                                     
        String[] lineArr;                                                                                
        Point centers[] = new Point[2]; 
        int radii[] = new int[2];                                                               
		
        System.out.println(" Enter 3 Points Separated Comma ex. x,y,radius 2,3,1");    
        for(int i=0;i<2;i++){        
            line = input.nextLine();   
            lineArr = line.split(",");                                                                   
            centers[i] = new Point(Integer.parseInt(lineArr[0]),Integer.parseInt(lineArr[1])); 
			radii[i] = Integer.parseInt(lineArr[2]);
        }  
		System.out.printf("The circles are %s each other\n",Test(centers,radii));
	}
}
