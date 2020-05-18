package br.com.autoPecas.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Faces implements Serializable {

	private static final long serialVersionUID = 1L;

	public void msgError(String msg) {
		FacesMessage mensage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		FacesContext msgTela = FacesContext.getCurrentInstance();
		msgTela.addMessage(null, mensage);
	}

	public void msgInfo(String msg) {
		FacesMessage mensage = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext msgTela = FacesContext.getCurrentInstance();
		msgTela.addMessage(null, mensage);
	}

	public void msgFatalErro(String msg) {
		FacesMessage mensage = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, msg);
		FacesContext msgTela = FacesContext.getCurrentInstance();
		msgTela.addMessage(null, mensage);
	}

}
