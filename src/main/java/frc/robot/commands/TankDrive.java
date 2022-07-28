package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {
    Drivetrain drivetrain;
    DoubleSupplier left;
    DoubleSupplier right;

    public TankDrive(Drivetrain drivetrain, DoubleSupplier right, DoubleSupplier left) {
        addRequirements(drivetrain);
        this.drivetrain = drivetrain;
        this.left = right;
        this.right = left;
    }

    @Override
    public void execute() {
        drivetrain.setPower(right.getAsDouble(), left.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}