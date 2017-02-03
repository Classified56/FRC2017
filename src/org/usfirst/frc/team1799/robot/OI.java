package org.usfirst.frc.team1799.robot;

import edu.wpi.first.wpilibj.XboxController;
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
	public XboxController pilotDevice;
	double leftStick, rightStick;
	
	public OI(){
		pilotDevice = new XboxController(RobotMap.contollerPort);
	}

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.
	public double[] getYSticks(){
		leftStick = pilotDevice.getY(Hand.kRight);
    	rightStick = pilotDevice.getY(Hand.kLeft);
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
