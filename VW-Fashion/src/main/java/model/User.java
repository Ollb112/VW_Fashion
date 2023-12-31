package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_USER")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User implements Serializable {
	private static final long serialVersionUID = -6518853480190451215L;
	

//Mudar esquema de classes, ex (Staff com vendedor e admin) e user(cliente e fornecedor)

	private static User user;
	
	public static User getUser() {
		return user;
	}
	
	public static void setUser(User novo) {
		user = novo;
	}

	@Id
	@Column(name = "ID_Email")
	private String email;
	
	@Column(name = "Nome")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Nascimento")
	private Date nascimento;
	
	@Column(name = "Senha")
	private String senha;
	
	public User() {
		
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	

}
