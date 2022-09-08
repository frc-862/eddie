package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.constants.JoystickConstants;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
    private final Drivetrain drivetrain = new Drivetrain();
    private final Shooter shooter = new Shooter();
    private final Indexer indexer = new Indexer();
    private final Voltage voltage = new Voltage(); //read only

    public final Joystick driverRight = new Joystick(JoystickConstants.Ports.DRIVER_RIGHT);
    public final Joystick driverLeft = new Joystick(JoystickConstants.Ports.DRIVER_LEFT);

    public final XboxController copilot = new XboxController(JoystickConstants.Ports.COPILOT);

    public RobotContainer() {
        configureButtonBindings();
        drivetrain.setDefaultCommand(new TankDrive(drivetrain, () -> -driverRight.getY(), () -> -driverLeft.getY()));
        indexer.setDefaultCommand(new IndexerControl(indexer, () -> copilot.getRightTriggerAxis()-copilot.getLeftTriggerAxis()));
    }

    private void configureButtonBindings() {
        (new JoystickButton(copilot, JoystickConstants.XboxController.BUTTON_A)).whileHeld(new StartEndCommand(shooter::spin, shooter::stop, shooter));
    }
    public Command getAutonomousCommand() { return null; }
}
