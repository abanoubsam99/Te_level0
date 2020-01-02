package com.example.level0.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class Questions2C implements Parcelable {

    private String question2C;
    private String option12C;
    private String option22C;
    private String option32C;
    private int answerNr2C;

    public Questions2C() {
    }

    public Questions2C(String question2C, String option12C, String option22C, String option32C, int answerNr2C) {
        this.question2C = question2C;
        this.option12C = option12C;
        this.option22C = option22C;
        this.option32C = option32C;
        this.answerNr2C = answerNr2C;
    }


    protected Questions2C(Parcel in) {
        question2C = in.readString();
        option12C = in.readString();
        option22C = in.readString();
        option32C= in.readString();
        answerNr2C = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question2C);
        dest.writeString(option12C);
        dest.writeString(option22C);
        dest.writeString(option32C);
        dest.writeInt(answerNr2C);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Questions2C> CREATOR = new Creator<Questions2C>() {
        @Override
        public Questions2C createFromParcel(Parcel in) {
            return new Questions2C(in);
        }

        @Override
        public Questions2C[] newArray(int size) {
            return new Questions2C[size];
        }
    };




    public String getQuestion2C() {
        return question2C;
    }

    public void setQuestion2C(String question2C) {
        this.question2C = question2C;
    }

    public String getOption12C() {
        return option12C;
    }

    public void setOption12C(String option12C) {
        this.option12C = option12C;
    }

    public String getOption22C() {
        return option22C;
    }

    public void setOption22C(String option22C) {
        this.option22C = option22C;
    }

    public String getOption32C() {
        return option32C;
    }

    public void setOption32C(String option32C) {
        this.option32C = option32C;
    }

    public int getAnswerNr2C() {
        return answerNr2C;
    }

    public void setAnswerNr2C(int answerNr2C) {
        this.answerNr2C = answerNr2C;
    }
}
