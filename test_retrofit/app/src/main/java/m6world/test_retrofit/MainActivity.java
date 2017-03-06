package m6world.test_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import m6world.test_retrofit.rest.MyServiceReceiver;
import m6world.test_retrofit.rest.MyService_GetUsers;

// import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.textview) TextView textView;
    @BindView(R.id.listview) ListView listview;
    @BindView(R.id.progressbar) ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progressBar.setVisibility(View.GONE);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                MyService_GetUsers m = new MyService_GetUsers();
                progressBar.setVisibility(View.VISIBLE);
                m.getUsers(new MyServiceReceiver<List<MyService_GetUsers.GetUsersEndPoint.User>>() {
                    @Override
                    public void onResponse(List<MyService_GetUsers.GetUsersEndPoint.User> data) {
                        if (data != null) {
                            ArrayAdapter<MyService_GetUsers.GetUsersEndPoint.User> adapter = new ArrayAdapter<MyService_GetUsers.GetUsersEndPoint.User>(getApplicationContext(),
                                    android.R.layout.simple_selectable_list_item, data);
                            listview.setAdapter(adapter);
                        }
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override public void onFailure(Throwable throwable) {
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
        });
    }
}

