package br.com.autoPecas.controller;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.autoPecas.DAO.UsuarioDAO;
import br.com.autoPecas.entity.Usuario;
import br.com.autoPecas.util.Faces;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean {

	private String txtEmail;
	private String txtSenha;
	private Usuario usuario;
	private UsuarioDAO usuarioDAO;
	private Faces faces;

	public LoginBean() {

		this.usuario = new Usuario();
		this.usuarioDAO = new UsuarioDAO();
		this.faces = new Faces();
	}

	public void cadastrar() throws SQLException {
		if (this.usuario.getNome().isEmpty() || this.usuario.getNome().isEmpty() || this.usuario.getSenha().isEmpty()) {
			this.faces.msgError("prencha todos os campos");
		} else {
			Usuario novo = new Usuario();
			novo.setNome(this.usuario.getNome());
			novo.setEmail(this.usuario.getEmail());
			novo.setSenha(this.usuario.getSenha());

			boolean verificar = false;
			for (Usuario email : usuarioDAO.listar()) {
				if (novo.getEmail().equals(email.getEmail())) {
					verificar = true;
				}
			}
			if (verificar) {
				this.faces.msgError("Email já Cadastrado");
			} else {
				usuarioDAO.cadastrarUsuario(novo);
			}

			this.usuario = new Usuario();

		}

	}

	public String entrar() {

		if (this.txtEmail.isEmpty() || this.txtSenha.isEmpty()) {
			this.faces.msgError("preencha os campos");
		} else {
			boolean verificarCampos = false;
			for (Usuario verificar : this.usuarioDAO.listar()) {
				if (this.txtEmail.equals(verificar.getEmail()) && this.txtSenha.equals(verificar.getSenha())) {
					verificarCampos = true;
				}

			}
			if (verificarCampos) {
				System.out.println("ir para a proxima pagina");
			} else {
				faces.msgError("login ou senha incorretos");
			}
		}

		return "";
	}

	public Faces getFaces() {
		return faces;
	}

	public void setFaces(Faces faces) {
		this.faces = faces;
	}

	public String getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail = txtEmail;
	}

	public String getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(String txtSenha) {
		this.txtSenha = txtSenha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
