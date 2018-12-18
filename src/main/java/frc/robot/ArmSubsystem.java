package frc.robot.subsystems;
//import edu.wpi.first.wpilibj.command.Subsystem;
// download wpilib 
// extensions, wpilib, install (if not, go to wpilib.screensteps)
// click fork, add changes to stage, message, check mark, triple dot, sync. 
public class ArmSubsystem extends Subsystem{
    Robot _robot;
    Encoder enc;
    Talon motor;
    int ticksPerRev = 0;
    public ArmSubsystem(Robot robot) {
        _robot = robot;
        enc = new Encoder(8, 9, false, Encoder.EncodingType.k4X);
        enc.setMaxPeriod(1);
        motor = new Talon(portnumberhere);

    }
    @override
    public void execute() {
        
    }
    @override
    public boolean isFinished() {

    }
    @override
    public void end() {

    }
    public int test() {
        enc.reset();
        enc.get();
        motor.
    }
    public void rotate(double speed) {
        motor.set(speed);
    }
}