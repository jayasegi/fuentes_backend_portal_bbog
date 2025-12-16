package com.portal.api.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class CursosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id_curso")
    private Long idCurso;
    
    @Column(nullable = false, name = "nombre_curso")
    private String nombreCurso;

    //private String description;
    //private String badgeImage;

    @ManyToOne(fetch = FetchType.EAGER) //FetchType.LAZY
    @JoinColumn(name = "modulo_id", nullable = false)
    private ModulosEntity modulo;
    
    /* Getters & Setters */
	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public ModulosEntity getModulo() {
		return modulo;
	}

	public void setModulo(ModulosEntity modulo) {
		this.modulo = modulo;
	}

    //@OneToMany(mappedBy = "course")
    //private List<CursosUsuarioEntity> userCourses;
}
