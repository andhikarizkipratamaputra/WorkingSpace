package com.example.demo.Model.audit;

import javax.persistence.*;

@Entity
@Table (name = "datamember")
public class DataMember {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getUmur() {
        return Umur;
    }

    public void setUmur(int umur) {
        Umur = umur;
    }

    public int getNomer_Telp() {
        return Nomer_Telp;
    }

    public void setNomer_Telp(int nomer_Telp) {
        Nomer_Telp = nomer_Telp;
    }

    public String getJenis_Kelamin() {
        return Jenis_Kelamin;
    }

    public void setJenis_Kelamin(String jenis_Kelamin) {
        Jenis_Kelamin = jenis_Kelamin;
    }

    public String getPekerjaan() {
        return Pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        Pekerjaan = pekerjaan;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long id;
    public String Nama;
    public String Email;
    public String Password;
    public int Umur;
    public int Nomer_Telp;
    public String Jenis_Kelamin;
    public String Pekerjaan;

}
