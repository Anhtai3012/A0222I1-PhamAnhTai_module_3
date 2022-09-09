package model;

public class Member {
    private int id;
    private String fullName;
    private String birthday;
    private int houseHoldId;

    public int getHouseHoldId() {
        return houseHoldId;
    }

    public void setHouseHoldId(int houseHoldId) {
        this.houseHoldId = houseHoldId;
    }

    public Member(int id, String fullName, String birthday, int houseHoldId) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.houseHoldId = houseHoldId;
    }

    public Member() {
    }

    public Member(int id, String fullName, String birthday) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
