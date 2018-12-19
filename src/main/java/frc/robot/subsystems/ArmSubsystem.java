package frc.robot.subsystems;

<<<<<<< HEAD
import edu.wpi.first.wpilibj.command.Subsystem;
=======
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
>>>>>>> 8d00735d00d10fdc9ef5de70505eea7c977a33e9

//import edu.wpi.first.wpilibj.command.Subsystem;
// download wpilib 
// extensions, wpilib, install (if not, go to wpilib.screensteps)
// click fork, add changes to stage, message, check mark, triple dot, sync. 
public class ArmSubsystem extends Subsystem {
<<<<<<< HEAD
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
        
=======
    private TalonSRX talon;
    private Encoder encoder;

    private int ticksPerRevolution = 4096;
    public ArmSubsystem()
    {
        encoder = new Encoder(8, 9, false, Encoder.EncodingType.k4X);  
        talon = new TalonSRX(42); 
    }

    public void resetEncoder()
    {
        encoder.reset();
>>>>>>> 8d00735d00d10fdc9ef5de70505eea7c977a33e9
    }
    @override
    public boolean isFinished() {

<<<<<<< HEAD
    }
    @override
    public void end() {
=======
    public float getEncoderAngle()
    {
        return encoder.get() * 360 / ticksPerRevolution;
    }

    public int getEncoderTicks()
    {
        return encoder.get();
    }
>>>>>>> 8d00735d00d10fdc9ef5de70505eea7c977a33e9

    public void setTalon(float percentPower)
    {
        talon.set(ControlMode.PercentOutput, percentPower);
    }
    public int test() {
        enc.reset();
        enc.get();
        motor.
    }
    public void rotate(double speed) {
        motor.set(speed);
    }

    @Override
    protected void initDefaultCommand() 
    {

    }
}