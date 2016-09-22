/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.DriverStation;


/**
 *
 * @author programmers
 * @version %I
 */
public class HumanIOtemp {

   private static Joystick leftJoy;
   private static Joystick rightJoy;
   private static Joystick testJoy;
   //private static DriverStationEnhancedIO dseio;
   private static DriverStationLCD lcd = DriverStationLCD.getInstance();
   private static DriverStationEnhancedIO dseio = DriverStation.getInstance().getEnhancedIO();
   private static double leftJoyYValue,rightJoyYValue;
   /** Left Joystick is assigned to port {@value #lclLeftJoyValue}. */
   public static final int lclLeftJoyValue  = 1;
   /** Right Joystick is assigned to port {@value #lclRightJoyValue}. */
   public static final int lclRightJoyValue = 2;
   private static boolean shiftButton;
   private static boolean shiftButton2;
   public static final int GROUND_VAL   = 0;
   public static final int BOT_VAL      = 2;
   public static final int MID_VAL      = 10;
   public static final int TOP_VAL      = 14;
   public static final int HUMAN_VAL    = 6;
   public static final int ARM_STOP     = 0xffff;
   public static final int ARM_DOWN     = 0xfffe;
   public static final int ARM_UP       = 0xfffd;
   public static double topPositionAn,botPositionAn,midPositionAn,hmnPositionAn,grdPositionAn;
   public static boolean topPosition;
   public static boolean botPosition;
   public static boolean midPosition;
   public static boolean hmnPosition;
   public static boolean grdPosition;
   public static boolean armStopButton;
   public static boolean armUpButton;
   public static boolean armDnButton;
   public static boolean armTiltSwitch;
   //public static boolean openGripperButton;
   public static boolean spinTubeUpButton;
   public static boolean spinTubeDownButton;
   public static boolean spitOutTubeButton;
   public static boolean stopSpinningTubeButton;
   //public static boolean closeGripperButton;
   public static boolean miniBotAlignInButton;
   public static boolean miniBotAlignOutButton;
   public static boolean miniBotDeployInButton;
   public static boolean miniBotDeployOutButton;

   public static boolean driveInvertButton;
   public static boolean driveInvertButton2;
   /**public final static double GROUND    = -1;
   public final static double LOW       = -0.5;
   public final static double MIDDLE    = 0.0;
   public final static double TOP       = 0.5;
   public final static double HUMAN     = 1;
   public final static double TOLERANCE =.1;*/
   

    /**
     * Creates Joysticks and assigns to local references.<br>
     *           Assigns switches to local references
     */
    public HumanIOtemp()
    {
         leftJoy = new Joystick(lclLeftJoyValue);
         rightJoy = new Joystick (lclRightJoyValue);
         testJoy = new Joystick (3); // This is a hack job
    }

    /*
     *
     */
    public static void retrieveValues()
    {
        try {
            //System.out.println("here 1");
            leftJoyYValue = leftJoy.getY();
            //System.out.println("here 2");
            rightJoyYValue = rightJoy.getY();
            //System.out.println("here 3");
            shiftButton = leftJoy.getRawButton(1);
            shiftButton2 = rightJoy.getRawButton(1);
            //System.out.println("here 4");
            //openGripperButton  = rightJoy.getRawButton(1);
            spinTubeUpButton = dseio.getDigital(6);
            //System.out.println("here 5");
            //closeGripperButton = rightJoy.getRawButton(3);
            spinTubeDownButton = dseio.getDigital(8);
            //System.out.println("here 6");
            //stopSpinningTubeButton=rightJoy.getRawButton(2);
            //armStopButton=testJoy.getRawButton(8);
            armTiltSwitch = dseio.getDigital(5);
            armUpButton = dseio.getDigital(2);
            armDnButton = dseio.getDigital(7);
            //System.out.println("here 7");
            //ctrBot=rightJoy.getRawButton(6);
            hmnPositionAn = dseio.getAnalogIn(3);
            grdPositionAn = dseio.getAnalogIn(6);
            botPositionAn = dseio.getAnalogIn(2);
            midPositionAn = dseio.getAnalogIn(4);
            topPositionAn = dseio.getAnalogIn(1);
            miniBotAlignOutButton = dseio.getDigital(3);
            miniBotDeployOutButton = dseio.getDigital(4);
            driveInvertButton = leftJoy.getRawButton(3);
            driveInvertButton2 = rightJoy.getRawButton(3);
            //dseio = DriverStation.getInstance().getEnhancedIO();
        } catch (DriverStationEnhancedIO.EnhancedIOException enhancedIOException) {
        }
    }

