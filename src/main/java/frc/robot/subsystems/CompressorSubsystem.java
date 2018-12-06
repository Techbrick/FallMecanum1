package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class CompressorSubsystem extends Subsystem {
    private final Compressor m_compressor;
    public CompressorSubsystem(Robot robot){
        m_compressor = new Compressor(RobotMap.cylinder);
        m_compressor.setClosedLoopControl(true);
    }

    public void actuateCylinder() {

    }

    @Override
    protected void initDefaultCommand() {

    }

}