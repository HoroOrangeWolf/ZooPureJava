package Ticket;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.Path;
import com.Michalski.Minner.Mozdzierz.Ozga.Tickets.*;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TicketServiceTest {

    private  TicketService service = new TicketService();
    private TicketRepository repository = new TicketRepository();
    private AdvertisementRepository advertisementRepository =  new AdvertisementRepository();

    @BeforeEach
    public void clear(){
        repository.getByPredictor(f -> true).forEach(f -> repository.removeById(f.getId()));
        advertisementRepository.getByPredictor(f -> true).forEach(f -> advertisementRepository.removeById(f.getId()));
        System.out.println("Wyczyszczono...");
    }

    @Test
    public void buyTicket(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        service.buyTicket(user, advertisement1);

        List<Ticket> ticketHistory = service.getTicketHistory(user);

        Assertions.assertTrue(ticketHistory.size() > 0);

        Assertions.assertEquals(ticketHistory.get(0).getPrice(), advertisement1.getPrice());
    }

    @Test
    public void buyTicketWithDiscount(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        Discount.setDiscount(TicketType.KID, 0.8f);

        service.buyTicket(user, advertisement1, TicketType.KID);

        List<Ticket> ticketHistory = service.getTicketHistory(user);

        Assertions.assertTrue(ticketHistory.size() > 0);

        Assertions.assertEquals(ticketHistory.get(0).getPrice(), advertisement1.getPrice()*Discount.getDiscount(TicketType.KID));
    }
    @Test
    public void buyTicketWithThrowAndDiscount(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        Discount.setDiscount(TicketType.KID, 0.8f);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -100);

        Assertions.assertThrows(IllegalStateException.class, ()->{
            service.buyTicket(user,advertisement1,cal,TicketType.KID);
        });

    }
    @Test
    public void buyTicketWithThrow(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -100);

        Assertions.assertThrows(IllegalStateException.class, ()->{
            service.buyTicket(user,advertisement1,cal);
        });

    }
    @Test
    public void getTicketHistory(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);

        service.buyTicket(user,advertisement1,cal);

        List<Ticket> tickets = service.getTicketHistory(user);

        Assertions.assertTrue(tickets.size() > 0);
    }
    @Test
    public void buyTicketWithCalendarAndDiscount(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        Discount.setDiscount(TicketType.KID, 0.8f);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);

        service.buyTicket(user,advertisement1,cal,TicketType.KID);

        List<Ticket> tickets = service.getTicketHistory(user);

        Assertions.assertTrue(tickets.size() > 0);

        Assertions.assertEquals(tickets.get(0).getPrice(), advertisement1.getPrice()*Discount.getDiscount(TicketType.KID));
    }
    @Test
    public void buyTicketWithCalendar(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);

        service.buyTicket(user,advertisement1,cal);

        List<Ticket> ticketHistory = service.getTicketHistory(user);

        Assertions.assertTrue(ticketHistory.size() > 0);

        Assertions.assertEquals(ticketHistory.get(0).getPrice(), advertisement1.getPrice());

    }
    @Test
    public void removeTicket(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        service.buyTicket(user, advertisement1);

        List<Ticket> tickets = service.getTicketHistory(user);

        Assertions.assertTrue(tickets.size()>0);

        service.removeTicket(tickets.get(0).getId());

        Assertions.assertTrue(service.getTicketHistory(user).size()==0);
    }
    @Test
    public void validateTicket(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        service.buyTicket(user, advertisement1);

        List<Ticket> tickets = service.getTicketHistory(user);

        Assertions.assertTrue(service.validateTicket(tickets.get(0)));
    }
    @Test
    public void validateTicketWithInvalidDate(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 10);

        service.buyTicket(user,advertisement1,cal);

        List<Ticket> tickets = service.getTicketHistory(user);

        Assertions.assertFalse(service.validateTicket(tickets.get(0)));
    }
    @Test
    public  void exitZoo(){
        User user = new User(1L, "", false, new Date(), "");
        Advertisement advertisement1 = new Advertisement(1L, 500.f, new ArrayList<>());

        service.buyTicket(user, advertisement1);

        List<Ticket> tickets = service.getTicketHistory(user);

        service.exitZoo(tickets.get(0).getId());

        Assertions.assertFalse(tickets.get(0).getIsTicketActive());
    }





}
