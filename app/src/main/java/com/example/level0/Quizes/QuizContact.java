package com.example.level0.Quizes;

import android.provider.BaseColumns;

public final class QuizContact {

    private QuizContact() {
    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME1C = "quiz_questions1C";
        public static final String COLUMN_QUESTION1C = "question1C";
        public static final String COLUMN_OPTION11C = "option11C";
        public static final String COLUMN_OPTION21C = "option21C";
        public static final String COLUMN_OPTION31C = "option31C";
        public static final String COLUMN_ANSWER_NR1C = "answer_nr1C";



        public static final String TABLE_NAME1T = "quiz_questions1T";
        public static final String COLUMN_QUESTION1T = "question1T";
        public static final String COLUMN_OPTION11T = "option11T";
        public static final String COLUMN_OPTION21T = "option21T";
        public static final String COLUMN_OPTION31T = "option31T";
        public static final String COLUMN_ANSWER_NR1T = "answer_nr1T";



        public static final String TABLE_NAME2C = "quiz_questions2C";
        public static final String COLUMN_QUESTION2C = "question2C";
        public static final String COLUMN_OPTION12C = "option12C";
        public static final String COLUMN_OPTION22C = "option22C";
        public static final String COLUMN_OPTION32C = "option32C";
        public static final String COLUMN_ANSWER_NR2C = "answer_nr2C";



        public static final String TABLE_NAME2T = "quiz_questions2T";
        public static final String COLUMN_QUESTION2T = "question2T";
        public static final String COLUMN_OPTION12T = "option12T";
        public static final String COLUMN_OPTION22T= "option22T";
        public static final String COLUMN_OPTION32T = "option32T";
        public static final String COLUMN_ANSWER_NR2T = "answer_nr2T";
    }

}

