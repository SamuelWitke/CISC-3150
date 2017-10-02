import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

class GraphingData extends JPanel {
    public List<point>in;
	public List<point>out;
    final int PAD = 20;
 	GraphingData(List in,List out){
		this.in = in;
		this.out = out;
		setBackground(Color.black);
	}
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.red);
		int w = getWidth();
        int h = getHeight();
        // Draw ordinate.
        g2.draw(new Line2D.Double(PAD, PAD, PAD, h-PAD));
        // Draw abcissa.
        g2.draw(new Line2D.Double(PAD, h-PAD, w-PAD, h-PAD));
        double xInc = (double)(w - 2*PAD)/(in.size()-1);
        double scale = (double)(h - 2*PAD)/1;
        // Mark data points.
       	for(int i = 0; i < out.size(); i++) {
			double x = PAD + scale*out.get(i).x;
			double y = h - PAD - scale*out.get(i).y;
			g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        }
		g2.setPaint(Color.blue);
		for(int i = 0; i < in.size(); i++) {
			double x = PAD + scale*in.get(i).x;
			double y = h - PAD - scale*in.get(i).y;
			g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        }
    }
}

class point {
	public double x;
	public double y;
	point(double otherX, double otherY){
		x = otherX;
		y = otherY;
	}	
	public String toString(){
		return ""+x+" "+y;
	}
}

public class Question {
	/*
	 * Monte Carlo Method
     * A = Pi * r^2
	 * Pi = A / r^2 
	 * x = top right quadrant of a circle.
	 * Pi = 4*x / r^2
	 * x / r^2 = (top right quadrant of circle) / (area of square R)
	 * 
	*/
	public static boolean inCircle(point p,int lengthOfSquare){
		double radius = Math.PI * Math.pow(lengthOfSquare,2) / 4;
		return (Math.pow(p.x,2) + Math.pow(p.y,2) <= Math.pow(radius,2));
	}

	public static point getRndDot(int lengthOfSquare){
		Random rnd = new Random();
		double x = (double)Math.round(lengthOfSquare * rnd.nextDouble()*100000d) / 100000d;
		double y = (double)Math.round(lengthOfSquare * rnd.nextDouble()*100000d) / 100000d;
		return new point(x,y);
	}

	public static void makeChart(List<point> in, List<point> out){
		JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new GraphingData(in,out));
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
	}

	public static void monteCarlo(long numberOfDots,int lengthOfSquare){
		long numberOfDotsInCircle = 0;
		double piEstimate = 0;
		List<point> inCircle = new ArrayList<point>();
		List<point> notInCircle = new ArrayList<point>();
		for(int i=0;i<numberOfDots;i++){
			point rndDot = getRndDot(lengthOfSquare);
			if(inCircle(rndDot,lengthOfSquare)){
				inCircle.add(rndDot);
				numberOfDotsInCircle++;
			}else{
				notInCircle.add(rndDot);
			}
		}
		makeChart(inCircle,notInCircle);
		piEstimate = (double) numberOfDotsInCircle / numberOfDots;
		System.out.println(4*piEstimate);
	}

	public static void main(String ... args){
		//Scanner in = new Scanner(System.in);
		//System.out.println("Enter Amount Of Dots");
		//long numberOfDots = in.nextLong();
		long numberOfDots = 4000;
		int lengthOfSquare = 1;	
		monteCarlo(numberOfDots,lengthOfSquare);	
	}
}
