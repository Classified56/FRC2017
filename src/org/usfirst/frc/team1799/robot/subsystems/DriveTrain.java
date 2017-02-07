package org.usfirst.frc.team1799.robot.subsystems;

import org.usfirst.frc.team1799.robot.RobotMap;
import org.usfirst.frc.team1799.robot.commands.TeleDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {
	private SpeedController leftMotor = new Spark(RobotMap.leftMotor);
	private SpeedController rightMotor = new Spark(RobotMap.rightMotor);
	private RobotDrive drive = new RobotDrive(leftMotor, rightMotor);
	
	public static AnalogGyro gyro = new AnalogGyro(1);
	
	
	public DriveTrain(){
		LiveWindow.addActuator("Drive Train", "Left Motor", (Spark) leftMotor);
		LiveWindow.addActuator("Drive Train", "Right Motor", (Spark) rightMotor);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TeleDrive());
		
	}
	
	public void tankDrive(double left, double right) {
		rightMotor.setInverted(false);
		drive.tankDrive(left, right);
		
		SmartDashboard.putNumber("Left Speed", left);
		SmartDashboard.putNumber("Right Speed", right);
	}
	
	public void arcadeDrive(double y, double x){
		rightMotor.setInverted(true);
		drive.arcadeDrive(y, x);
		
		SmartDashboard.putNumber("Speed", y);
		SmartDashboard.putNumber("Direction", x);
	}
}
