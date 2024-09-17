package models;

import io.ebean.Model;
import javax.persistence.*;

@Entity
public class Bordillo extends Model {
    @Id
    public Long id;
    public String tipo;
    public Double altura;

    @ManyToOne
    @JoinColumn(name = "segmento_id")
    public Segmento segmento;

    public static final Finder<Long, Bordillo> find = new Finder<>(Bordillo.class);
}
