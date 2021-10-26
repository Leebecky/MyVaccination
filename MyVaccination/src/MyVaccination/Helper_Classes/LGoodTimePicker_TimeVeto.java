
package MyVaccination.Helper_Classes;
import com.github.lgooddatepicker.optionalusertools.PickerUtilities;
import com.github.lgooddatepicker.optionalusertools.TimeVetoPolicy;
import java.time.LocalTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leebe
 */
  public class LGoodTimePicker_TimeVeto implements TimeVetoPolicy {

      private int firstHour;
      private int firstMinutes;
      private int lastHour;
      private int lastMinutes;
      
      public LGoodTimePicker_TimeVeto() {
          this.firstHour = 8;
          this.firstMinutes = 00;
          this.lastHour = 22;
          this.lastMinutes = 00;
      }
      
      public LGoodTimePicker_TimeVeto(int firstHour, int firstMinutes, int lastHour, int lastMinutes) {
          this.firstHour = firstHour;
          this.firstMinutes = firstMinutes;
          this.lastHour = lastHour;
          this.lastMinutes = lastMinutes;
      }
      
      public void setFirstHour(int value) {
          firstHour = value;
      }
      
      public void setFirstMinutes(int value) {
          firstMinutes = value;
      }
      
      public void setLastHour(int value) {
          lastHour = value;
      }
      
      public void setLastMinutes(int value) {
          lastMinutes = value;
      }
      
        /**
         * isTimeAllowed, Return true if a time should be allowed, or false if a time should be
         * vetoed.
     * @param time
     * @return 
         */
        @Override
        public boolean isTimeAllowed(LocalTime time) {
            // Only allow times from 8am to 10pm, inclusive.            
            
            return PickerUtilities.isLocalTimeInRange(
                time, LocalTime.of(firstHour, firstMinutes), LocalTime.of(lastHour, lastMinutes), true);
        }
    }