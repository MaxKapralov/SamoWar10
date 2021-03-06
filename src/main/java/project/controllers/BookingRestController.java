package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.data.Booking;
import project.model.repositories.BookingRepository;

import java.util.List;

@RestController
public class BookingRestController {

    private BookingRepository bookingRepository;

    @Autowired
    public void setBookingRepository(BookingRepository repository)
    {
        this.bookingRepository = repository;
    }


    @PostMapping(path = "/booking")
    public ResponseEntity<Void> saveBooking(@RequestBody Booking booking)
    {
        bookingRepository.save(booking);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/booking")
    public ResponseEntity<List<Booking>> getUsersBooking(@RequestParam(value = "idUser", required = false) Long idUser, @RequestParam(value = "idCar", required = false) Long idCar)
    {
        //add booking with date
        if(idUser != null && idCar != null)
            return ResponseEntity.status(HttpStatus.OK).body(bookingRepository.findWithIdCarAndIdUser(idCar, idUser));
        else if(idUser != null)
            return ResponseEntity.status(HttpStatus.OK).body(bookingRepository.findWithIdUser(idUser));
        else if(idCar != null)
            return ResponseEntity.status(HttpStatus.OK).body(bookingRepository.findWithIdCar(idCar));
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
    }


}
