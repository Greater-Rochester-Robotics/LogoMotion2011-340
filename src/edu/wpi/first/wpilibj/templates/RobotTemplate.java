/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStationLCD.Line;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.DriverStationLCD;

//this is different
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    public static RobotIO myRio = new RobotIO();
    public static HumanIO myHio = new HumanIO();
    public BaseDrive drive = new BaseDrive(myRio,myHio);
    public MiniBot minibot = new MiniBot(myRio,myHio);
    public Gripper gripper = new Gripper(myRio,myHio);
    public RobotArm arm = new RobotArm(myRio, myHio);
    public Autonomous auto = new Autonomous(myRio, drive, arm , gripper );
    public DashboardPacket dash = new DashboardPacket();
    public DriverStationLCD lcd = DriverStationLCD.getInstance();
    public int myInt = 0;
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
        auto.Autonomous2(myRio.getTubeSensorValue()); //TODO: get rid of tube sensor, change to autonomous switch
        dash.updateDash();
        myRio.startCompressor();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic()
    {

        myHio.retrieveValues();
        myRio.retrieveValues();
    //    myHio.updateLCD();
//        myHio.printLCD(Line.kUser2, 0, Double.toString(myRio.getCurrentLeftSpeed()));
//        myHio.printLCD(Line.kUser3, 0, Double.toString(myRio.getCurrentRightSpeed()));
//        myHio.printLCD(Line.kUser2, 0, Double.toString(myRio.getLeftSpeed()));
//        myHio.printLCD(Line.kUser3, 0, Double.toString(myRio.getRightSpeed()));
        myHio.getArmPositionInputs();
        myHio.test();
        myRio.startCompressor();
        minibot.humanDeployAlignment();
        minibot.humanDeployMinibot();
        drive.humanDrive();
        drive.shiftGear();

        lcd.println(DriverStationLCD.Line.kMain6,1,"gyro value:"+myRio.getGyroValue());
        lcd.println(DriverStationLCD.Line.kUser2,1,"Stored gyro"+drive.storedGyro);
        lcd.println(DriverStationLCD.Line.kUser3,1,"gyro Error"+drive.gyroError);
        lcd.println(DriverStationLCD.Line.kUser4,1,"AccelValue"+myRio.getAccelValue());
        lcd.println(DriverStationLCD.Line.kUser5,1,"Encoder Value"+myRio.getArmEncoder());
        lcd.getInstance().updateLCD();


        if(myHio.leftJoy.getRawButton(10))
        {
            drive.goStraight(.3);
        }
        //System.out.println("Arm Encoder Value:"+ myRio.getArmEncoder());
        //System.out.println("Hi");
        arm.humanControl();
       // System.out.println("arm tilt value:" + myRio.getArmTiltUpValue());
        gripper.manual();
        myRio.setValues();
        //System.out.println("Di 1:" + in.get() + " Di 2: " + in2.get());
        dash.updateDash();
        if (myInt >= 10) {
          System.out.println("distVal: " + myRio.getDistVal());
          myInt = 0;
        }
        else {
            myInt ++;
        }

    }
//    public void armTest()
//    {
//        if(myRio.getArm MotorValue() >= 0)
//        {
//            System.out.println("Going Up");
//        }
//    }
}
