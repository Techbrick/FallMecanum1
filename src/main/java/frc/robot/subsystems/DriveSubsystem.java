package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {
    //hold mechanum drive system in mem
    private MecanumDrive mecanumDrive;
    //intialize subsystem object
    public DriveSubsystem(){   
        //Initialize talons locally (MechanumDrive obj stores clone)
        Talon leftFront = new Talon(RobotMap.leftFront);
        Talon rightFront = new Talon(RobotMap.rightFront);
        Talon leftRear = new Talon(RobotMap.leftRear);
        Talon rightRear = new Talon(RobotMap.rightRear);
        //Invert motor controllers if necessary
        rightFront.setInverted(true);
        leftFront.setInverted(true);
        //initialize Mdrive
        mecanumDrive = new MecanumDrive(leftFront, rightFront, leftRear, rightRear);
    }
    //call drive controller from higher levels/pass to lower
    public void DriveCartesian(double power, double ySpeed, double xSpeed, double zRotation){
        mecanumDrive.driveCartesian(ySpeed, xSpeed, zRotation);
    }
    @Override
    protected void initDefaultCommand() {
        //no default command
    }    
}