package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    // TODO: replace these CAN IDs with your actual Spark Max CAN IDs
    private static final int LEFT_FRONT_ID  = 1;
    private static final int LEFT_MID_ID    = 2;
    private static final int LEFT_REAR_ID   = 3;
    private static final int RIGHT_FRONT_ID = 4;
    private static final int RIGHT_MID_ID   = 5;
    private static final int RIGHT_REAR_ID  = 6;

    private final CANSparkMax leftFront  = new CANSparkMax(LEFT_FRONT_ID, MotorType.kBrushless);
    private final CANSparkMax leftMid    = new CANSparkMax(LEFT_MID_ID, MotorType.kBrushless);
    private final CANSparkMax leftRear   = new CANSparkMax(LEFT_REAR_ID, MotorType.kBrushless);
    private final CANSparkMax rightFront = new CANSparkMax(RIGHT_FRONT_ID, MotorType.kBrushless);
    private final CANSparkMax rightMid   = new CANSparkMax(RIGHT_MID_ID, MotorType.kBrushless);
    private final CANSparkMax rightRear  = new CANSparkMax(RIGHT_REAR_ID, MotorType.kBrushless);

    private final MotorControllerGroup leftGroup  = new MotorControllerGroup(leftFront, leftMid, leftRear);
    private final MotorControllerGroup rightGroup = new MotorControllerGroup(rightFront, rightMid, rightRear);

    private final DifferentialDrive drive = new DifferentialDrive(leftGroup, rightGroup);

    public DriveSubsystem() {
        // Invert right side commonly required; bench-test and adjust.
        rightGroup.setInverted(true);
        drive.setSafetyEnabled(true);
    }

    /** Tank drive: left and right values [-1..1]. */
    public void tankDrive(double left, double right) {
        drive.tankDrive(left, right);
    }

    @Override
    public void periodic() {
        // telemetry or periodic tasks here
    }
}
