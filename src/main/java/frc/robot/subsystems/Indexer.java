package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;

public class Indexer extends SubsystemBase {
    public final Victor indexerMotor;

    public Indexer() {
        indexerMotor = new Victor(RobotMap.INDEXER);
        CommandScheduler.getInstance().registerSubsystem(this);
    }

    public void setPower(double power) {
        indexerMotor.set(power);
    }

    public void stop() {
        setPower(0d);
    }
}