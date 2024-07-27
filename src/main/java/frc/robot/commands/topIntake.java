package frc.robot.commands;

import frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.Command;


public class topIntake extends Command{
    Shooter mShooter;

    public topIntake(Shooter shooter){
      mShooter = shooter;
      setName("topIntake");
      addRequirements(shooter);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void end(boolean interrupted) {
      mShooter.stop();
    }

    @Override
    public boolean isFinished() {
      return false;
    }
}
