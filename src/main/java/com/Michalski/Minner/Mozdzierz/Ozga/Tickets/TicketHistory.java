package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class TicketHistory {

    private Long id;
    //klucz obcy User
    private Long userID;

    private Long ticketId;



    private Date date;

    private Float price;
}