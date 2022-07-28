package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.*;
public class Drivetrain extends SubsystemBase {
    public Victor left1;
    public Victor left2;

    public Victor right1;
    public Victor right2;

    private ShuffleboardTab demoTab = Shuffleboard.getTab("demo");

	private NetworkTableEntry speedCap = demoTab.add("speed cap", Constants.DEFAULT_SPEED_CAP).getEntry();

    public Drivetrain() {
        left1 = new Victor(RobotMap.LEFT1);
        left2 = new Victor(RobotMap.LEFT2);

        right1 = new Victor(RobotMap.RIGHT1);
        right2 = new Victor(RobotMap.RIGHT2);

        left1.setInverted(Constants.DRIVE_LEFT1_INVERT);
        left2.setInverted(Constants.DRIVE_LEFT2_INVERT);

        right1.setInverted(Constants.DRIVE_RIGHT1_INVERT);
        right2.setInverted(Constants.DRIVE_RIGHT2_INVERT);

        CommandScheduler.getInstance().registerSubsystem(this);
    }

    public void setPower(double rightPower, double leftPower) {
        leftPower *= speedCap.getDouble(Constants.DEFAULT_SPEED_CAP);
        rightPower *= speedCap.getDouble(Constants.DEFAULT_SPEED_CAP);
        left1.set(leftPower);
        right1.set(rightPower);
        left2.set(leftPower);
        right2.set(rightPower);
    }

    public void stop() {
        setPower(0, 0); 
    }
}
