package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.Path;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import lombok.*;

import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Ticket {

    private Long id;
    //klucz obcy User
    private User user;

    private Advertisement advertisement;

    private Calendar date;

    private Path path;

    private Float price;

    private Boolean isTicketValidate = false;
    private Boolean isTicketActive = true;

    public Ticket(User user, Advertisement advertisement, Calendar date, Path path, Float price) {
        this.user = user;
        this.advertisement = advertisement;
        this.date = date;
        this.path = path;
        this.price = price;
    }
}