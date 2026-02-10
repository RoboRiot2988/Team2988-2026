package frc.robot;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {
    private final DriveSubsystem drive = new DriveSubsystem();
    private final PS4Controller driver = new PS4Controller(0); // USB port 0 on Driver Station

    private static final double MAX_SPEED = 0.9;
    private static final double DEADBAND = 0.06;

    public RobotContainer() {
        configureDefaultCommands();
    }

    private void configureDefaultCommands() {
        drive.setDefaultCommand(
            new RunCommand(
                () -> {
                    // pushing forward typically returns negative Y, so invert
                    double left = -driver.getLeftY();
                    double right = -driver.getRightY();

                    left = applyDeadband(left, DEADBAND) * MAX_SPEED;
                    right = applyDeadband(right, DEADBAND) * MAX_SPEED;

                    drive.tankDrive(left, right);
                },
                drive
            )
        );
    }

    private static double applyDeadband(double value, double deadband) {
        return Math.abs(value) > deadband ? value : 0.0;
    }

    public DriveSubsystem getDrive() {
        return drive;
    }
}
