// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

// import org.ironmaple.simulation.seasonspecific.reefscape2025.ReefscapeCoralOnFly.CoralStationsSide;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CoralDrop extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  double coralForwardSpinSpeed = -0.3;
  double coralBackwardSpinSpeed = 0.3;

  private SparkMax coralDropMotor;

  public CoralDrop() {
    coralDropMotor = new SparkMax(Constants.MechanismConstants.kCoralDropCanId, MotorType.kBrushed);    
  }

  public void stopSpin() {
    coralDropMotor.set(0);
  }

  public void forwardSpin(){
    coralDropMotor.set(coralForwardSpinSpeed);
 }

  public void backwardSpin(){
    coralDropMotor.set(coralBackwardSpinSpeed);
 }
  
  public void upForwardCoralSpeedSubsystem(){
    if (coralForwardSpinSpeed > -1) {
      coralForwardSpinSpeed -= 0.1;
    }
}

  public void downForwardCoralSpeedSubsystem(){
    if (coralForwardSpinSpeed < -0.3) {
      coralForwardSpinSpeed += 0.1;
    }
}

  public void upBackwardCoralSpeedSubsystem(){
    if (coralBackwardSpinSpeed < 1.0) {
      coralForwardSpinSpeed += 0.1;
    }
}

  public void downBackwardCoralSpeedSubsystem(){
    if (coralBackwardSpinSpeed > 0.3) {
      coralForwardSpinSpeed -= 0.1;
    }
  }

  public void variableSpin(double spinSpeed){
    coralDropMotor.set(spinSpeed);
  }

  public Command setSpeed(double speed) {
    System.out.println("hello");
    return new InstantCommand(() -> coralDropMotor.set(speed), this);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
