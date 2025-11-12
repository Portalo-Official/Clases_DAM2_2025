package idea1;



public interface Publisher<T> {
	boolean subcribe(Subscriber<T> s);
	boolean unSubcribe(Subscriber<T> s);
	void notifySubscriber();
}
