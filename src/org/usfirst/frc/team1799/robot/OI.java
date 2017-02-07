package org.usfirst.frc.team1799.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import static java.lang.Math.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	//public static final GenericHID.RumbleType kLeftRumble;
	private static XboxController pilotDevice;
	//true is arcade drive
	public static boolean driveStyle;
	
	
	public OI(){
		pilotDevice = new XboxController(RobotMap.contollerPort);
		driveStyle = false;
	}

	public double[] getSticks(){
		SmartDashboard.putBoolean("DriveStyle", driveStyle);
		
		double leftStick = driveStyle ? pilotDevice.getX(Hand.kLeft) : pilotDevice.getY(Hand.kRight);
    	double rightStick = pilotDevice.getY(Hand.kLeft);
    	double[] sticks = filterSticks(leftStick, rightStick);
    	if(getStraight() && !driveStyle){
    		double ave = (sticks[0] + sticks[1]) / 2.0;
    		sticks[0] = ave;
    		sticks[1] = ave;
    	}
		return sticks;
	}
	
	private double[] filterSticks(double leftStick, double rightStick){
		if(leftStick >= 0)
    		leftStick = leftStick < 0.98 ? (exp((E/2.0)*pow(leftStick, 1.5))-1)/E:1.0;
    	else
    		leftStick = leftStick > -0.98 ? -(exp((E/2.0)*pow(-leftStick, 1.5))-1)/E:-1.0;
    	if(rightStick >= 0)
    		rightStick = rightStick < 0.98 ? (exp((E/2.0)*pow(rightStick, 1.5))-1)/E : 1.0;
    	else
    		rightStick = rightStick > -0.98 ? -(exp((E/2.0)*pow(-rightStick, 1.5))-1)/E:-1.0;
    	double[] sticks = {leftStick, rightStick};
    	return sticks;
	}
	
	private boolean getStraight(){
		double trigger = pilotDevice.getTriggerAxis(Hand.kRight);
		SmartDashboard.putNumber("Trigger", trigger);
		return .8 < trigger;
	}
	
	public static void checkDriveStyle(){
		if(pilotDevice.getStartButton())
			driveStyle = !driveStyle;
	}
	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:
	
//	public void turnOnRumble(){
//		pilotDevice.setRumble(kLeftRumble, 1);
//	}
	
	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
