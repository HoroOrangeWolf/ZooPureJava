package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import java.math.BigDecimal;

public class Discount {

    private static BigDecimal adult = new BigDecimal("0."), kid = new BigDecimal("0."), student = new BigDecimal("0.");

    private Discount(){}

    public static void setDiscount(TicketType type, BigDecimal discountPercentage){

        switch (type){
            case STUDENT -> student = discountPercentage;
            case KID -> kid = discountPercentage;
            case ADULT ->  adult = discountPercentage;
        }
    }

    public static BigDecimal getDiscount(TicketType type){
        BigDecimal decimal = new BigDecimal(1);
        return switch (type){
            case KID -> decimal.subtract(kid);
            case STUDENT -> decimal.subtract(student);
            case ADULT -> decimal.subtract(adult);
        };
    }

}
