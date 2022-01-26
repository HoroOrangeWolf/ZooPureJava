package com.Michalski.Minner.Mozdzierz.Ozga.Request;

import com.Michalski.Minner.Mozdzierz.Ozga.Observer.Notifier;
import com.Michalski.Minner.Mozdzierz.Ozga.Request.Verifier.CheckIsTicketBoughtOnline;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import lombok.*;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Request extends Notifier {

    private Long id;

    private Status status = Status.NIEROZPATRZONY;

    private String text;

    private User user;

    private User bokUser = null;

    private String answer;

    @EqualsAndHashCode.Exclude
    CheckIsTicketBoughtOnline checkIsTicketBoughtOnline = new CheckIsTicketBoughtOnline();

    public Request(String text, User user) {
        this.text = text;
        this.user = user;
    }
}