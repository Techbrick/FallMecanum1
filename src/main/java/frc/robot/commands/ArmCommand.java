package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.ArmSubsystem;

public class ArmCommand extends Command{
    private ArmSubsystem arm;
    private int degrees;
    public ArmCommand(Robot r, int d) {
        arm = r.armSubsystem;
        degrees = d;
    }
    /*
    public rotate(double degrees) {

    }
    */
    @Override
    public void initialize() {
        arm.resetEncoder();
    }

    @Override
    public void execute() {
        arm.setTalon(1);
    }
    @Override   
    public boolean isFinished(){
        return arm.getEncoderAngle() >= degrees;
    }
    @Override
    public void end() {
        arm.setTalon(0);
    } 
    /* init - get degrees
        execute rotate motor 
        isfinished check if greater or equal ticks on encoder
        end - stop motor
        */  
}