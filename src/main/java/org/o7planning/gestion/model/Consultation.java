package org.o7planning.gestion.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "consultations")
public class Consultation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "type")
    private String type;
	
	@Column(name = "prix")
    private double prix;

    @Column(name = "date")
    private String date;

    @ManyToOne
    private Medecin medecin;
    
    @ManyToOne
    private Malade malade;
    
    //@Column(name = "id_Malade")
    //private long id_Malade;


	public long getId() {
		return id;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Malade getMalade() {
		return malade;
	}

	public void setMalade(Malade malade) {
		this.malade = malade;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return ""+ medecin;
	}

//	public long getId_Medecin() {
//		return id_Medecin;
//	}
//
//	public void setId_Medecin(long id_Medecin) {
//		this.id_Medecin = id_Medecin;
//	}
//
//	public long getId_Malade() {
//		return id_Malade;
//	}
//
//	public void setId_Malade(long id_Malade) {
//		this.id_Malade = id_Malade;
//	}
    
    


}
