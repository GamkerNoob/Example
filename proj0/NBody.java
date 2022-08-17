public class NBody{
	public static double readRadius(String file){
		In in = new In(file);
		int number_of_planets = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String file){
		In in = new In(file);
		int number_of_planets = in.readInt();
		Planet[] Planets=new Planet[number_of_planets];
		in.readDouble();
		for(int i=0;i<number_of_planets;i++){
			double xxPos=in.readDouble();
			double yyPos=in.readDouble();
			double xxVel=in.readDouble();
			double yyVel=in.readDouble();
			double mass=in.readDouble();
			String imgFileName=in.readString();	
			Planets[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
		}
		return Planets;
	}
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] planets=readPlanets(filename);
		double radius = readRadius(filename);
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0,0,"images/starfield.jpg")	;
		for(int i=0;i<planets.length;i++){
			planets[i].draw();
		}
		StdDraw.enableDoubleBuffering();
		double time = 0;
		int number_of_planets = planets.length;
		while(time < T){
			double[] xForces = new double [number_of_planets];
			double[] yForces = new double [number_of_planets];
			for(int i=0;i<number_of_planets;i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for(int i=0;i<number_of_planets;i++){
				planets[i].update(dt,xForces[i],yForces[i]);
			}
			StdDraw.setScale(-radius, radius);
			StdDraw.picture(0,0,"images/starfield.jpg");
			for(int i=0;i<planets.length;i++){
				planets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time += dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
	}
	
}