package org.usfirst.frc.team1799.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	public static int contollerPort = 1;
	public static int leftMotor = 0;
	public static int rightMotor = 1;
	//distance in feet per second at 75% speed
	public static double distancePerSecond = 0.75;
	
	//based off of test of driving straight at 75% speed for five seconds. 
	public static double leftMeasuredSpeed = 1;
	public static double rightMeasuredSpeed = 1;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
