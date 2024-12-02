package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.EncoderConstants;

public class SwerveSubsystem extends SubsystemBase {
  private Encoder m_encoder;
  public SwerveSubsystem() {
    m_encoder = new Encoder(EncoderConstants.ENCODER_CHANNEL_A, EncoderConstants.ENCODER_CHANNEL_B);
  }

  public int getAngle() {
    return m_encoder.get();
  }

  public Command displayAngle() {
    return this.run(() -> {
      SmartDashboard.putNumber("encoder reading", m_encoder.get());
    });
  }

  @Override
  public void periodic() {
  }
}
