package com.Michalski.Minner.Mozdzierz.Ozga.Request;

import com.Michalski.Minner.Mozdzierz.Ozga.Observer.Notifier;
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

    private String answer;

    public Request(String text, User user) {
        this.text = text;
        this.user = user;
    }
}