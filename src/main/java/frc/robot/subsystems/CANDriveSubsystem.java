// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.DriveConstants.*;

public class CANDriveSubsystem extends SubsystemBase {
  private final SparkMax leftLeader;
  private final SparkMax leftFollower;
  private final SparkMax rightLeader;
  private final SparkMax rightFollower;

  private final DifferentialDrive drive;

  public CANDriveSubsystem() {
    // 1. Initialize Motors
    // Note: Ensure kBrushed is correct for your physical motors (e.g., NEOs are kBrushless)
    leftLeader = new SparkMax(LEFT_LEADER_ID, MotorType.kBrushed);
    leftFollower = new SparkMax(LEFT_FOLLOWER_ID, MotorType.kBrushed);
    rightLeader = new SparkMax(RIGHT_LEADER_ID, MotorType.kBrushed);
    rightFollower = new SparkMax(RIGHT_FOLLOWER_ID, MotorType.kBrushed);

    // 2. Create Configurations
    SparkMaxConfig leaderConfig = new SparkMaxConfig();
    SparkMaxConfig followerConfig = new SparkMaxConfig();

    // Set common settings for leaders
    leaderConfig
        .voltageCompensation(12)
        .smartCurrentLimit(DRIVE_MOTOR_CURRENT_LIMIT);

    // 3. Apply settings to Right Leader
    rightLeader.configure(leaderConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    // 4. Apply settings to Left Leader (Inverted)
    leaderConfig.inverted(true);
    leftLeader.configure(leaderConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    // 5. Setup Followers
    // We reuse the leader settings (current limits, etc.) but add the follow command
    followerConfig
        .voltageCompensation(12)
        .smartCurrentLimit(DRIVE_MOTOR_CURRENT_LIMIT);

    followerConfig.follow(leftLeader);
    leftFollower.configure(followerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    followerConfig.follow(rightLeader);
    rightFollower.configure(followerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    // 6. Initialize Differential Drive
    drive = new DifferentialDrive(leftLeader, rightLeader);
  }

  @Override
  public void periodic() {
    // Periodic code here
  }

  public void driveArcade(double xSpeed, double zRotation) {
    drive.arcadeDrive(xSpeed, zRotation);
  }
}