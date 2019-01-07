package fr.usmb;

import java.time.LocalDate;

public class Person {
    private LocalDate birth_day;
    private String surname;
    private String firstName;
    private String mail;
    public Person(LocalDate birth, String surname, String firstName, String mail){
        this.birth_day = birth;
        this.surname = surname;
        this.firstName = firstName;
        this.mail = mail;
    }
    private Person(){}

    public LocalDate getBirth_day() {
        return birth_day;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMail() {
        return mail;
    }

    public boolean isBirthday(){
        return this.birth_day.getDayOfYear() == LocalDate.now().getDayOfYear();
    }
}
