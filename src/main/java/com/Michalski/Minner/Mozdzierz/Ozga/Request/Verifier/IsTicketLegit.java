package com.Michalski.Minner.Mozdzierz.Ozga.Request.Verifier;

public class IsTicketLegit {
    private WasTicketUsed wasTicketUsed = new WasTicketUsed();


    void check(boolean isTicketLegit, boolean isUsedTicket){
        if(isTicketLegit)
            wasTicketUsed.wasTicketUsed(isUsedTicket);

        System.out.println("Odrzucenie reklamacji...");
    }

}
