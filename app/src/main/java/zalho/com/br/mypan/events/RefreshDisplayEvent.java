package zalho.com.br.mypan.events;

/**
 * Created by andrepereira on 11/09/17.
 */

public class RefreshDisplayEvent {

	private final String message;

	public RefreshDisplayEvent(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
