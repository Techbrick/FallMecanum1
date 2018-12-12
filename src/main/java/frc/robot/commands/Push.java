package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.CompressorSubsystem;

public class Push extends Command{
    private boolean running = true;
    @Override
    protected void initialize() {
        //requires(); To do: Require compressor subsystem 
    }
    
    @Override
    protected void execute() {
        super.execute();
    }
    
    @Override
    protected boolean isFinished() {
        return !running;
    }
}