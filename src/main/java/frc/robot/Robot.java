/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.CompressorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Encoder;
import com.kauailabs.navx.frc.AHRS;

/**
 * This is a sample program that uses mecanum drive with a gyro sensor to
 * maintian rotation vectorsin relation to the starting orientation of the robot
 * (field-oriented controls).
 */
public class Robot extends IterativeRobot {
  // gyro calibration constant, may need to be adjusted;
  // gyro value of 360 is set to correspond to one full revolution
  
  

  //init set port values
  private static final int kFrontLeftChannel = 0;
  private static final int kRearLeftChannel = 1;
  private static final int kFrontRightChannel = 2;
  private static final int kRearRightChannel = 3;
  private static final int kGyroPort = 0;
  private static final int kJoystickPort = 0;

  //declare encoder
  private Encoder enc;
  //declare/init joystick pulling port from listing
  private final Joystick m_joystick = new Joystick(kJoystickPort);
  //declare the gyro variable
  private AHRS navX;

  //subsystems declaration
  public DriveSubsystem driveSubsystem;
  public CompressorSubsystem compressorSubsystem;
  public ArmSubsystem armSubsystem;

  public OI oI;
  /*
   * Initialize bot 
   * TO DO:
   * [?] Drive
   * [-] Hand
   * [-] Pnuematics
   */
  @Override
  public void robotInit() {
    //subsystems init
    oI = new OI(this);
    driveSubsystem = new DriveSubsystem();
    compressorSubsystem = new CompressorSubsystem(this);
    armSubsystem = new ArmSubsystem();
    // init Gyro on the SPI port using the mxp interface on the rio
    navX = new AHRS(SPI.Port.kMXP);
    // Sets pins for the encoder
    enc = new Encoder(8, 9, false, Encoder.EncodingType.k4X);   
    //Limits the period length of the encoder's rotation
    enc.setMaxPeriod(1);

  }

  /*
   *Auto Init/Drive
   * TO DO:
   * [-] All of it
   */
  @Override
  public void autonomousInit() {
    super.autonomousInit();
  }

  @Override
  public void autonomousPeriodic() {
    super.autonomousPeriodic();
  }

  /*
   * Mecanum drive is used with the gyro angle as an input.
   */
  @Override
  public void teleopPeriodic() {
    boolean gyroAlive = navX.isConnected();
    if  (gyroAlive){
      driveSubsystem.DriveCartesian(m_joystick.getX(), m_joystick.getY(), m_joystick.getZ(), navX.getAngle());
    }else {
      //  if the navX is failed then avoid passing an unknown number to the drivetrain.
      driveSubsystem.DriveCartesian(m_joystick.getX(), m_joystick.getY(), m_joystick.getZ(), 0);
    }
  }
}
