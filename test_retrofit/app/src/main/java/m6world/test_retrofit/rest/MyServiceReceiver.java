package m6world.test_retrofit.rest;

/**
 * Created by Administrator on 3/6/2017.
 */

public interface MyServiceReceiver<T> {
    public void onResponse(T data);
    public void onFailure(Throwable throwable);
}
