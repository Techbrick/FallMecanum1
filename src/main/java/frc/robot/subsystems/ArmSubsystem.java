package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;

public class ArmSubsystem extends Subsystem {
    private TalonSRX talon;
    private Encoder encoder;
    private int ticksPerRevolution;
    public ArmSubsystem()
    {
        encoder = new Encoder(8, 9, false, Encoder.EncodingType.k4X);  
        talon = new TalonSRX(0); 
    }

    public void resetEncoder()
    {
        encoder.reset();
    }

    public float getEncoderAngle()
    {
        return encoder.get() * 360 / ticksPerRevolution;
    }

    public void setTalon(float percentPower)
    {
        talon.set(ControlMode.PercentOutput, percentPower);
    }

    @Override
    protected void initDefaultCommand() 
    {

    }

}