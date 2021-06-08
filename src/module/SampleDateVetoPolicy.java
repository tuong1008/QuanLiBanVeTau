/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import com.github.lgooddatepicker.optionalusertools.DateVetoPolicy;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author Tuong
 */
 public class SampleDateVetoPolicy implements DateVetoPolicy {

        /**
         * isDateAllowed, Return true if a date should be allowed, or false if a date should be
         * vetoed.
         */
        @Override
        public boolean isDateAllowed(LocalDate date) {
            // Disallow days < now
            if (date.compareTo(LocalDate.now())<0) {
                return false;
            }
            // Allow all other days.
            return true;
        }
    }
