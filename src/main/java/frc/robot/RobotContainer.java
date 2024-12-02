
package frc.robot;

import frc.robot.Constants.ControllerConstants;
import frc.robot.subsystems.TurretSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;

public class RobotContainer {
  private final CommandPS5Controller m_joystick;
  private final TurretSubsystem m_turretSubsystem;
  
  public RobotContainer() {
    m_joystick = new CommandPS5Controller(ControllerConstants.JOYSTICK_PORT);
    m_turretSubsystem = new TurretSubsystem();

    configureBindings();
  }

  private void configureBindings() {
    m_joystick.circle().onTrue(m_turretSubsystem.c_setYawAngle(20).until(() -> m_turretSubsystem.getAngle() == 20));
    m_turretSubsystem.setDefaultCommand(m_turretSubsystem.setPitch(m_joystick));
  }

  public CommandPS5Controller getDriverController() {
    return m_joystick;
  }

  /** 
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
