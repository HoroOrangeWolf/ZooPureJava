package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.Path;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import lombok.*;

import java.math.BigDecimal;
import java.util.Calendar;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Ticket {

    private Long id;
    //klucz obcy User
    private User user;

    private Promotion promotion;

    private Calendar date;

    private Path path;
    //Poprawić na big decimal <<dokładonośc>>
    private BigDecimal price;

    private Boolean isTicketValidate = false;
    private Boolean isTicketActive = true;

    public Ticket(User user, Promotion promotion, Calendar date, Path path, BigDecimal price) {
        this.user = user;
        this.promotion = promotion;
        this.date = date;
        this.path = path;
        this.price = price;
    }
}