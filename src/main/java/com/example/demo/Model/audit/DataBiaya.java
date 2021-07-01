package com.example.demo.Model.audit;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "databiaya")
public class DataBiaya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne (fetch = FetchType.LAZY, targetEntity = DataMember.class)
    @JoinColumn (name = "DataMember_id")
    DataMember dataMember;

    @ManyToOne (fetch = FetchType.LAZY, targetEntity = DataMeja.class)
    @JoinColumn (name = "DataMeja_id")
    DataMeja dataMeja;



    public int Biaya_Sewa;
    public String StatusSewa;
    public String KapasitasSewa;
    public String FasilitasSewa;
    public Date JamSewa;
    public Date JamSelesai;
    public Boolean isAvailable;

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public DataMember getDataMember() {
        return dataMember;
    }

    public void setDataMember(DataMember dataMember) {
        this.dataMember = dataMember;
    }

    public DataMeja getDataMeja() {
        return dataMeja;
    }

    public void setDataMeja(DataMeja dataMeja) {
        this.dataMeja = dataMeja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBiaya_Sewa() {
        return Biaya_Sewa;
    }

    public void setBiaya_Sewa(int biaya_Sewa) {
        Biaya_Sewa = biaya_Sewa;
    }

    public String getStatusSewa() {
        return StatusSewa;
    }

    public void setStatusSewa(String statusSewa) {
        StatusSewa = statusSewa;
    }

    public String getKapasitasSewa() {
        return KapasitasSewa;
    }

    public void setKapasitasSewa(String kapasitasSewa) {
        KapasitasSewa = kapasitasSewa;
    }

    public String getFasilitasSewa() {
        return FasilitasSewa;
    }

    public void setFasilitasSewa(String fasilitasSewa) {
        FasilitasSewa = fasilitasSewa;
    }

    public Date getJamSewa() {
        return JamSewa;
    }

    public void setJamSewa(Date jamSewa) {
        JamSewa = jamSewa;
    }

    public Date getJamSelesai() {
        return JamSelesai;
    }

    public void setJamSelesai(Date jamSelesai) {
        JamSelesai = jamSelesai;
    }


}
