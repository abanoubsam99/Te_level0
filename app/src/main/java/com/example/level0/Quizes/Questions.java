package com.example.level0.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class Questions implements Parcelable {
    private String question1C;
    private String option11C;
    private String option21C;
    private String option31C;
    private int answerNr1C;

    public Questions() {
    }

    public Questions(String question1C, String option11C, String option21C, String option31C, int answerNr1C) {
        this.question1C = question1C;
        this.option11C = option11C;
        this.option21C = option21C;
        this.option31C = option31C;
        this.answerNr1C = answerNr1C;
    }



    protected Questions(Parcel in) {
        question1C = in.readString();
        option11C = in.readString();
        option21C = in.readString();
        option31C= in.readString();
        answerNr1C = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question1C);
        dest.writeString(option11C);
        dest.writeString(option21C);
        dest.writeString(option31C);
        dest.writeInt(answerNr1C);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Questions> CREATOR = new Creator<Questions>() {
        @Override
        public Questions createFromParcel(Parcel in) {
            return new Questions(in);
        }

        @Override
        public Questions[] newArray(int size) {
            return new Questions[size];
        }
    };


    public String getQuestion1C() {
        return question1C;
    }

    public void setQuestion1C(String question1C) {
        this.question1C = question1C;
    }

    public String getOption11C() {
        return option11C;
    }

    public void setOption11C(String option11C) {
        this.option11C = option11C;
    }

    public String getOption21C() {
        return option21C;
    }

    public void setOption21C(String option21C) {
        this.option21C = option21C;
    }

    public String getOption31C() {
        return option31C;
    }

    public void setOption31C(String option31C) {
        this.option31C = option31C;
    }

    public int getAnswerNr1C() {
        return answerNr1C;
    }

    public void setAnswerNr1C(int answerNr1C) {
        this.answerNr1C = answerNr1C;
    }
}
