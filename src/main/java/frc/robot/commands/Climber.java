package frc.robot.commands;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;

public class Climber {
      public static Command moveLeftClimberUp() {
    return new RunCommand(
      () -> RobotContainer.m_ClimbL.moveLeftClimbUp(),
      RobotContainer.m_ClimbL
    );
  }

    public static Command moveLeftClimberDown() {
    return new RunCommand(
      () -> RobotContainer.m_ClimbL.moveLeftClimbDown(),
      RobotContainer.m_ClimbL
    );
  }

  public static Command stopClimberLeft() {
    return new RunCommand(
      () -> RobotContainer.m_ClimbL.stopClimb(),
      RobotContainer.m_ClimbL
    );
  }

  public static Command moveRightClimberUp() {
    return new RunCommand(
      () -> RobotContainer.m_ClimbR.moveRightClimbUp(),
      RobotContainer.m_ClimbR
    );
  }

    public static Command moveRightClimberDown() {
    return new RunCommand(
      () -> RobotContainer.m_ClimbR.moveRightClimbDown(),
      RobotContainer.m_ClimbR
    );
  }

  public static Command stopClimberRight() {
    return new RunCommand(
      () -> RobotContainer.m_ClimbR.stopClimb(),
      RobotContainer.m_ClimbR
    );
  }
}
