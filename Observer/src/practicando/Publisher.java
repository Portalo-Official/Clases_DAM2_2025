package practicando;

public interface Publisher<T, K> {
	boolean subscribe(T t);
	boolean unsubscriber(T t);
	void notifySubscriber(K kAntigua, K kNueva);
}
