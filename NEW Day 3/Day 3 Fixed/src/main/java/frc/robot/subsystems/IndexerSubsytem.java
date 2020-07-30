/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;  

public class IndexerSubsystem extends SubsystemBase {
  /**
   * Creates a new IndexerSubsystem.
   * 
   */

  private CANSparkmax spark1;
  private CANSparkMax spark2; 
    private TalonSRX talon1;

  public IndexerSubsystem() {
    CANSparkMax spark1 = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax spark2 = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    TalonSRX talon1 = new TalonSRX(2);

    spark2.follow(spark1,true);
    talon1.setNeutralMode(NeutralMode.Coast);
  }

  
  public storeBallUp() {
    spark1.set(-0.8);
    talon1.set(ControlMode.PercentOutput, 0.8);
    talon1.setNeutralMode(NeutralMode.Brake);

  }
  public shootBall() {
    talon1.set(ControlMode.PercentOutput, -0.8);
    talon1.setNeutralMode(NeutralMode.Coast);
  }

  public void setMotors() {
    spark1.set(0);
    talon1.set(ControlMode.PercentOutput, 0);
  }
  @Override
