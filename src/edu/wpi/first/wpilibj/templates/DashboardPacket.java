/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Dashboard;
import edu.wpi.first.wpilibj.DriverStation;
/**
 *
 * @author programmers
 */
public class DashboardPacket {

    private byte minibotState;
    private byte rollerState;
    private byte compressorState;

    public void updateDash()
    {
        if(!RobotIO.getMinibotAlignOut() && !RobotIO.getMinibotDeployOut())
            minibotState = 1; // mini bot not extended
        else if (RobotIO.getMinibotAlignOut() && !RobotIO.getMinibotDeployOut() && RobotIO.getMinibotAlignedSwitch())
            minibotState = 2; // minibot Y
        else if (RobotIO.getMinibotAlignOut() && !RobotIO.getMinibotDeployOut() && !RobotIO.getMinibotAlignedSwitch())
            minibotState = 3; // tower contact
        else if (RobotIO.getMinibotAlignOut() && RobotIO.getMinibotDeployOut())
            minibotState = 4; //Minibot deployed
        else
            minibotState = 0; //No data



        if(RobotIO.getGripperRollerValue() == -1 && HumanIO.getSpinTubeUpButton())
            rollerState = 1;
        else if(RobotIO.getGripperRollerValue() == -1 && !HumanIO.getSpinTubeUpButton())
            rollerState = 2;
        else if(RobotIO.getGripperRollerValue() == 0)
            rollerState = 3; //roller off
        else if(RobotIO.getGripperRollerValue() == 1)
            rollerState = 4; //Roller Out
        else
            rollerState = 0;


        if(!RobotIO.getCompressorState() && !RobotIO.getPressureSwitchValue())
            compressorState = 1;
        else if(RobotIO.getCompressorState() && !RobotIO.getPressureSwitchValue())
            compressorState = 2;
        else if(!RobotIO.getCompressorState() && RobotIO.getPressureSwitchValue())
            compressorState = 3;
        else
            compressorState = 0;



        Dashboard lowDashData = DriverStation.getInstance().getDashboardPackerLow();
        lowDashData.addCluster();
        {
            lowDashData.addInt(RobotIO.getArmEncoder());
            lowDashData.addDouble(RobotIO.getArmMotorValue());
            lowDashData.addByte(minibotState);
            lowDashData.addByte(rollerState);
            lowDashData.addByte(compressorState);
            lowDashData.addBoolean(HumanIO.getShiftButton() || HumanIO.getShiftButton2());
            lowDashData.addDouble(RobotIO.getGyroValue());
            lowDashData.addBoolean(HumanIO.speedControl());
            lowDashData.addDouble(RobotIO.accel.getAcceleration());

        }
        lowDashData.finalizeCluster();
        lowDashData.commit();
    }

}
