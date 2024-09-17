package models;

import io.ebean.Model;
import javax.persistence.*;

@Entity
public class Calzada extends Model {
    @Id
    public Long id;
    public String material;
    public Double ancho;

    @ManyToOne
    @JoinColumn(name = "segmento_id")
    public Segmento segmento;

    public static final Finder<Long, Calzada> find = new Finder<>(Calzada.class);
}
