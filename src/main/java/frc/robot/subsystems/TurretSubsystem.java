package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import edu.wpi.first.units.Angle;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.Constants.TurretConatants;

public class TurretSubsystem extends SubsystemBase {
  private Servo m_yaw, m_pitch;

  public TurretSubsystem() {
    m_yaw = new Servo(TurretConatants.YAW_SERVO_PORT);
    m_pitch = new Servo(TurretConatants.PITCH_SERVO_PORT);
  }

  public void setYawAngle(DoubleSupplier angle) {
    m_yaw.setAngle(angle.getAsDouble() * 90 + 90);

    m_yaw.setAngle(0);
  }

  public void setYawAngle(double angle) {
    m_yaw.setAngle(angle);
  }
  
  public void setRawYaw(double rawAngle) {
    m_yaw.set(rawAngle);
  }

  public Command setPitch(CommandPS5Controller joystick) {
    return this.run(() -> {
      double normalizeInput = normalize(joystick.getLeftX());
      SmartDashboard.putNumber("Joystick Value", joystick.getLeftX());
      SmartDashboard.putNumber("Normalized Value", normalizeInput);

      setRawYaw(normalizeInput);
    });
  }

  public Command c_setYawAngle(double angle) {
    return this.runOnce(() -> setYawAngle(angle));
  }

  public double getAngle() {
    return m_yaw.getAngle();
  }



  // Daniel {foo() -> 1} Daniel daniel || bar(Function a) || bar(daniel::foo) || bar(() -> daniel.foo())

  private double normalize(double value) {
    return (value + 1) * 0.5;
  }
  
  
    // public Command setYaw(DoubleSupplier angle) {
    //   return this.runOnce(() -> setYawAngle(angle));
    // }
  // public Command setPitch(DoubleSupplier angle) {
  //   return this.runOnce(() -> setPitchAngle(angle));
  // }

  
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Current Angle", m_yaw.getAngle());
  }
}
