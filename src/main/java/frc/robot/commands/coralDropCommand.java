package frc.robot.commands;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CoralDrop;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;

public class coralDropCommand {
      public static Command frontSpin() {
    return new RunCommand(
      () -> RobotContainer.m_CoralDrop.forwardSpin(),
      RobotContainer.m_CoralDrop
    );
  }

    public static Command backSpin() {
    return new RunCommand(
      () -> RobotContainer.m_CoralDrop.backwardSpin(),
      RobotContainer.m_CoralDrop
    );
  }

  public static Command stopSpin() {
    return new RunCommand(
      () -> RobotContainer.m_CoralDrop.stopSpin(),
      RobotContainer.m_CoralDrop
    );
  }

  public static Command upForwardCoralSpeedCommand() {
    return new RunCommand(
      () -> RobotContainer.m_CoralDrop.upForwardCoralSpeedSubsystem(),
      RobotContainer.m_CoralDrop
    );
  }

  public static Command downForwardCoralSpeedCommand() {
    return new RunCommand(
      () -> RobotContainer.m_CoralDrop.downForwardCoralSpeedSubsystem(),
      RobotContainer.m_CoralDrop
    );
  }

  public static Command upBackwardCoralSpeedCommand() {
    return new RunCommand(
      () -> RobotContainer.m_CoralDrop.upBackwardCoralSpeedSubsystem(),
      RobotContainer.m_CoralDrop
    );
  }

  public static Command downBackwardCoralSpeedCommand() {
    return new RunCommand(
      () -> RobotContainer.m_CoralDrop.downBackwardCoralSpeedSubsystem(),
      RobotContainer.m_CoralDrop
    );
  }

}