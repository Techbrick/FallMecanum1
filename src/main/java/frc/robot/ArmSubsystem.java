package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

public class ArmSubsystem extends Command {
    private Encoder enc;
    private int ticksPerDegree = 4098;
    public ArmSubsystem() {
        enc = new Encoder(8, 9, false, Encoder.EncodingType.k4X); 
    }
    public void rotate(double degrees) {

    }

    @Override
    public boolean isFinished()
    {
        return true;
    }
}