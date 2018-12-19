package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArmCommands extends Command {
    Robot robo;
    int ticks = 0;
    double rev = 1/3;
    public ArmCommands(Robot robot) {
        robo = robot;
        requires(robo.armSubsystem);
        robo.armSubsystem.resetEncoder();
    }
    @Override
    public void execute() {
        //talon.set
        robo.armSubsystem.rotate(.5);
        ticks = robo.armSubsystem.getTicks();
    }
    @Override
    public boolean isFinished() {
        //check encoder ticks
        return ticks >= (rev * robo.armSubsystem.ticksPerRev);
    }
    @Override
    public void end() {
        //set to 0?
        robo.armSubsystem.rotate(0);
    }
}