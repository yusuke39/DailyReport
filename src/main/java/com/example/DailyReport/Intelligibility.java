package com.example.DailyReport;


public class Intelligibility {

   public enum IntelligibilityEnum {


        BETTER_UNDERSTAND("良く理解できた"),
        ROUGHLY_UNDERSTAND("概ね理解できた"),
        USUALLY("普通"),
        LITTLE_DIFFICULT("少し難しかった"),
        VERY_DIFFICULT("とても難しかった");



        private final String intelligibility;

        IntelligibilityEnum(String intelligibility) {
            this.intelligibility = intelligibility;
        }

       public String getIntelligibility() {
           return intelligibility;
       }

    }

}
