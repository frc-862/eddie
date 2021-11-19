// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class Drivetrain extends SubsystemBase {

    public Victor left1;
    public Victor left2;

    public Victor right1;
    public Victor right2;
    
    /** Creates a new Drivetrain. */
    public Drivetrain() {
        left1 = new Victor(3);
        left2 = new Victor(1);

        right1 = new Victor(2);
        right2 = new Victor(4);
        right1.setInverted(true);
        right2.setInverted(true);
    }

    @Override
    public void periodic() {}

    public void setPower(double right, double left) {
        left1.set(left);
        left2.set(left);
        
        right1.set(right);
        right2.set(right);
    }

    public void stop() {
        setPower(0, 0); 
    }

}
