package com.fitness.tracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nume;
    private LocalDate dataNastere;//varsta se actualizeaza cu trecerea timpului
    @Enumerated(EnumType.STRING)
    private Gen gen;
    private double greutate;
    private int inaltime; //salvam in cm
    @Enumerated(EnumType.STRING)
    private Obiectiv obiectiv;

    public UserProfile(){};

    public UserProfile(String nume, LocalDate dataNastere, Gen gen, double greutate, int inaltime, Obiectiv
                       obiectiv) {
        this.nume = nume;
        this.dataNastere = dataNastere;
        this.gen = gen;
        this.greutate = greutate;
        this.inaltime = inaltime;
        this.obiectiv = obiectiv;
    }

    public Long getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public LocalDate getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(LocalDate dataNastere) {
        this.dataNastere = dataNastere;
    }

    public Gen getGen() {
        return gen;
    }

    public void setGen(Gen gen) {
        this.gen = gen;
    }

    public double getGreutate() {
        return greutate;
    }

    public void setGreutate(double greutate) {
        this.greutate = greutate;
    }

    public int getInaltime() {
        return inaltime;
    }

    public void setInaltime(int inaltime) {
        this.inaltime = inaltime;
    }

    public Obiectiv getObiectiv() {
        return obiectiv;
    }

    public void setObiectiv(Obiectiv obiectiv) {
        this.obiectiv = obiectiv;
    }
}
