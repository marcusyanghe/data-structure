/* this I/O in this class is based on In.java, a io class from java stdlib by Princeton U.
*/
public class NBody{

	//return a double corresponding to the radius of the universe in that file
	public static double readRadius(String file){
		In in = new In(file);
		int num = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	//Given a file name, it returns an array of Planets corresponding to the planets in the file
 	public Planet[] readPlanets(String file){

 		In in = new In(file);
 		// get the num of planets/
		int num = in.readInt();
		double radius = in.readDouble();

		Planet[] p = new Planet[num];

		for(int i = 0; i<num;i++){

			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double m = in.readDouble();
			String imgName = in.readString();
			p[i] = new Planet(xPos,yPos,xVel,yVel,m,imgName);
		}

		return p;
 	}

}