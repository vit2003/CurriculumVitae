/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.utils;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class MonthSupport implements Serializable{
    public static int getDayInMonth(int month, int year){
        int result = 31;
        if (month == 4 || month == 6 || month == 9 || month == 11){
            result = 30;
        }else if (month == 2){
            if((year%4) == 0){
                result = 29;
            } else {
                result = 28;
            }
        }
        return result;
    }
}
