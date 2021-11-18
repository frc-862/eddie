// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  public Victor left1;
  public Victor left2;
  public Victor left3;
  public Victor right1;
  public Victor right2;
  public Victor right3;
  
  /** Creates a new Drivetrain. */
  public Drivetrain() {
    // TODO: temp ID's, ADD LATER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    left1 = new Victor(1);
    left2 = new Victor(2);
    left3 = new Victor(3);
    right1 = new Victor(4);
    right2 = new Victor(5);
    right3 = new Victor(6);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setLeftPower(double pwr){
    left1.set(pwr);
    left2.set(pwr);
    left3.set(pwr);
  }

  public void setRightPower(double pwr){
    right1.set(pwr);
    right2.set(pwr);
    right3.set(pwr);
  }

  public void stop(){
    setLeftPower(0);
    setRightPower(0);  
  }
}
