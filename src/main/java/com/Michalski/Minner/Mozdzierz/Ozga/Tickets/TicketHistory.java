package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class TicketHistory {

    private Long id;
    //klucz obcy User
    private Long userID;

    private Long ticketId;

    private Date date;

    private Float price;
}