package models;
import io.ebean.Model;
import javax.persistence.*;
import java.util.List;

@Entity
public class Segmento extends Model {
    @Id
    public Long id;
    public String numeroSegmento;
    public String direccion;
    public Double longitud;

    @OneToMany(mappedBy = "segmento", cascade = CascadeType.ALL)
    public List<Calzada> calzadas;

    @OneToMany(mappedBy = "segmento", cascade = CascadeType.ALL)
    public List<Bordillo> bordillos;
}
