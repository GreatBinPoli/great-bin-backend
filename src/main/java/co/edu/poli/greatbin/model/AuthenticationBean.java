package co.edu.poli.greatbin.model;
/**
 * Modelo para autenticar los usuarios 
 * @author Cristian Sanchez
 *
 */
public class AuthenticationBean {
	private String message;
    /**
     * Crear la autenticacion para el usuario 
     * @param message
     */
	public AuthenticationBean(String message) {
		this.message = message;
	}
    /**
     * Get del mensaje 
     * @return
     */
	public String getMessage() {
		return message;
	}
    /**
     * Set del mensaje 
     * @param message
     */
	public void setMessage(String message) {
		this.message = message;
	}
}
