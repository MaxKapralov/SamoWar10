package project.model.data;

import javax.persistence.*;

/**
 * Created by Maksim Kapralov on 5/22/2018.
 */
@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_image", nullable = false)
    private Long id;

    @Column(name = "id_car", nullable = false)
    private Long idCar;

    private String path;

    public Image(){}

    public Image(Long idCar, String path)
    {
        this.idCar = idCar;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
