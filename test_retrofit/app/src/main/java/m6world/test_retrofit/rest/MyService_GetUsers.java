package m6world.test_retrofit.rest;

import android.util.Log;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 3/6/2017.
 */

public class MyService_GetUsers extends  MyService {

    public void getUsers(final MyServiceReceiver<List<GetUsersEndPoint.User>> client) {
        try {
            GetUsersEndPoint endPoint = getRetrofit().create(GetUsersEndPoint.class);
            Call call = endPoint.getUsers();
            enqueue(call, client);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            Log.d("x-retro", e.toString());
        }
    }

    public static interface GetUsersEndPoint {
        @GET("/dvt/getusers.php")
        Call<List<User>> getUsers();

        class User {
            String id, user, name, pass;

            @Override public String toString() {
                return String.format(Locale.US, "[%s] alias=%s, user=%s, pass=%s", id, user, name, pass);
            }
        }
    }
}
