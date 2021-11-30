package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
public class TicketHistory {

    private Long id;
    //klucz obcy User
    private Long userID;

    private Long ticketId;

    private Date date;

    private Float price;
}