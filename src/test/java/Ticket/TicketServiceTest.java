package Ticket;

import com.Michalski.Minner.Mozdzierz.Ozga.Tickets.*;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TicketServiceTest {

    private  TicketService service = new TicketService();
    private TicketRepository repository = new TicketRepository();
    private PromotionRepository advertisementRepository =  new PromotionRepository();

    @BeforeEach
    public void clear(){
        repository.getByPredictor(f -> true).forEach(f -> repository.removeById(f.getId()));
        advertisementRepository.getByPredictor(f -> true).forEach(f -> advertisementRepository.removeById(f.getId()));

        //zmienić na jakiegoś loggera
        System.out.println("Wyczyszczono...");
    }

    @Test
    public void buyTicket(){
        User user = new User( "", false, new Date(), "");
        Promotion promotion1 = new Promotion(1L, new BigDecimal("500."), new ArrayList<>());

        service.buyTicket(user, promotion1);

        List<Ticket> ticketHistory = service.getTicketHistory(user);

        Assertions.assertTrue(ticketHistory.size() > 0);

        Assertions.assertEquals(ticketHistory.get(0).getPrice(), promotion1.getPrice());
    }

    @Test
    public void buyTicketWithDiscount(){
        User user = new User( "", false, new Date(), "");
        Promotion promotion1 = new Promotion(1L, new BigDecimal("500."), new ArrayList<>());

        Discount.setDiscount(TicketType.KID, new BigDecimal("0.8"));

        service.buyTicket(user, promotion1, TicketType.KID);

        List<Ticket> ticketHistory = service.getTicketHistory(user);

        Assertions.assertTrue(ticketHistory.size() > 0);

        Assertions.assertEquals(ticketHistory.get(0).getPrice(), promotion1.getPrice().multiply(Discount.getDiscount(TicketType.KID)));
    }
    @Test
    public void buyTicketWithThrowAndDiscount(){
        User user = new User( "", false, new Date(), "");
        Promotion promotion1 = new Promotion(1L, new BigDecimal("500."), new ArrayList<>());

        Discount.setDiscount(TicketType.KID, new BigDecimal("0.8"));

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -100);

        Assertions.assertThrows(IllegalStateException.class, ()->{
            service.buyTicket(user, promotion1,cal,TicketType.KID);
        });

    }
    @Test
    public void buyTicketWithThrow(){
        User user = new User( "", false, new Date(), "");
        Promotion promotion1 = new Promotion(1L, new BigDecimal("500."), new ArrayList<>());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -100);

        Assertions.assertThrows(IllegalStateException.class, ()->{
            service.buyTicket(user, promotion1,cal);
        });

    }
    @Test
    public void getTicketHistory(){
        User user = new User( "", false, new Date(), "");
        Promotion promotion1 = new Promotion(1L, new BigDecimal("500."), new ArrayList<>());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);

        service.buyTicket(user, promotion1,cal);

        List<Ticket> tickets = service.getTicketHistory(user);

        Assertions.assertTrue(tickets.size() > 0);
    }
    @Test
    public void buyTicketWithCalendarAndDiscount(){
        User user = new User( "", false, new Date(), "");
        Promotion promotion1 = new Promotion(1L, new BigDecimal("500."), new ArrayList<>());

        Discount.setDiscount(TicketType.KID, new BigDecimal("0.8"));

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);

        service.buyTicket(user, promotion1,cal,TicketType.KID);

        List<Ticket> tickets = service.getTicketHistory(user);

        Assertions.assertTrue(tickets.size() > 0);

        Assertions.assertEquals(tickets.get(0).getPrice(), promotion1.getPrice().multiply(Discount.getDiscount(TicketType.KID)));
    }
    @Test
    public void buyTicketWithCalendar(){
        User user = new User( "", false, new Date(), "");
        Promotion promotion1 = new Promotion(1L, new BigDecimal("500."), new ArrayList<>());

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);

        service.buyTicket(user, promotion1,cal);

        List<Ticket> ticketHistory = service.getTicketHistory(user);

        Assertions.assertTrue(ticketHistory.size() > 0);

        Assertions.assertEquals(ticketHistory.get(0).getPrice(), promotion1.getPrice());

    }
    @Test
    public void removeTicket(){
        User user = new User( "", false, new Date(), "");
        Promotion promotion1 = new Promotion(1L, new BigDecimal("500."), new ArrayList<>());

        service.buyTicket(user, promotion1);

        List<Ticket> tickets = service.getTicketHistory(user);

        Assertions.assertTrue(tickets.size()>0);

        service.removeTicket(tickets.get(0).getId());

        Assertions.assertTrue(service.getTicketHistory(user).size()==0);
    }
    @Test
    public void validateTicket(){
        User user = new User( "", false, new Date(), "");
        Promotion promotion1 = new Promotion(1L, new BigDecimal("500."), new ArrayList<>());

        service.buyTicket(user, promotion1);

        List<Ticket> tickets = service.getTicketHistory(user);

        Assertions.assertTrue(service.validateTicket(tickets.get(0)));
    }
    @Test
    public void validateTicketWithInvalidDate(){
        User user = new User( "", false, new Date(), "");
        Promotion promotion1 = new Promotion(1L, new BigDecimal("500."), new ArrayList<>());
        //zmienić cal na calendar
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 10);

        service.buyTicket(user, promotion1,cal);

        List<Ticket> tickets = service.getTicketHistory(user);

        Assertions.assertFalse(service.validateTicket(tickets.get(0)));
    }
    @Test
    public  void exitZoo(){
        User user = new User( "", false, new Date(), "");
        Promotion promotion1 = new Promotion(1L, new BigDecimal("500."), new ArrayList<>());

        service.buyTicket(user, promotion1);

        List<Ticket> tickets = service.getTicketHistory(user);

        service.exitZoo(tickets.get(0).getId());
        //jeżeli klient jest w zoo sprawdzić
        Assertions.assertFalse(tickets.get(0).getIsTicketActive());
    }





}
