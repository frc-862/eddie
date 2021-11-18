// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.IndexerControl;
import frc.robot.commands.ShooterControl;
import frc.robot.commands.TankDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final Drivetrain drivetrain = new Drivetrain();
    private final Shooter shooter = new Shooter();
    private final Indexer indexer = new Indexer();

    private static final Joystick driverLeft = new Joystick(0);
    private static final Joystick driverRight = new Joystick(1);


    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();
        //Standard tank drive bindings
        drivetrain.setDefaultCommand(new TankDrive(drivetrain, driverRight.getY(), driverLeft.getY()));
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        //Right flight stick trigger to spin shooter
        (new JoystickButton(driverRight, 1)).whileHeld(new ShooterControl(shooter, 1));

        //Left fligt stick trigger to run indexer
        (new JoystickButton(driverLeft, 1)).whileHeld(new IndexerControl(indexer, 1));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return null;
    }
}
