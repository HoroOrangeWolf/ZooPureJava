package com.Michalski.Minner.Mozdzierz.Ozga.Request.Verifier;

public class CheckIsTicketBoughtOnline {

    private final WasTicketUsed wasTicketUsed = new WasTicketUsed();
    private final IsTicketImageInAttachment isTicketImageInAttachment = new IsTicketImageInAttachment();

    public void check(boolean isTicketBoughtOnline, boolean isTicketUsed, boolean isattachemnt, boolean islegitTicket){

        if(isTicketBoughtOnline)
            wasTicketUsed.wasTicketUsed(isTicketUsed);
        else
            isTicketImageInAttachment.check(isattachemnt, isTicketUsed, islegitTicket);

    }


}
