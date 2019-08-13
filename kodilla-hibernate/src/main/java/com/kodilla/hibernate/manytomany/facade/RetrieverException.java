package com.kodilla.hibernate.manytomany.facade;

public class RetrieverException extends Exception {

    public static String ERR_RETRIVING_COMPANY = "Cannot retrieve company like this";
    public static String ERR__RETRIVING_EMPLOYEE = "Cannot retrieve employee like this";

    public RetrieverException(String message) {
        super(message);
    }
}
