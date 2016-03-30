/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author Evgeny_Vart
 */
public class CheckInput {

    public static boolean isNumber(String s) {

        boolean isnumber = false;

        Integer intSum;

        try {
            intSum = new Integer(s);
            isnumber = true;
        } catch (NumberFormatException e) {
            isnumber = false;
        }

        return isnumber;
    }

}
