package frc.robot.commands;
import RobotMap;
public ArmCommand extends Command{
    public Encoder enc;
    public ArmSubsystem arm;
    public int ticksPerDegree = RobotMap.ticksPerDegree;
    public ArmCommand(Robot r) {
        enc = r.encode;
        arm = r.ArmSubsystem;

    }
    public rotate(double degrees) {
        
    }

    /* init - get degrees
        execute rotate motor 
        isfinished check if greater or equal ticks on encoder
        end - stop motor
        */  
}