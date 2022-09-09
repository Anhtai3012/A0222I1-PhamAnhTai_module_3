package ss11_slack_queue.bai_tap.queueInfoPerson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Comparable<Person> {
    private String fullName;
    private boolean isMale;
    private Date birthDate;
    private static final String FORMAT_DATE = "dd/MM/yyyy";

    public Person(String fullName, boolean isMale, String birthDate) {
        this.fullName = fullName;
        this.isMale = isMale;

        try {
            this.birthDate = new SimpleDateFormat(FORMAT_DATE).parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getBirthDateFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_DATE);
        return formatter.format(birthDate);
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return this.isMale ? "Male" : "Female";
    }

    public String getFullName() {
        return fullName;
    }

    public String toString() {
        return String.format("Name: %s, gender: %s, birthday %s", getFullName(), getGender(), getBirthDateFormat());
    }

    @Override
    public int compareTo(Person o) {
        int diffBirthDate = this.birthDate.compareTo(o.birthDate);

        if (diffBirthDate != 0) {
            return diffBirthDate;
        }

        if (this.getGender().equals("Female")) {
            return 1;
        }

        return 0;
    }
}
