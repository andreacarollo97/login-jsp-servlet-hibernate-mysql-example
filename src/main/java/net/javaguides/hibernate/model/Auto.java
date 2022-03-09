package net.javaguides.hibernate.model;

import java.io.Serializable;
import java.util.List;


import javax.persistence.*;

@Entity
@Table(name = "auto")
public class Auto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "targa")
    private String targa;

    @Column(name = "modello")
    private String modello;

    @Column(name = "marca")
    private String marca;

    @OneToMany(mappedBy = "auto")
    private List<Prenotazione> prenotazioni;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }
}