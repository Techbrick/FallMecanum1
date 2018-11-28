/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import com.kauailabs.navx.*;
import com.kauailabs.navx.frc.AHRS;

/**
 * This is a sample program that uses mecanum drive with a gyro sensor to
 * maintian rotation vectorsin relation to the starting orientation of the robot
 * (field-oriented controls).
 */
public class Robot extends IterativeRobot {
  // gyro calibration constant, may need to be adjusted;
  // gyro value of 360 is set to correspond to one full revolution
  

  private static final int kFrontLeftChannel = 0;
  private static final int kRearLeftChannel = 1;
  private static final int kFrontRightChannel = 2;
  private static final int kRearRightChannel = 3;
  private static final int kGyroPort = 0;
  private static final int kJoystickPort = 0;

  private MecanumDrive m_robotDrive;
  
  private final Joystick m_joystick = new Joystick(kJoystickPort);
  // set the gyro variable
  private AHRS navX;

  @Override
  public void robotInit() {
    Talon frontLeft = new Talon(kFrontLeftChannel);
    Talon rearLeft = new Talon(kRearLeftChannel);
    Talon frontRight = new Talon(kFrontRightChannel);
    Talon rearRight = new Talon(kRearRightChannel);

    // Invert the left side motors.
    // You may need to change or remove this to match your robot.
    frontLeft.setInverted(true);
    rearLeft.setInverted(true);
    // init Gyro on the SPI port using the mxp interface on the rio
    navX = new AHRS(SPI.Port.kMXP);
    
    m_robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

    
  }

  /**
   * Mecanum drive is used with the gyro angle as an input.
   */
  @Override
  public void teleopPeriodic() {
    boolean gyroAlive = navX.isConnected();
    if  (gyroAlive){
      m_robotDrive.driveCartesian(m_joystick.getX(), m_joystick.getY(),
        m_joystick.getZ(), navX.getAngle());
    }else {
      //  if the navX is failed then avoid passing an unknown number to the drivetrain.
      m_robotDrive.driveCartesian(m_joystick.getX(), m_joystick.getY(),
        m_joystick.getZ(), 0);
    }
    // Tony does Git
    
  }
}
