/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import  edu.wpi.first.wpilibj.Timer;
/**
 *
 * @author programmers
 */
public class BaseDrive {
    private RobotIO rIO;
    private HumanIO hIO;
    private Timer MyTimer;
    private static double timeValue,distValue;
    private static boolean start, done;
    private final double LEFT_MULT_AUTO = .95;
    private final int LEFT_MULT = 1;
    private final int RIGHT_MULT = -1;

    private double currentSpeed;
    private double error;
    private boolean gyroInit;
    public double storedGyro;
    public double gyroError;
    
    /**
     * References to RobotIO and HumanIO so they can be used in RobotArm Class
     * @param rIO
     * @param hIO
     */
    public BaseDrive(RobotIO rIO, HumanIO hIO)
    {
        this.rIO = rIO;
        this.hIO = hIO;
        MyTimer = new Timer();
        start = false;
        done = false;
        gyroInit = false;
    }

    public void go(double speed, double dir){
        this.setLeftSpeed( (speed*LEFT_MULT)- dir);
        this.setRightSpeed( (speed*RIGHT_MULT) + dir);
    }

    public void goAuto(double speed, double dir){
        this.setLeftSpeed( (speed*LEFT_MULT_AUTO)+ dir);
        this.setRightSpeed( (speed*RIGHT_MULT) - dir);
    }

    public void goStraight(double speed) {
        if(gyroInit = false) {
            storedGyro = rIO.getGyroValue();
            gyroInit = true;
            gyroError = 0;
        }
        else {
            gyroError = storedGyro - rIO.getGyroValue();
        }
        this.go(speed, gyroError*.008);
     }

    public void humanDrive(){
        if(hIO.driveInvert()){
            this.setLeftSpeed((-1 * hIO.getRightJoyY()));
            this.setRightSpeed(1 * hIO.getLeftJoyY());
        }
        /*TODO: Make ThirdSpeed work*/
        //else if(hIO.thirdSpeed(hIO.THIRD_SPEED))
        //{
            //this.setLeftSpeed((-1 * hIO.getRightJoyY()));
            //this.setRightSpeed(1 * hIO.getLeftJoyY());
        //}
        else{
            this.setLeftSpeed(1 * hIO.getLeftJoyY());
            this.setRightSpeed(-1 * hIO.getRightJoyY());
        }


//       if(hIO.getSpinTubeUpButton())
//          this.go(.25,.5);
//       if(hIO.getSpinTubeDownButton())
//         this.go(-.25,-.5);

   }
   public void shiftGear()
   {
        if(hIO.getShiftButton()||hIO.getShiftButton2())
            rIO.changeGears(false); // low gear
        else
            rIO.changeGears(true); // high gear
   }

      public void autoShiftGear(boolean t)
   {
        rIO.changeGears(t); //true = high, false = low
   }
   public boolean TimedGo(double speed, double dir, double goTime){
        if(start == false){
            MyTimer.reset();
            MyTimer.start();
            timeValue = goTime;
            go(speed, dir);
            done = false;
            start = true;
            System.out.println(" Going ");
        }
        else{
            if(MyTimer.get()>=timeValue){
                MyTimer.stop();
                MyTimer.reset();
                go(0,0);
                done = true;
                start = false;
                System.out.println(" stop ");
            }
        }
        return done;
   }

      public boolean TimedGoAuto(double speed, double dir, double goTime){
        if(start == false){
            MyTimer.reset();
            MyTimer.start();
            timeValue = goTime;
            goAuto(speed, dir);
            done = false;
            start = true;
            System.out.println(" Going ");
        }
        else{
            if(MyTimer.get()>=timeValue){
                MyTimer.stop();
                MyTimer.reset();
                goAuto(0,0);
                done = true;
                start = false;
                System.out.println(" stop ");
            }
        }
        return done;
   }
    public boolean TimedDistGo(double speed, double dir, double goTime, double goDist){
        if(start == false){
            MyTimer.reset();
            MyTimer.start();
            timeValue = goTime;
            distValue = goDist;
            go(speed, dir);
            done = false;
            start = true;
            rIO.getGyroValue();
            System.out.println(" Going ");
        }
        else{
//            if(MyTimer.get() >= timeValue || distValue >= rIO.getDistVal()){
//            if(MyTimer.get() >= timeValue || distValue >= rIO.getFrontDistance()){
            if(MyTimer.get() >= timeValue || distValue >= rIO.getFrontDistanceAvg())
            {
                MyTimer.stop();
                MyTimer.reset();
                go(0,0);
                done = true;
                start = false;
                System.out.println("timeValue: " + timeValue);
                System.out.println("distValue: " + distValue);
                System.out.println("timeVal: " + MyTimer.get());
                System.out.println("distVal: " + rIO.getDistVal());
            }
        }
        return done;
   }
 public void stop(double speed){
 
  rIO.setLeftDrive(0);
  rIO.setRightDrive(0);
 }

 /*
 public void goToLine(){
     go(1,0);
  if(rIO.getCenterLineSensor() == true){
     stop(0);
  }

 }*/

 private void setLeftSpeed(double speed){
     if( hIO.speedControl())
     {
         rIO.setLeftDrive(speed*.75);
//         rIO.setLeftDrive(propSpeed(speed,rIO.getLeftSpeed(),rIO.getCurrentLeftSpeed()));
     }else
     {
        rIO.setLeftDrive(speed);
     }
 }
 private void setRightSpeed(double speed){
     if(hIO.speedControl()){
         rIO.setRightDrive(speed*.75);
//         rIO.setRightDrive(propSpeed(speed,rIO.getRightSpeed(),rIO.getCurrentRightSpeed()));
     }else
     {
         rIO.setRightDrive(speed);
     }
 }

 private double propSpeed(double speed,double encode,double power)
 {
    currentSpeed = encode/6;
    if(currentSpeed > 1.0)
         currentSpeed = 1.0;
    else if(currentSpeed < -1.0)
    {
        currentSpeed = -1.0;
    }
   error=(speed - currentSpeed);

   return power + (0.05 * error);
 }

  }
