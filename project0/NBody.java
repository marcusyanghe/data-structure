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
 	public static Planet[] readPlanets(String file){

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
    
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("Lack more info. Please supply three argument: t, dt,and a filename.");
            System.out.println("e.g, java NBody 15778800.0 25000.0 data/planets.txt");

            // System.exit ends the program early.
            System.exit(0);
        }
        
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        
        //Read in the planets and the universe radius from the file described by filename
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] p = readPlanets(filename);
        int n = p.length;
        //store the array of netforces
        Double[] netXf = new Double[n];
        Double[] netYf = new Double[n];

        //set the scale of universe according to the radius. The size of window/canvas is 512*512 pixel by default. 
        //The universe pic applied here is also 512*512 pixel
        StdDraw.setScale(-radius, radius);
        //insert the audio file
        StdAudio.play("audio/2001.mid");

        
        //draw each one of the planets in the planets array you created.
        double t = 0;
        while(t<=T){
            //reset the background repeatedly to overpose the one before
            StdDraw.picture(0.0, 0.0, "starfield.jpg");
            for(int i=0;i<n;i++){
                netXf[i] = p[i].calcNetForceExertedByX(p);
                netYf[i] = p[i].calcNetForceExertedByY(p);
                p[i].update(dt,netXf[i],netYf[i]);
        	    p[i].draw();
            }
        	t+=dt;
        }//close while 

    }//close main
}//close class