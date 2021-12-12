package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
public class TicketService {
    private final TicketRepository repository = new TicketRepository();
    private final TicketHistoryRepository ticketHistoryRepository = new TicketHistoryRepository();

    public void buyTicket(User user, Ticket ticket){
        ticketHistoryRepository.save(new TicketHistory(1L,user.getId(), ticket.getId(), new Date(), ticket.getPrice()));

    }

    public List<TicketHistory> getTicketHistory(User user){
        return ticketHistoryRepository.getByPredictor( f -> Objects.equals(f.getUserID(), user.getId()));
    }

    public void removeTicket(Long id){
        repository.removeById(id);
    }


}