    public static void getArmPositionInputs()
    {
        try {
            if (dseio.getAnalogIn(3) > .9) {
                hmnPosition = true;

            } else {
                hmnPosition = false;


            }
            if (dseio.getAnalogIn(6) > .9) {
                grdPosition = true;

            } else {
                grdPosition = false;

            }
            if (dseio.getAnalogIn(2) > .9) {
                botPosition = true;

            } else {
                botPosition = false;

            }
            if (dseio.getAnalogIn(4) > .9) {
                midPosition = true;

            } else {
                midPosition = false;

            }
            if (dseio.getAnalogIn(1) > .9) {
                topPosition = true;

            } else {
                topPosition = false;

            }
        } catch (DriverStationEnhancedIO.EnhancedIOException enhancedIOException) {
        }
    }

    public static void test()
    {
//        System.out.print("hmnPosition: " + hmnPosition);
//        System.out.print("  grdPosition: " + grdPosition);
//        System.out.print("  topPosition: " + topPosition);
//        System.out.print("  midPosition: " + midPosition);
//        System.out.print("  botPosition: " + botPosition);
        System.out.print(" armUp:"+armUpButton);
        System.out.print("armDown"+armDnButton);
        System.out.print(" Tilt:" + armTiltSwitch);
        System.out.print(" TubeDown:" + spinTubeDownButton);
        System.out.print(" TubeUp:" + spinTubeUpButton);
        System.out.print(" miniBotAlign:" + miniBotAlignOutButton);
        System.out.println(" miniBotDeploy:" + miniBotDeployOutButton);

    }


    boolean getArmOverrideBut() {
        return false;//TODO: make this work correctly
    }

    public static int tgt = ARM_STOP;
    public static int prev = ARM_STOP;
    public static int getElevatorSwitchValue()
    {
        if(armUpButton)
        {
            tgt=prev=ARM_UP;
        }
        else if(armDnButton)
        {
            tgt=prev=ARM_DOWN;
        }
        else if(botPosition)
        {
            tgt=prev=BOT_VAL;
            System.out.println("Going to Position 1:" + RobotIO.getArmEncoder());
        }
        else if(midPosition)
        {
            tgt=prev=MID_VAL;
            System.out.println("Going to Position 2:" + RobotIO.getArmEncoder());
        }
        else if(topPosition)
        {
            tgt=prev=TOP_VAL;
            System.out.println("Going to Position 3:" + RobotIO.getArmEncoder());
        }
        else if(grdPosition)
        {
            tgt=prev=GROUND_VAL;
            System.out.println("Going to Position 0:" + RobotIO.getArmEncoder());
        }
        else if(hmnPosition)
        {
            tgt=prev=HUMAN_VAL;
            System.out.println("Going to Position 4:" + RobotIO.getArmEncoder());
        }
        else if(prev == ARM_UP || prev == ARM_DOWN)
        {
            tgt=prev=ARM_STOP;
        }
        return tgt;
    }

    public static int getDseioArmPosition()
    {
        return HumanIOtemp.getElevatorSwitchValue();
    }

    public static boolean getShiftButton()
    {
        return shiftButton;
    }

    public static boolean getShiftButton2()
    {
        return shiftButton2;
    }
    public static boolean getMiniBotAlignOutButton()
    {
        return miniBotAlignOutButton;
    }

    public static boolean getMiniBotAlignInButton()
    {
        return miniBotAlignInButton;
    }

    public static boolean getMiniBotDeployOutButton()
    {
        return miniBotDeployOutButton;
    }

    public static boolean getMiniBotDeployInButton()
    {
        return miniBotDeployInButton;
    }
    /*
    public static boolean getOpenGripperButton()
    {
        return openGripperButton;
    }
    public static boolean getCloseGripperButton()
    {
        return closeGripperButton;
    }
     */

    public static boolean getSpinTubeUpButton()
    {
        return spinTubeUpButton;
    }
    public static boolean getSpinTubeDownButton()
    {
        return spinTubeDownButton;
    }

    public static boolean getStopSpinningTubeButton()
    {
         return stopSpinningTubeButton;
    }

