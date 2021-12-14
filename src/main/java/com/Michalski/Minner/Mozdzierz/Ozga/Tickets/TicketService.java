package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.Path;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@NoArgsConstructor
public class TicketService {
    private final AdvertisementRepository repository = new AdvertisementRepository();
    private final TicketRepository ticketRepository = new TicketRepository();

    public void buyTicket(User user, Advertisement ticket){
        ticketRepository.save(new Ticket(user, ticket, Calendar.getInstance(), new Path(ticket.getSections()),ticket.getPrice()*Discount.getDiscount(TicketType.ADULT)));
    }

    public void buyTicket(User user, Advertisement ticket, TicketType type){
        ticketRepository.save(new Ticket(user, ticket, Calendar.getInstance(), new Path(ticket.getSections()),ticket.getPrice()*Discount.getDiscount(type)));
    }

    public void buyTicket(@NotNull User user,@NotNull Advertisement advertisement, @NotNull Calendar date, TicketType type){

        Date dateNow = new Date();

        if(date.before(dateNow))
            throw new IllegalStateException("Can't buy ticket invalid date");

        ticketRepository.save(new Ticket(user, advertisement, date, new Path(advertisement.getSections()),advertisement.getPrice()*Discount.getDiscount(type)));
    }


    public void buyTicket(@NotNull User user,@NotNull Advertisement advertisement, @NotNull Calendar date){

        Date dateNow = new Date();

        if(date.before(dateNow))
            throw new IllegalStateException("Can't buy ticket invalid date");

        ticketRepository.save(new Ticket(user, advertisement, date, new Path(advertisement.getSections()),advertisement.getPrice()*Discount.getDiscount(TicketType.ADULT)));
    }

    public List<Ticket> getTicketHistory(User user){
        return ticketRepository.getByPredictor( f -> Objects.equals(f.getUser().getId(), user.getId()));
    }

    public void removeTicket(Long id){
        repository.removeById(id);
    }

    public boolean validateTicket(@NotNull Ticket ticket){

        Calendar dateNow = Calendar.getInstance();
        Calendar ticketCalendar = ticket.getDate();

        if(dateNow.get(Calendar.DAY_OF_MONTH) == ticketCalendar.get(Calendar.DAY_OF_MONTH) &&
        dateNow.get(Calendar.MONTH) == ticketCalendar.get(Calendar.MONTH) &&
        dateNow.get(Calendar.YEAR) == ticketCalendar.get(Calendar.YEAR) && !ticket.getIsTicketValidate())
        {
            ticket.setIsTicketValidate(true);
            return true;
        }
        return false;
    }

    public Optional<Ticket> getTicketById(Long id){
        return ticketRepository.getById(id);
    }

    public void exitZoo(Long id){
        Optional<Ticket> ticket = ticketRepository.getById(id);

        if(ticket.isEmpty())
            return;

        ticket.get().setIsTicketActive(false);
    }

}
