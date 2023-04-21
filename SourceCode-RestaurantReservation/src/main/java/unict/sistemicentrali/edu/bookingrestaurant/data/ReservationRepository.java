package unict.sistemicentrali.edu.bookingrestaurant.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unict.sistemicentrali.edu.bookingrestaurant.models.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    
    List<Reservation> findAll();
    
}
