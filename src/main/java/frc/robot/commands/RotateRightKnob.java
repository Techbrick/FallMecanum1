package frc.robot.commands;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class RotateRightKnob extends Command{
    private boolean running = true;
    /*private Ultrasonic ultra;
    private int distanceFromWall;
    private double initialRange;
    private double k;
    public void MoveToWall(int dist) {
        ultra = new Ultrasonic(RobotMap.rightUltraSonic, RobotMap.rightUltraSonic);
        ultra.setAutomaticMode(true);
        distanceFromWall = dist;
        requires(DriveSubsystem);
        requires(ArmSubsystem);
    }
    public void initialize() {
        initialRange = ultra.getRangeInches();
        //move(power, k);
    }
    public void execute() {
        //move(power, k);
    }
    public boolean isFinished(double k) {
        return (k < 0.01);
    }
    public void move(double power) {
        double range = ultra.getRangeInches();
        if(2 * range < initialRange) {
            k /= 2;
            initialRange = range;
        }
        DriveCartesian(power, 0, k * distanceFromWall, 0);
    }
    public void align() {

    }*/
    @Override
    protected boolean isFinished() {
        return running;
    }
}