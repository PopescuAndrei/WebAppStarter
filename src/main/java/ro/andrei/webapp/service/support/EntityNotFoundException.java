package ro.andrei.webapp.service.support;

/**
 * Created by epopean on 10/4/2016.
 */
public class EntityNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructor
     *
     * @param message
     */
    public EntityNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructor
     *
     * @param message
     * @param cause
     */
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

