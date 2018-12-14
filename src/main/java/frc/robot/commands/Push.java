package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Push extends Command {
    private boolean running = true;
    private Robot _robot;
    public Push(Robot robot) {
        _robot = robot;
    }
    @Override
    protected void initialize() {
        //requires(); To do: Require compressor subsystem 
        requires(_robot.compressorSubsystem);
        _robot.compressorSubsystem.checkPressure();
    }
    
    @Override
    protected void execute() {
        _robot.compressorSubsystem.checkPressure();
        if(_robot.compressorSubsystem.pressure()) {
            _robot.compressorSubsystem.actuateCylinder();
        }
    }
    @Override
    protected void end() {
        _robot.compressorSubsystem.retractCylinder();
        running = false;
    }
    @Override
    protected boolean isFinished() {
        return !running;
    }
}