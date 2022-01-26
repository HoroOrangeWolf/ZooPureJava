package com.Michalski.Minner.Mozdzierz.Ozga.Request.Verifier;

public class IsTicketImageInAttachment {

        private IsTicketLegit isTicketLegit = new IsTicketLegit();

        public void check(boolean isAttachment, boolean isTicketUsed, boolean isLegitTicket){

            if(isAttachment)
                isTicketLegit.check(isLegitTicket, isTicketUsed);

                System.out.println("Odrzucenie reklamacji...");
        }

}
