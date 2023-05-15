package com.frestonanalytics.msl.Employee.entity;


import javax.persistence.*;

import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "Employer_Details")
public class EmployerEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCardNumber;
    private String userName;
    private String companyName;

//
//    public int getIdCardNumber() {
//        return idCardNumber;
//    }
//
//    public void setIdCardNumber(int idCardNumber) {
//        this.idCardNumber = idCardNumber;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        userName = userName;
//    }
//
//    public String getCompanyName() {
//        return companyName;
//    }
//
//    public void setCompanyName(String companyName) {
//        this.companyName = companyName;
//    }
//
//
//    @Override
//    public String toString() {
//        return "EmployerEntity{" +
//                "idCardNumber=" + idCardNumber +
//                ", UserName='" + userName + '\'' +
//                ", companyName='" + companyName + '\'' +
//                '}';
//    }

}