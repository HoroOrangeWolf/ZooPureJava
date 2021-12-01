package com.Michalski.Minner.Mozdzierz.Ozga.Notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notification {
    private Long id;

    private Long idUser;

    private String text;

    private String type;

    private boolean isRead;
}
