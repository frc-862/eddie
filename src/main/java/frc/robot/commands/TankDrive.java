// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {
    Drivetrain drivetrain;
    double left;
    double right;

    /** Creates a new TankDrive. */
    public TankDrive(Drivetrain drivetrain, double left, double right) {
        addRequirements(drivetrain);
        this.drivetrain = drivetrain;
        this.left = left;
        this.right = right;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        drivetrain.setPower(left, right);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        drivetrain.setPower(left, right);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        drivetrain.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
