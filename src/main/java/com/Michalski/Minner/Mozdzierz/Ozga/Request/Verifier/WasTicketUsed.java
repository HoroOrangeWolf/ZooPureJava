package com.Michalski.Minner.Mozdzierz.Ozga.Request.Verifier;

public class WasTicketUsed {
    private IsAcceptedByBOK isAcceptedByBOK = new IsAcceptedByBOK();

    public void wasTicketUsed(boolean isTickedUsed){
        if(isTickedUsed)
            isAcceptedByBOK.acceptRefund();
        System.out.println("Odrzucenie reklamacji...");
    }


}
