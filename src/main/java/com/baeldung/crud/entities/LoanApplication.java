package com.baeldung.crud.entities;

import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrivateID() {
        return privateID;
    }

    public void setPrivateID(String privateID) {
        this.privateID = privateID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getMonthlyLiabilities() {
        return monthlyLiabilities;
    }

    public void setMonthlyLiabilities(float monthlyLiabilities) {
        this.monthlyLiabilities = monthlyLiabilities;
    }

    public float getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(float requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public float getRequestedTermDays() {
        return requestedTermDays;
    }

    public void setRequestedTermDays(float requestedTermDays) {
        this.requestedTermDays = requestedTermDays;
    }

    public String getStatus() {
        return status;
    }

    public void markStatus() {

        int charSum = getCharSum();

        double score = charSum + salary*1.5 - monthlyLiabilities*3 + birthDate.getYear() - birthDate.getMonthValue() - birthDate.getDayOfYear();

        this.status = GetStatusTextByScore(score);
    }

    private String GetStatusTextByScore(double score){
        if (score < 2500)
            return "rejected";
        else {
            if (score > 3500)
                return "approved";
            else
                return "manual";
        }

    }

    private int getCharSum(){
        String nameString = firstName.toLowerCase();
        char[] ch  = nameString.toCharArray();
        int charSum = 0;
        for(char c : ch)
        {
            int temp = (int)c;
            int temp_integer = 96; //for upper case
            if(temp<=122  & temp>=97)
                charSum = charSum + (temp-temp_integer);
        }

        return charSum;
    }

    @Size(min = 10, max = 10, message = "{privateid.wrongsize}")
    private String privateID;

    @NotEmpty(message = "{firstname.notempty}")
    @Size(min = 2, max = 30, message = "{firstname.wrongsize}")
    private String firstName;

    @NotEmpty(message = "{lastname.notempty}")
    @Size(min = 2, max = 30, message = "{lastname.wrongsize}")
    private String lastName;



    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "{birthDate.notnull}")
    @Past
    private LocalDate birthDate;

    private String employer;
    @NotNull(message = "{salary.notempty}")
    @Min(value = 1,message = "{salary.lessthanone}")
    private float salary;

    @NotNull(message = "{monthlyLiabilities.notempty}")
    private float monthlyLiabilities;

    private float requestedAmount;

    private float requestedTermDays;

    private String status;


    public LoanApplication() {
    }

    public LoanApplication(String name, String LastName) {
        this.firstName = name;
        this.lastName = LastName;
    }
}
