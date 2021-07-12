package com.example.demo.Model.audit;

import javax.persistence.*;


@Entity
@Table
public class DataMeja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String Kd_Meja;
    public int Harga_Sewa;
    public String Kapasitas;
    public String Fasilitas;
    public String Status_Sewa;
    public String KodeMeja;

    public String getKodeMeja() {
        return KodeMeja;
    }

    public void setKodeMeja(String kodeMeja) {
        KodeMeja = kodeMeja;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKd_Meja() {
        return Kd_Meja;
    }

    public void setKd_Meja(String kd_Meja) {
        Kd_Meja = kd_Meja;
    }

    public int getHarga_Sewa() {
        return Harga_Sewa;
    }

    public void setHarga_Sewa(int harga_Sewa) {
        Harga_Sewa = harga_Sewa;
    }

    public String getKapasitas() {
        return Kapasitas;
    }

    public void setKapasitas(String kapasitas) {
        Kapasitas = kapasitas;
    }

    public String getFasilitas() {
        return Fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        Fasilitas = fasilitas;
    }
    public String getStatus_Sewa() {
        return Status_Sewa;
    }

    public void setStatus_Sewa(String status_Sewa) {
        Status_Sewa = status_Sewa;
    }




}