    public static double getLeftJoyY()
    {
        return leftJoyYValue;
    }

    public static double getRightJoyY()
    {
        return rightJoyYValue;
    }

/****************
 * BEGIN DRIVER STATION LCD CODE
 *
 * Author: Jackson Anderson
 *******************/

    public static void printLCD(DriverStationLCD.Line line,int startPosition ,String text)
    {
        lcd.println(line,startPosition,text);
    }

    public static void updateLCD()
    {
        lcd.updateLCD();
    }

    boolean driveInvert() {
        if (driveInvertButton || driveInvertButton2)
            return true;
        else
            return false;
    }



}
/*        if(lRBottom && lRTop)
        {
            if(lRMidCnt < maxCnt)
            {
                lRMidCnt++;
            }
            lRTopCnt=lRBotCnt=ctrTopCnt=ctrMidCnt=ctrBotCnt=grdCnt=rstCnt=0;
        }
        else if(lRBottom)
        {
            if(lRBotCnt < maxCnt)
            {
                lRBotCnt++;
            }
            lRTopCnt=lRMidCnt=ctrTopCnt=ctrMidCnt=ctrBotCnt=grdCnt=rstCnt=0;
        }
        else if(lRTop)
        {
            if(lRTopCnt < maxCnt)
            {
                lRTopCnt++;
            }
            lRMidCnt=lRBotCnt=ctrTopCnt=ctrMidCnt=ctrBotCnt=grdCnt=rstCnt=0;
        }
        else if(ctrTop && ctrBottom)
        {
            if(ctrMidCnt < maxCnt)
            {
                ctrMidCnt++;
            }
            lRTopCnt=lRBotCnt=lRMidCnt=ctrTopCnt=ctrBotCnt=grdCnt=rstCnt=0;
        }
        else if(ctrBottom)
        {
            if(ctrBotCnt < maxCnt)
            {
                ctrBotCnt++;
            }
            lRTopCnt=lRBotCnt=lRMidCnt=ctrTopCnt=ctrMidCnt=grdCnt=rstCnt=0;
        }
        else if(ctrTop)
        {
            if(ctrTopCnt < maxCnt)
            {
                ctrTopCnt++;
            }
            lRMidCnt=lRBotCnt=lRTopCnt=ctrMidCnt=ctrBotCnt=grdCnt=rstCnt=0;
        }
        else if(grdButton)
        {
            if(grdCnt < maxCnt)
            {
                grdCnt++;
            }
            lRMidCnt=lRBotCnt=lRTopCnt=ctrMidCnt=ctrBotCnt=ctrTopCnt=rstCnt=0;
        }
        else if(armReset)
        {
            if(rstCnt < maxCnt)
            {
                rstCnt++;
            }
            lRMidCnt=lRBotCnt=lRTopCnt=ctrMidCnt=ctrBotCnt=ctrTopCnt=grdCnt=0;
        }
        return maxCnt;
 *
 * private static int lRBotCnt;
   private static int lRMidCnt;
   private static int lRTopCnt;
   private static int ctrBotCnt;
   private static int ctrMidCnt;
   private static int ctrTopCnt;
   private static int grdCnt;
   private static int rstCnt;
   private static final int maxCnt=10;
 */

/**
 * try
        {
            if((dseio.getAnalogIn(1) > (GROUND - TOLERANCE)) && (dseio.getAnalogIn(1) < (GROUND + TOLERANCE)))
            {
                return 0;
            }
            else if((dseio.getAnalogIn(1) > (LOW - TOLERANCE)) && (dseio.getAnalogIn(1) < (LOW + TOLERANCE)))
            {
                return 1;
            }
            else if((dseio.getAnalogIn(1) > (MIDDLE - TOLERANCE)) && (dseio.getAnalogIn(1) < (MIDDLE + TOLERANCE)))
            {
                return 2;
            }
            else if((dseio.getAnalogIn(1) > (TOP - TOLERANCE)) && (dseio.getAnalogIn(1) < (TOP + TOLERANCE)))
            {
                return 3;
            }
            else if((dseio.getAnalogIn(1) > (HUMAN - TOLERANCE)) && (dseio.getAnalogIn(1) < (HUMAN + TOLERANCE)))
            {
                return 4;
            }
            else
            {
                return -100;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
 */
