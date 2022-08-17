public class Planet{
	private static double G = 6.67e-11;
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}
	public double calcDistance(Planet p){
		double xDis = (this.xxPos - p.xxPos)*(this.xxPos - p.xxPos);
		double yDis = (this.yyPos - p.yyPos)*(this.yyPos - p.yyPos);
		return Math.sqrt(xDis + yDis);
	}
	public double calcForceExertedBy(Planet p){
		double Dis = this.calcDistance(p);
		return this.mass * p.mass * G / (Dis * Dis);
	}
	public double calcForceExertedByX(Planet p){
		double dx = p.xxPos - this.xxPos;
		return this.calcForceExertedBy(p) * dx / this.calcDistance(p);
	}
	public double calcForceExertedByY(Planet p){
		double dy = p.yyPos - this.yyPos;
		return this.calcForceExertedBy(p) * dy / this.calcDistance(p);
	}
	public double calcNetForceExertedByX(Planet[] p){
		double sum = 0;
		for(int i = 0;i < p.length;i++){
			if(this.equals(p[i])){continue;}
			sum += this.calcForceExertedByX(p[i]);
		};
		return sum;
	}
	public double calcNetForceExertedByY(Planet[] p){
		double sum = 0;
		for(int i = 0;i < p.length;i++){
			if(this.equals(p[i])){continue;}
			sum += this.calcForceExertedByY(p[i]);
		};
		return sum;
	}
	public void update(double dt,double fx,double fy){
		double ax = fx / this.mass;
		double ay = fy / this.mass;
		double vx = this.xxVel + ax * dt;
		double vy = this.yyVel + ay * dt;
		double px = this.xxPos + vx * dt;
		double py = this.yyPos + vy * dt;
		this.xxPos = px;
		this.yyPos = py;
		this.xxVel = vx;
		this.yyVel = vy;
	}
	public void draw(){
		StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
	}
}
