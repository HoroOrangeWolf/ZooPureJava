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
    private TicketService service;

    public PathElement getNext(Long id){
        Optional<Ticket> ticketById = service.getTicketById(id);

        if(ticketById.isEmpty())
            return null;

        Path path = ticketById.get().getPath();

        List<PathElement> elementList = path.getPathElements();

        int index = path.getPathIndex();

        if((index + 1) >= elementList.size())
            return null;

        path.setPathIndex(path.getPathIndex() + 1);

        return elementList.get(index + 1);
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

        int index = path.getPathIndex();

        elementList.get(index).setIsVisited(true);
    }

    public void setVisited(Long id, Boolean isVisited){
        Optional<Ticket> ticketById = service.getTicketById(id);

        if(ticketById.isEmpty())
            return;

        Path path = ticketById.get().getPath();

        List<PathElement> elementList = path.getPathElements();

        int index = path.getPathIndex();

        elementList.get(index).setIsVisited(isVisited);
    }
}
