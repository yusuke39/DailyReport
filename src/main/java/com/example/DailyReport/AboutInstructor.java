package com.example.DailyReport;

public class AboutInstructor {

    public enum AboutInstructorEnum {


        VERY_POLITE("とても丁寧だった"),
        ROUGHLY_POLITE("概ね丁寧だった"),
        NO_OPINION("普通"),
        NOT_LITTLE_POLITE("やや丁寧ではなかった"),
        NOT_AT_ALL_POLITE("全く丁寧ではなかった");



        private final String aboutInstructor;

        AboutInstructorEnum(String intelligibility) {
            this.aboutInstructor = intelligibility;
        }

        public String getAboutInstructor() {
            return aboutInstructor;
        }

    }

}
