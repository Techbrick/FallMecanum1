package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class CompressorSubsystem extends Subsystem {
    private final Compressor compressor;
    private Solenoid solenoid;
    public CompressorSubsystem(Robot robot){
        compressor = new Compressor();
        compressor.setClosedLoopControl(true);
        solenoid = new Solenoid(0);
    }

    public void checkPressure() {
        if(!compressor.getPressureSwitchValue()) {
            compressor.stop();
        } else {
            compressor.start();
        }
    }

    public boolean pressure() {
        return compressor.getPressureSwitchValue();
    }
    
    public void actuateCylinder() {
        solenoid.set(true);
    }

    public void retractCylinder() {
        solenoid.set(false);
    }

    @Override
    protected void initDefaultCommand() {

    }

}