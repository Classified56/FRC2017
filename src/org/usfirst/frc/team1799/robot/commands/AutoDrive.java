package org.usfirst.frc.team1799.robot.commands;

import org.usfirst.frc.team1799.robot.Robot;
//import org.usfirst.frc.team1799.robot.subsystems.DriveTrain;

//import edu.wpi.first.wpilibj.AnalogGyro;
//import edu.wpi.first.wpilibj.PIDController;
//import edu.wpi.first.wpilibj.PIDSource;
//import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {
	//private PIDController pidLoop;
	private double distance;
	
	public AutoDrive(double distance) {
		requires(Robot.tankDrive);
	}
	// Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
