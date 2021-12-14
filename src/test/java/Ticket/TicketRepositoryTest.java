package Ticket;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.Path;
import com.Michalski.Minner.Mozdzierz.Ozga.Tickets.Advertisement;
import com.Michalski.Minner.Mozdzierz.Ozga.Tickets.Ticket;
import com.Michalski.Minner.Mozdzierz.Ozga.Tickets.TicketRepository;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import lombok.Setter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TicketRepositoryTest {

    @Setter
    private TicketRepository repository = new TicketRepository();

    @AfterEach
    public void remove(){
        repository.getByPredictor(f -> true).forEach(f -> repository.removeById(f.getId()));
        System.out.println("Wyczyszczono...");
    }


    @Test
    public void addTicket(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        Ticket ticket = new Ticket(user, advertisement1, Calendar.getInstance(), new Path(advertisement1.getSections()), 0.f);

        repository.save(ticket);

        Assertions.assertTrue(repository.getById(ticket.getId()).isPresent());
    }

    @Test
    public void updateTicket(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        Ticket ticket = new Ticket(user, advertisement1, Calendar.getInstance(), new Path(advertisement1.getSections()), 0.f);
        repository.save(ticket);

        Ticket ticket2 = new Ticket(user, advertisement1, Calendar.getInstance(), new Path(advertisement1.getSections()), 15.f);
        ticket2.setId(ticket.getId());

        repository.update(ticket2);

        Assertions.assertEquals(ticket, ticket2);
    }

    @Test
    public void removeTicket(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        Ticket ticket = new Ticket(user, advertisement1, Calendar.getInstance(), new Path(advertisement1.getSections()), 0.f);
        repository.save(ticket);

        Assertions.assertTrue(repository.getById(ticket.getId()).isPresent());

        repository.remove(ticket);

        Assertions.assertTrue(repository.getById(ticket.getId()).isEmpty());
    }

    @Test
    public void removeTicketById(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        Ticket ticket = new Ticket(user, advertisement1, Calendar.getInstance(), new Path(advertisement1.getSections()), 0.f);
        repository.save(ticket);

        Assertions.assertTrue(repository.getById(ticket.getId()).isPresent());

        repository.removeById(ticket.getId());

        Assertions.assertTrue(repository.getById(ticket.getId()).isEmpty());
    }

    @Test
    public void getTicketById(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        Ticket ticket = new Ticket(user, advertisement1, Calendar.getInstance(), new Path(advertisement1.getSections()), 0.f);
        repository.save(ticket);

        Assertions.assertTrue(repository.getById(ticket.getId()).isPresent());
    }
}
