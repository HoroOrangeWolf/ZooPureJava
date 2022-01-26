package Map;

import com.Michalski.Minner.Mozdzierz.Ozga.Map.InfoZone.Section;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.MapService;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone.AfricanariumSectionCreator;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.MapZone.SectionCreator;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.Path;
import com.Michalski.Minner.Mozdzierz.Ozga.Map.PathElement;
import com.Michalski.Minner.Mozdzierz.Ozga.Tickets.Promotion;
import com.Michalski.Minner.Mozdzierz.Ozga.Tickets.Ticket;
import com.Michalski.Minner.Mozdzierz.Ozga.Tickets.TicketRepository;
import com.Michalski.Minner.Mozdzierz.Ozga.User.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

public class MapServiceTest {

    private final MapService service = new MapService();
    private final TicketRepository repository = new TicketRepository();
    private static Ticket ticket;
    private static List<Section> list = new ArrayList<>();
    @BeforeEach
    public void addNew(){

        SectionCreator sectionCreator = new AfricanariumSectionCreator();

        Section section1 = sectionCreator.createSection();

        section1.setUp(1L, "Tu są rybki", true, 1.f, 1.f);

        Section section2 = sectionCreator.createSection();

        section2.setUp(1L, "Tu są lwy", true, 1.f, 1.f);


        Section section3 = sectionCreator.createSection();

        section3.setUp(1L, "Tu są małpy", true, 1.f, 1.f);


        Section section4 = sectionCreator.createSection();

        section4.setUp(1L, "Tu są żyrafy", true, 1.f, 1.f);



        list = Arrays.asList(section1, section2, section3, section4);

        Promotion promotion = new Promotion(1L, new BigDecimal("255."), list);

        User user = new User("Test1", false, new Date(), "");

        Path path = new Path(list);

        ticket = new Ticket(user, promotion, Calendar.getInstance(), path, promotion.getPrice());

        repository.save(ticket);

    }

    @AfterEach
    public void clear(){
        repository.getByPredictor(f -> true).forEach(f->repository.removeById(f.getId()));
    }

    @Test
    public void getNext(){
        PathElement element = service.getNext(ticket.getId());
        Section st = list.get(0);

        //Assertions.assertTrue(first.isPresent());

        Assertions.assertEquals(element.getSection(), st);
    }

    @Test
    public void getNextAll(){
        for(int s = 0; s < list.size(); s++) {
            Assertions.assertNotNull(service.getNext(ticket.getId()));
        }

        Assertions.assertNull(service.getNext(ticket.getId()));
    }

    @Test
    public void getPrev(){
        for(int s = 0; s < list.size(); s++) {
            Assertions.assertNotNull(service.getNext(ticket.getId()));
        }
        List<PathElement> elements = ticket.getPath().getPathElements();
        Assertions.assertEquals(elements.get(elements.size() - 1),service.getPrev(ticket.getId()));
    }

    @Test
    public void setVisited(){
        PathElement element = service.getNext(ticket.getId());
        service.setVisited(ticket.getId());

        PathElement current = service.getCurrent(ticket.getId());

        Assertions.assertTrue(element.getIsVisited());
    }
    @Test
    public void setVisitedWithAditionalParamFalse(){
        PathElement element = service.getNext(ticket.getId());
        service.setVisited(ticket.getId(), false);

        PathElement current = service.getCurrent(ticket.getId());

        Assertions.assertFalse(element.getIsVisited());
    }

    @Test
    public void setVisitedWithAditionalParamTrue(){
        PathElement element = service.getNext(ticket.getId());
        service.setVisited(ticket.getId(), true);

        PathElement current = service.getCurrent(ticket.getId());

        Assertions.assertTrue(element.getIsVisited());
    }

    @Test
    public void setVisitedWithAditionalParamException(){

        Assertions.assertThrows(IllegalStateException.class, ()->{
            service.setVisited(ticket.getId(), false);
        }, "Podroz sie nie zaczela!");


        Assertions.assertThrows(IllegalStateException.class, ()->{
            service.setVisited(ticket.getId(), true);
        }, "Podroz sie nie zaczela!");

    }

    @Test
    public void setVisitedIllegalStateException(){

        Assertions.assertThrows(IllegalStateException.class, ()->{
            service.setVisited(ticket.getId());
        }, "Podroz sie nie zaczela!");

    }

    @Test
    public void getCurrent(){
        service.getNext(ticket.getId());

        Path path = ticket.getPath();
        List<PathElement> elements = path.getPathElements();

        Assertions.assertEquals(elements.get(0), service.getCurrent(ticket.getId()));
    }

    @Test
    public void getCurrentNotBeginException(){
        Assertions.assertThrows(IllegalStateException.class, ()->{
            service.getCurrent(ticket.getId());
        }, "Podroz sie jeszcze nie zaczela");
    }

    @Test
    public void getCurrentEndException(){
        for(int i = 0; i < list.size();++i)
            Assertions.assertNotNull(service.getNext(ticket.getId()));

        Assertions.assertThrows(IllegalStateException.class, ()->{
            service.getCurrent(ticket.getId());
        }, "Podroz sie skonczyla");
    }

    @Test
    public void getUnvisitedSections(){

        Assertions.assertNotNull(service.getNext(ticket.getId()));

        service.setVisited(ticket.getId());

        for(int i = 1; i < list.size(); ++i)
            Assertions.assertNotNull(service.getNext(ticket.getId()));

        service.setVisited(ticket.getId());

        List<PathElement> pathElements = service.getUnvisitedSections(ticket.getId());

        List<PathElement> elements = ticket.getPath().getPathElements();

        Assertions.assertFalse(pathElements.contains(elements.get(0)));

        Assertions.assertFalse(pathElements.contains(elements.get(elements.size() - 1)));

    }

}
