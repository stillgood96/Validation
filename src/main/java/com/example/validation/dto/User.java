package com.example.validation.dto;

import com.example.validation.annotaion.YearMonth;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {


  @YearMonth
  private String reqYearMonth2;

  public String getReqYearMonth2() {
    return reqYearMonth2;
  }

  public void setReqYearMonth2(String reqYearMonth2) {
    this.reqYearMonth2 = reqYearMonth2;
  }

  @Size(min = 6, max =6)
  private String reqYearMonth; // yyyyMM

  @AssertTrue(message = "yyyyMM의 형식에 맞지 않습니다.")
  public boolean isReqYearMonthValidation() {

    try{
      LocalDate localDate = LocalDate.parse(getReqYearMonth() + "01", DateTimeFormatter.ofPattern("yyyyMMdd"));
    }catch (Exception e ){
      return false;
    }

    return true;
  }


  public String getReqYearMonth() {
    return reqYearMonth;
  }

  @Override
  public String toString() {
    return "User{" +
            "reqYearMonth='" + reqYearMonth + '\'' +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", email='" + email + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            '}';
  }

  public void setReqYearMonth(String reqYearMonth) {
    this.reqYearMonth = reqYearMonth;
  }

  @NotBlank
  private String name;

  @Max(value =90)
  private int age;

  @Email
  private String email;

  @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. xxx-xxxx-xxxx")
  private String phoneNumber;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

}
