/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
/**
 *
 * @author J.Anderson
 */
public class Motor {

    PWM controller;
    CANJaguar jaguar;
    boolean isCan;


     /*******************
     * Author: jackson anderson
     * parameters: int lclChannel - the pwm channel/CAN id,
     *             boolean lclCan - tells if the speed controller is CAN or not
     * Return:
     * Description: returns the value of the current speed setting
     * Date last edited: 1/15/11
     */

    public Motor(int lclChannel, boolean lclCan)
    {
        if(lclCan)
        {
            try {
                jaguar = new CANJaguar(lclChannel);
            } catch (CANTimeoutException ex) {
                ex.printStackTrace();
            }
        }
        else
        {
            controller = new PWM(lclChannel);
        }
        isCan = lclCan;
    }

    /*******************
     * Author: jackson anderson
     * method name: GET
     * parameters: none
     * Return: double - speed setting
     * Description: returns the value of the current speed setting
     * Date last edited: 1/15/11
     */

    public double get()
    {
        if(isCan)
        {
            return jaguar.get();
        }
        else
            return controller.getSpeed();
    }

        /*******************
     * Author: jackson anderson
     * method name: SET
     * parameters: double - set speed
     * Return: none
     * Description: sets the speed of the motor to a given value
     * Date last edited: 1/15/11
     */

    public void set(double value)
    {
        if(isCan)
        {
            jaguar.set(value);
        }
        else
            controller.setRaw((int)((value*127)+128));
    }

}
