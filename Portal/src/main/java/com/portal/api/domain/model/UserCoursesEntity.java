package com.portal.api.domain.model;


import jakarta.persistence.*;

@Entity
@Table(name = "cursos_usuario")
public class UserCoursesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id_curso_usuario")
    private Long idCursoUsuario;
    
    //@Column(nullable = false, name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER) //FetchType.LAZY
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
    
    @ManyToOne(fetch = FetchType.EAGER) //FetchType.LAZY
    @JoinColumn(name = "curso_id", nullable = false)
    private CursosEntity curso;
    
    @Column(nullable = false, name = "estado")
    //@Enumerated(EnumType.STRING)
    private String estado;

    @Column(name = "fecha_estado")
    private String fechaEstado;
    
    /* Enum Estado */
    public enum Status {
        INICIADO,
        COMPLETADO
    }
    
    /* Getters & Setters */

	public Long getIdCursoUsuario() {
		return idCursoUsuario;
	}
	
	public void setIdCursoUsuario(Long idCursoUsuario) {
		this.idCursoUsuario = idCursoUsuario;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public CursosEntity getCurso() {
		return curso;
	}

	public void setCurso(CursosEntity curso) {
		this.curso = curso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaEstado() {
		return fechaEstado;
	}

	public void setFechaEstado(String fechaEstado) {
		this.fechaEstado = fechaEstado;
	}    
}
