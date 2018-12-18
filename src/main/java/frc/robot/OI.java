package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.commands.*;

public class OI
{
    Joystick joystick = new Joystick(0);
    Button rotat = new JoystickButton(joystick, 5);
    public OI(Robot r)
    {
        rotat.whenPressed(new ArmCommand(r.armSubsystem, 120));
    }
}