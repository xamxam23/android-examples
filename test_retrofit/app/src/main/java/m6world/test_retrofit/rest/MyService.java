package m6world.test_retrofit.rest;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 3/6/2017.
 */

public class MyService {
    public Retrofit getRetrofit() {
        return new Retrofit.Builder().baseUrl("http://m6world.com/")
                //.client(new OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    protected <T> void enqueue(Call<T> call, final MyServiceReceiver<T> client) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                Log.d("x-retro", "onResponse " + response);
                client.onResponse((T) response.body());
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Log.d("x-retro", "onFailure " + t);
                client.onFailure(t);
            }
        });
    }
}
