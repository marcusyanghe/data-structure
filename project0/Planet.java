
public class Planet {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	
	public Planet(double xP, double yP, double xV,
            double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	};

    public Planet(Planet p){
    	xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
    }

    //Hint: In Java, there is no built in operator that does squaring or exponentiation. Just simply multiplying a symbol by itself 
    // instead of using Math.pow, which will result in slower code.

    public double calcDistance(Planet p){
    	double res = (xxPos - p.xxPos)*(xxPos - p.xxPos)+(yyPos - p.yyPos)*(yyPos - p.yyPos);
    	double dis = Math.sqrt(res);
    	return dis;
    }

 	// get the pairwise force exerted by Planet p;
	public double calcForceExertedBy(Planet p){
		double distance = this.calcDistance(p);

		double force = 6.67e-11 * this.mass * p.mass / distance / distance;
		return force;
	}

    // get the directional force on X direction exerted by Planet p;
	//Direction: right, and up are positive respectively; left and down are negative respectively;
	public double calcForceExertedByX(Planet p){
		double distance = this.calcDistance(p);
		double force = this.calcForceExertedBy(p);
		double dx = p.xxPos -this.xxPos;
		double x = force * dx / distance;
 		return x;
	}

    // get the directional force on y direction exerted by Planet p;
	public double calcForceExertedByY(Planet p){
		double distance = this.calcDistance(p);
		double force = this.calcForceExertedBy(p);
		double dy = p.yyPos - this.yyPos;
		double y = force * dy / distance;
 		return y;
	}

	// calculate the net X force exerted by all planets. 
	//And remember that Planets cannot exert gravitational forces on themselves
	public double calcNetForceExertedByX(Planet[] p){
		//if(p.length == 0) return 0;
		double net =0;
     	for(int i =0; i<p.length; i++){
     			if(!this.equals(p[i])){
  					net += this.calcForceExertedByX(p[i]);
     			}
     	}
     		return net;
	}

	// calculate the net Y force exerted by all planets. 
	public double calcNetForceExertedByY(Planet[] p){
		//if(p.length == 0) return 0;
		double net =0;
     	for(int i =0; i<p.length; i++){
     			if(!this.equals(p[i])){
  					net += this.calcForceExertedByY(p[i]);
     			}
     	}
     		return net;
	}

	//determines how much the forces exerted on the planet will cause that planet to accelerate,
	// and the resulting change in the planet's velocity and position in a small period of time dt.
	public void update(double time, double netFx, double netFy){
			xxVel += time * netFx / mass;
			yyVel += time * netFy / mass;
			xxPos += time * xxVel;
			yyPos += time * yyVel;

	}

	public void draw( ){
		StdDraw.picture(this.xxPos,this.yyPos,this.imgFileName);
	}


}





