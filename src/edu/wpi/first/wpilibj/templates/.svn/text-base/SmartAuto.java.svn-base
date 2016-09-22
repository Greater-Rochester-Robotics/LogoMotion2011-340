/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author tyler
 */
public class SmartAuto {
    RobotIO rIO;
    HumanIO hIO;
    BaseDrive myBD;
    RobotArm myArm;
    Timer time=new Timer();
    private int stage;
    // state constants
    private static final int Idle             = 0;
    private static final int FullFwd          = 1;
    private static final int TiltArm          = 2;
    private static final int HalfFwd          = 3;
    private static final int MoveElvUp        = 4;
    private static final int FindLineValue    = 5;
    private static final int MoveFwdHalfFinal = 6;
    private static final int MoveElvDwn       = 7;
    private static final int RlsGrpr          = 8;
    private static final int MoveBack         = 9;
    private static final int Stop             = 10;

   // base drive constants
    private static final double SpeedFull       = 1.0;
    private static final double SpeedHalf       = 0.3;
    private static final double Forward         = 1.0;
    private static final double Reverse         = -1.0;
    private static final double Linevalueleft   = 1.0 ;
    private static final double LineValueCenter = 1.0 ;
    private static final double lineValueRight  = 1.0;

    // state times
    private static final double FFtime = 2.0;
    private static final double FHtime = 2.0;
    private static final double RHtime = 2.0;
    
    
    public static int autoState;
    /**
     *
     * @param lclrIO
     * @param lclhIO
     */

    public SmartAuto(RobotIO lclrIO,BaseDrive lclmyBD,RobotArm lclmyArm ){
    
     stage=1;
     autoState  = Idle;
     this.myBD  = lclmyBD;
     this.rIO   = lclrIO;
     this.myArm = lclmyArm;

}
    public void SmartAuto(){
        rIO.retrieveValues();    
        switch ( autoState ){
            case Idle:
                System.out.println("In Idle");
                autoState = FullFwd;
                break;
            case FullFwd:
                System.out.println("Full Forward");
                if(myBD.TimedGo(SpeedFull , Forward , FFtime) ){
                System.out.println("Going to tilt arm");
                    autoState = TiltArm;
                }
                break;
            case TiltArm:
                 System.out.println("Tilting arm");
                rIO.setArmTilt(true);
                autoState = HalfFwd;
                 System.out.println("going to Half Forward");
                break;
            case HalfFwd:
                 System.out.println("Forward half");
                if( myBD.TimedGo(SpeedHalf, Forward, FHtime)){
                    autoState = FindLineValue;
                     System.out.println("Is It Found?");
                rIO.getCenterLineSensor();
                if(true)//continue to move arm up
                    autoState = MoveElvUp;
                    System.out.println("Line Found Go To Move Arm Up");
                }
                 break;
            case MoveElvUp:
                 System.out.println("move elevator up");
                if(myArm.goToPos(hIO.TOP_VAL)){
                    autoState = MoveFwdHalfFinal;
                    System.out.println("Go to MoveFwdHalf");
                }
                 break;
            case MoveFwdHalfFinal:
                 System.out.println(" Go Forward half");
                if( myBD.TimedGo(SpeedHalf, Forward, FHtime)){
                   autoState = MoveElvUp;
                   System.out.println("get ready to release");
                }
                break;
            case RlsGrpr:
                 System.out.println("Release The Kracken!");
                if(true){// needs griper relaease value from Adam's
                    autoState = MoveBack;
                     System.out.println("Getting ready to move back");
                }
                break;
            case MoveBack:
                 System.out.println("Backing up");
               if( myBD.TimedGo(SpeedHalf, Reverse, RHtime)){
                    autoState = Stop;
                     System.out.println("Prepare to stop");
                }
                break;
            case Stop:
                 System.out.println("STOP!");
                break;
            default:
                autoState = Stop;
                break;
                    
                    
        }
    }
}




            
               
