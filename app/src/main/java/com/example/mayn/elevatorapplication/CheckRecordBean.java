package com.example.mayn.elevatorapplication;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/3/12 0012.
 */

public class CheckRecordBean implements Serializable {

    private String EntName;
    private String CheckTime;
    private String CheckUserNames;
    private String Remark1;
    private String CheckX;
    private String CheckY;

    public String getEntName() {
        return EntName;
    }

    public void setEntName(String entName) {
        EntName = entName;
    }

    public String getCheckTime() {
        return CheckTime;
    }

    public void setCheckTime(String checkTime) {
        CheckTime = checkTime;
    }

    public String getCheckUserNames() {
        return CheckUserNames;
    }

    public void setCheckUserNames(String checkUserNames) {
        CheckUserNames = checkUserNames;
    }

    public String getRemark1() {
        return Remark1;
    }

    public void setRemark1(String remark1) {
        Remark1 = remark1;
    }

    public String getCheckX() {
        return CheckX;
    }

    public void setCheckX(String checkX) {
        CheckX = checkX;
    }

    public String getCheckY() {
        return CheckY;
    }

    public void setCheckY(String checkY) {
        CheckY = checkY;
    }

    public CheckRecordBean(String entName, String checkTime, String checkUserNames, String remark1, String checkX, String checkY) {
        EntName = entName;
        CheckTime = checkTime;
        CheckUserNames = checkUserNames;
        Remark1 = remark1;
        CheckX = checkX;
        CheckY = checkY;
    }

    public CheckRecordBean() {}
}
