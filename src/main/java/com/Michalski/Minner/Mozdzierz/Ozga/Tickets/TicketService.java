package com.Michalski.Minner.Mozdzierz.Ozga.Tickets;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.Path;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@NoArgsConstructor
public class TicketService {
    private final PromotionRepository advertisementRepository = new PromotionRepository();
    private final TicketRepository ticketRepository = new TicketRepository();

    public void buyTicket(User user, Promotion ticket){
        ticketRepository.save(new Ticket(user, ticket, Calendar.getInstance(), new Path(ticket.getSections()),ticket.getPrice().multiply(Discount.getDiscount(TicketType.ADULT))));
    }

    public void buyTicket(User user, Promotion ticket, TicketType type){
        Ticket ticket1 = new Ticket(user, ticket, Calendar.getInstance(), new Path(ticket.getSections()),ticket.getPrice().multiply(Discount.getDiscount(type)));
        ticketRepository.save(ticket1);
    }

    public void buyTicket(@NotNull User user, @NotNull Promotion promotion, @NotNull Calendar date, TicketType type){
        Date calendar = Calendar.getInstance().getTime();
        if(date.getTime().getTime() < calendar.getTime())
            throw new IllegalStateException("Can't buy ticket invalid date");

        ticketRepository.save(new Ticket(user, promotion, date, new Path(promotion.getSections()), promotion.getPrice().multiply(Discount.getDiscount(type))));
    }


    public void buyTicket(@NotNull User user, @NotNull Promotion promotion, @NotNull Calendar date){
        Date calendar = Calendar.getInstance().getTime();
        if(date.getTime().getTime() < calendar.getTime())
            throw new IllegalStateException("Can't buy ticket invalid date");

        ticketRepository.save(new Ticket(user, promotion, date, new Path(promotion.getSections()), promotion.getPrice().multiply(Discount.getDiscount(TicketType.ADULT))));
    }

    public List<Ticket> getTicketHistory(User user){
        return ticketRepository.getByPredictor( f -> Objects.equals(f.getUser().getId(), user.getId()));
    }

    public void removeTicket(Long id){
        ticketRepository.removeById(id);
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
