package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {
    public Talon leftFront;
    public Talon rightFront;
    public Talon leftRear;
    public Talon rightRear;
    private MecanumDrive myMecanumDrive;
    public DriveSubsystem(Robot robot)
    {
        leftFront = new Talon(RobotMap.leftFront);
        rightFront = new Talon(RobotMap.rightFront);
        leftRear = new Talon(RobotMap.leftRear);
        rightRear = new Talon(RobotMap.rightRear);    
        myMecanumDrive = new MecanumDrive(leftFront, rightFront, leftRear, rightRear);
    }

    public void DriveCartesian(double power, double ySpeed, double xSpeed, double zRotation)
    {
        myMecanumDrive.driveCartesian(ySpeed, xSpeed, zRotation);
    }

    @Override
    protected void initDefaultCommand() {

    }    
}