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
    private int id;

    @Column(name = "targa")
    private String targa;

    @Column(name = "modello")
    private String modello;

    @Column(name = "marca")
    private String marca;

    @OneToMany(mappedBy = "auto")
    private List<Prenotazione> prenotazioni;

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public int getAuto_id() {
        return id;
    }

    public void setAuto_id(int id) {
        this.id = id;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
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
}