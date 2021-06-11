 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;
import view.LoginFrame;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Main {
    public static void main(String[] args) {
//        Timestamp old=new Timestamp(System.currentTimeMillis());
//        System.out.println(old);
//        Timestamp later = new Timestamp(old.getTime()+ (1000 * 60 * 60 * 25));
//        System.out.println(later);

//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.add(Calendar.HOUR, 25);
//        timestamp = new Timestamp(calendar.getTimeInMillis());
//        System.out.println(timestamp);
        new LoginFrame().setVisible(true);
    }
}
