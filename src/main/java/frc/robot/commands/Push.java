package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.CompressorSubsystem;

public class Push extends Command{
    private boolean running = true;
    private Robot _robot;
    public Push(Robot robot) {
        _robot = robot;
    }
    @Override
    protected void initialize() {
        //requires(); To do: Require compressor subsystem 
        requires(_robot.compressorSubsystem);
    }
    
    @Override
    protected void execute() {
        

    }
    @Override
    protected boolean isFinished() {
        return !running;
    }
}