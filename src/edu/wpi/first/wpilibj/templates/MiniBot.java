/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author programmers
 */
public class MiniBot {
    private RobotIO rIO;
    private HumanIO hIO;
   // private Timer time = new Timer();

    public MiniBot(RobotIO rio, HumanIO hio){
        this.hIO = hio;
        this.rIO = rio;
       // time.start();
    }

//    public boolean isTime(){
//        if(time.get()>125500000)
//            return true;
//        else
//            return false;
//    }

    public void humanDeployAlignment(){
        if(hIO.getMiniBotAlignOutButton())
            rIO.setMinibotAlignOut(true);
        else if(!hIO.getMiniBotAlignOutButton())
            rIO.setMinibotAlignOut(false);
   
    }

    public void humanDeployMinibot(){
       
            rIO.setMinibotDeployOut(hIO.getMiniBotAlignOutButton(), hIO.getMiniBotDeployOutButton());
    
    }


/*
    public void alignBotToTower(){
        if      (time.get() > 125000 && rIO.getMiniBotSwitch()){
            //engage pneumatic to deploy mini'bot
            //keep moving towards the tower
        }else if(time.get() > 125000 && !rIO.getMiniBotSwitch()){
            //deploy the alignment arm
            //move towards tower
        }else if(time.get() < 125000 && rIO.getMiniBotSwitch()){
            //
        }else if(time.get() < 125000 && !rIO.getMiniBotSwitch()){
            //
        }
    }


    public void autoDeploy(){
        if(time.get()< 125000){
            //keep alignment out and move to tower
        }else if(time.get() > 125000 && rIO.getMiniBotSwitch()){
            //deploy mini bot
        }else if(time.get() > 125000 && !rIO.getMiniBotSwitch()){
            //keep moving backward
        }
    }
*/
}
