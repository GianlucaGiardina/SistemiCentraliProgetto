package unict.sistemicentrali.edu.bookingrestaurant.models;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "date")
    private LocalDateTime date;
    
    @Column(name = "num_guests")
    private int numGuests;
    
    // costruttori, getter e setter
    
    public Reservation() {
    }
    
    public Reservation(String name, String email, String phone, LocalDateTime date, int numGuests) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.date = date;
        this.numGuests = numGuests;
    }
    
    // getter e setter per tutti gli attributi
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public LocalDateTime getDate() {
        return date;
    }
    
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    public int getNumGuests() {
        return numGuests;
    }
    
    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }
}
