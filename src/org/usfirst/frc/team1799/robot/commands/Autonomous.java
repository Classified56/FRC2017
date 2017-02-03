package org.usfirst.frc.team1799.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {
	public Autonomous() {
		addSequential(new AutoDrive(0));
	}

}
