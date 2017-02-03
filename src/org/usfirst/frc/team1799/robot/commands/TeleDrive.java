package org.usfirst.frc.team1799.robot.commands;

import org.usfirst.frc.team1799.robot.Robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class TeleDrive extends Command{
	private double[] sticks;
	
	public TeleDrive(){
		requires(Robot.tankDrive);
	}
	
	// Called just before this Command runs the first time
    protected void initialize() {
    	sticks = Robot.oi.getYSticks();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	sticks = Robot.oi.getYSticks();
    	Robot.tankDrive.drive(sticks[0], sticks[1]);
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
