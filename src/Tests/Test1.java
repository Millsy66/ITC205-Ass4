package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import hotel.credit.CreditCard;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Room;
import hotel.entities.RoomType;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class Test1 {

    Booking booking;
    //@Mock Room room;
    @Mock Guest guest;
    @Mock CreditCard creditCard;
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    
    @Spy ArrayList<Booking> bookings;
    @InjectMocks Room room = new Room(101, RoomType.SINGLE);

    
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        
        Date date = format.parse("01-10-2018");
        
        //room = new Room(101, RoomType.SINGLE);
        booking = new Booking(guest, room, date, 0, 0, creditCard);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void test() {
      //arrange        
        booking.checkIn();
                
        //act
        Executable executable = () -> booking.checkIn();        
                
        //assert
        assertThrows(RuntimeException.class, executable);
    }

}
