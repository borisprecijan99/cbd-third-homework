package rzk;

import javax.ejb.Remote;

@Remote
public interface CardsBeanRemote {
	boolean sendMessage(String type, String from, String to, String email);
}
