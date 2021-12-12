package com.Michalski.Minner.Mozdzierz.Ozga.Notification;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Notification {
    private Long id;

    private Long idUser;

    private String text;

    private String type;

    private boolean isRead;
}
