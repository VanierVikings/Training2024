package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;


public class Rotate extends Command{
  private static Drivetrain m_drivetrain;
  private static double angle;

    public Rotate(Drivetrain m_drivetrain, double angle){
      Rotate.m_drivetrain = m_drivetrain;
      Rotate.angle = angle;
      setName("Rotate");
      addRequirements(m_drivetrain);
    }

    @Override
    public void initialize() {
    }
    
    @Override
    public void execute() {
      double rotationalOutput = MathUtil.clamp(m_drivetrain.m_roationalPIDController.calculate(m_drivetrain.getHeadingRelative(), angle), -0.75, 0.75);
      SmartDashboard.putNumber("PID Output", rotationalOutput);
      m_drivetrain.curvatureDrive(0, -rotationalOutput, true);
    }
  
    @Override
    public boolean isFinished() {
      return Math.abs(m_drivetrain.m_roationalPIDController.getPositionError()) < 5;
    }
}