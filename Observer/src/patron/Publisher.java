package patron;

import java.util.ArrayList;
import java.util.List;

public interface Publisher {
	public boolean subscribe(Subscriber subcriber);
	public boolean unSubcriber(Subscriber subcriber);
	public void notifySubscribers();

}
