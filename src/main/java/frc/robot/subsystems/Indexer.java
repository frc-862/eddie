// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {
    public final Victor indexerMotor;

    public Indexer() {
        indexerMotor = new Victor(5);
    }

    @Override
    public void periodic() {}

    public void setPower(double power) {
        indexerMotor.set(power);
    }

    public void stop() {
        setPower(0);
    }
    
}
