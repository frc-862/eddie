package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.*;

public class Shooter extends SubsystemBase {
    private final Victor shooterMotor;

    private ShuffleboardTab demoTab = Shuffleboard.getTab("demo");

	private NetworkTableEntry flywheelPower = demoTab.add("flywheel speed", Constants.DEFAULT_SHOOTER_POWER).getEntry();
    
    public Shooter() {
        shooterMotor = new Victor(RobotMap.SHOOTER);
        CommandScheduler.getInstance().registerSubsystem(this);
    }

    public void spin() {
        shooterMotor.set(flywheelPower.getDouble(Constants.DEFAULT_SHOOTER_POWER));
    }

    public void stop() {
        shooterMotor.set(0d);
    }
}
