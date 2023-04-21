package unict.sistemicentrali.edu.bookingrestaurant.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import unict.sistemicentrali.edu.bookingrestaurant.data.ReservationRepository;
import unict.sistemicentrali.edu.bookingrestaurant.models.Reservation;

@Controller
public class ReservationController {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    @GetMapping("/")
    public String index(Model model) {
        List<Reservation> reservations = reservationRepository.findAll();
        model.addAttribute("reservations", reservations);
        return "index";
    }
    
    @GetMapping("/reservation")
    public String showReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation";
    }
    
    @PostMapping("/reservation")
    public String submitReservationForm(@ModelAttribute Reservation reservation, Model model) {
        reservationRepository.save(reservation);
        model.addAttribute("message", "Reservation submitted successfully!");
        return "success";
    }
    
}
