package com.example.demo.Model.audit;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tempattersewa")
public class TempatTersewa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne (fetch = FetchType.LAZY, targetEntity = DataMember.class)
    @JoinColumn (name = "DataMember_id")
    DataMember dataMember;

    @ManyToOne (fetch = FetchType.LAZY, targetEntity = DataMeja.class)
    @JoinColumn (name = "DataMeja_id")
    DataMeja dataMeja;

    public int TotalBayar;
    public Date JamAwal;
    public Date JamAkhir;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getTotalBayar() {
        return TotalBayar;
    }

    public void setTotalBayar(int totalBayar) {
        TotalBayar = totalBayar;
    }

    public Date getJamAwal() {
        return JamAwal;
    }

    public void setJamAwal(Date jamAwal) {
        JamAwal = jamAwal;
    }

    public Date getJamAkhir() {
        return JamAkhir;
    }

    public void setJamAkhir(Date jamAkhir) {
        JamAkhir = jamAkhir;
    }
}
