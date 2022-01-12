package com.Michalski.Minner.Mozdzierz.Ozga.Map;

import com.Michalski.Minner.Mozdzierz.Ozga.Tickets.Ticket;
import com.Michalski.Minner.Mozdzierz.Ozga.Tickets.TicketService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
public class MapService {
    private TicketService service = new TicketService();

    //zamienić id na ticket
    public PathElement getNext(Long id){
        Optional<Ticket> ticketById = service.getTicketById(id);

        if(ticketById.isEmpty())
            return null;

        Path path = ticketById.get().getPath();

        List<PathElement> elementList = path.getPathElements();

        int index = path.getPathIndex();
        if((index) >= elementList.size())
            return null;

        path.setPathIndex(path.getPathIndex() + 1);
        return elementList.get(index);
    }

    public PathElement getPrev(Long id){
        Optional<Ticket> ticketById = service.getTicketById(id);

        if(ticketById.isEmpty())
            return null;

        Path path = ticketById.get().getPath();

        List<PathElement> elementList = path.getPathElements();

        int index = path.getPathIndex();

        if((index - 1) <= 0)
            return null;

        path.setPathIndex(path.getPathIndex() - 1);

        return elementList.get(index - 1);
    }

    public void setVisited(Long id){
        Optional<Ticket> ticketById = service.getTicketById(id);

        if(ticketById.isEmpty())
            return;

        Path path = ticketById.get().getPath();

        List<PathElement> elementList = path.getPathElements();

        int index = path.getPathIndex() - 1;

        if(index<0)
            throw new IllegalStateException("Podroz sie nie zaczela!");

        elementList.get(index).setIsVisited(true);
    }

    public PathElement getCurrent(Long id){
        Optional<Ticket> ticketById = service.getTicketById(id);

        if(ticketById.isEmpty())
            return null;

        Path path = ticketById.get().getPath();

        List<PathElement> elementList = path.getPathElements();

        int index = path.getPathIndex() - 1;

        if(index < 0)
            throw new IllegalStateException("Podroz sie jeszcze nie zaczela");

        if(index == elementList.size() - 1)
            throw new IllegalStateException("Podroz sie skonczyla");

        return elementList.get(index);
    }

    public void setVisited(Long id, Boolean isVisited){
        Optional<Ticket> ticketById = service.getTicketById(id);

        if(ticketById.isEmpty())
            return;

        Path path = ticketById.get().getPath();

        List<PathElement> elementList = path.getPathElements();

        int index = path.getPathIndex() - 1;

        if(index<0)
            throw new IllegalStateException("Podroz sie nie zaczela!");

        elementList.get(index).setIsVisited(isVisited);
    }

    public List<PathElement> getUnvisitedSections(Long idTicket){
        Optional<Ticket> ticketById = service.getTicketById(idTicket);

        if(ticketById.isEmpty())
            return null;

        Ticket ticket = ticketById.get();

        return ticket.getPath().getPathElements().stream().filter(f -> !f.getIsVisited()).toList();
    }

}
