package com.example.level0.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class Questions1T implements Parcelable {

    private String question1T;
    private String option11T;
    private String option21T;
    private String option31T;
    private int answerNr1T;


    public Questions1T(String question1T, String option11T, String option21T, String option31T, int answerNr1T) {
        this.question1T = question1T;
        this.option11T = option11T;
        this.option21T = option21T;
        this.option31T = option31T;
        this.answerNr1T = answerNr1T;
    }


    protected Questions1T(Parcel in) {
        question1T = in.readString();
        option11T = in.readString();
        option21T = in.readString();
        option31T= in.readString();
        answerNr1T = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question1T);
        dest.writeString(option11T);
        dest.writeString(option21T);
        dest.writeString(option31T);
        dest.writeInt(answerNr1T);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Questions1T> CREATOR = new Creator<Questions1T>() {
        @Override
        public Questions1T createFromParcel(Parcel in) {
            return new Questions1T(in);
        }

        @Override
        public Questions1T[] newArray(int size) {
            return new Questions1T[size];
        }
    };



    public Questions1T() {
    }


    public String getQuestion1T() {
        return question1T;
    }

    public void setQuestion1T(String question1T) {
        this.question1T = question1T;
    }

    public String getOption11T() {
        return option11T;
    }

    public void setOption11T(String option11T) {
        this.option11T = option11T;
    }

    public String getOption21T() {
        return option21T;
    }

    public void setOption21T(String option21T) {
        this.option21T = option21T;
    }

    public String getOption31T() {
        return option31T;
    }

    public void setOption31T(String option31T) {
        this.option31T = option31T;
    }

    public int getAnswerNr1T() {
        return answerNr1T;
    }

    public void setAnswerNr1T(int answerNr1T) {
        this.answerNr1T = answerNr1T;
    }
}
