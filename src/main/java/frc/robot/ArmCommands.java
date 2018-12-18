package frc.robot.subsystem;
public class ArmCommands extends subsystem{
    Robot robo;
    Encoder enc;
    Talon motor;
    @override
    public void init(Robot robot) {
        robo = robot;
        enc = robo.enc;
        motor = ; // get the motor from armSubsystem
        int ticks;
        int degrees = 120;
        enc.reset();
    }
    @override
    public void execute() {
        //talon.set
        motor.rotate(.5);
        ticks = enc.get();
    }
    @override
    public boolean isFinished() {
        //check encoder ticks
        return ticks >= 120 * ticksPerDegree;
    }
    @override
    public void end() {
        //set to 0?
        motor.rotate(0);
    }
}