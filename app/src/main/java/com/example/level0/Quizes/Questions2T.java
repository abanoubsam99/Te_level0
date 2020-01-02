package com.example.level0.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class Questions2T implements Parcelable {
    private String question2T;
    private String option12T;
    private String option22T;
    private String option32T;
    private int answerNr2T;


    public Questions2T() {
    }

    public Questions2T(String question2T, String option12T, String option22T, String option32T, int answerNr2T) {
        this.question2T = question2T;
        this.option12T = option12T;
        this.option22T = option22T;
        this.option32T = option32T;
        this.answerNr2T = answerNr2T;
    }



    protected Questions2T(Parcel in) {
        question2T = in.readString();
        option12T = in.readString();
        option22T = in.readString();
        option32T= in.readString();
        answerNr2T = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question2T);
        dest.writeString(option12T);
        dest.writeString(option22T);
        dest.writeString(option32T);
        dest.writeInt(answerNr2T);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Questions2T> CREATOR = new Creator<Questions2T>() {
        @Override
        public Questions2T createFromParcel(Parcel in) {
            return new Questions2T(in);
        }

        @Override
        public Questions2T[] newArray(int size) {
            return new Questions2T[size];
        }
    };




    public String getQuestion2T() {
        return question2T;
    }

    public void setQuestion2T(String question2T) {
        this.question2T = question2T;
    }

    public String getOption12T() {
        return option12T;
    }

    public void setOption12T(String option12T) {
        this.option12T = option12T;
    }

    public String getOption22T() {
        return option22T;
    }

    public void setOption22T(String option22T) {
        this.option22T = option22T;
    }

    public String getOption32TC() {
        return option32T;
    }

    public void setOption32TC(String option32TC) {
        this.option32T = option32TC;
    }

    public int getAnswerNr2T() {
        return answerNr2T;
    }

    public void setAnswerNr2T(int answerNr2T) {
        this.answerNr2T = answerNr2T;
    }
}
