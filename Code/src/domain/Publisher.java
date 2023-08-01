package domain;

import java.util.LinkedList;
import java.util.List;
import presentation.Subscriber;

public class Publisher {
    private List<Subscriber> subscribers = new LinkedList<Subscriber>();
    
	public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber); 
    }

	public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber); 
    }

	public void notifySubscribers(List<HangHoa> hanghoaList) {
		for(Subscriber s: subscribers) {
            s.update(hanghoaList);
	    }
    }
}