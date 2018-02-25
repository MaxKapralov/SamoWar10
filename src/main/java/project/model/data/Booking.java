package project.model.data;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_booking")
    private Long id;

    @Column(name = "id_car", nullable = false)
    private Long idCar;

    @Column(name = "id_user", nullable = false)
    private long idUser;

    @Column(name = "time_from", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date from;

    @Column(name = "time_to", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date to;

    @Column(nullable = false)
    private String status;

    public Booking() {}

    public Booking(Long idCar, long idUser, Date from, Date to, String status) {
        this.idCar = idCar;
        this.idUser = idUser;
        this.from = from;
        this.to = to;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
