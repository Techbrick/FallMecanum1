package frc.robot.commands;
import RobotMap;
public ArmCommand extends Command{
    public Encoder enc;
    public ArmSubsystem arm;
    public int degrees = 120;
    public int ticksPerDegree = RobotMap.ticksPerDegree;
    public int ticks;
    public Talon motor;
    public ArmCommand(Robot r) {
        enc = r.encode;
        arm = r.ArmSubsystem;
        motor = r.motor; // i assume that a motor will be set in robot class?

    }
    /*
    public rotate(double degrees) {

    }
    */
    @override
    public void init() {
        enc.reset();
    } 
    public void execute() {
        motor.rotate(.5);
        ticks = enc.get();
    }   
    public boolean isfinished(){
        return ticks >= degrees * ticksPerDegree;
    }
    public void end() {
        motor.rotate(0);
    } 
    /* init - get degrees
        execute rotate motor 
        isfinished check if greater or equal ticks on encoder
        end - stop motor
        */  
}