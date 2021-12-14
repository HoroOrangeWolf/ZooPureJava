package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

public class Discount {

    private static Float adult = 0.f, kid = 0.f, student = 0.f;

    private Discount(){}

    public static void setDiscount(TicketType type, Float discountPercentage){

        switch (type){
            case STUDENT -> student = discountPercentage;
            case KID -> kid = discountPercentage;
            case ADULT ->  adult = discountPercentage;
        }
    }

    public static float getDiscount(TicketType type){
        return switch (type){
            case KID -> 1.0f - kid;
            case STUDENT -> 1.0f - student;
            case ADULT -> 1.0f - adult;
        };
    }

}
