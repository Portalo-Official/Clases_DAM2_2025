package patron;

public interface Subscriber<T> {
	void update(T context);
}
