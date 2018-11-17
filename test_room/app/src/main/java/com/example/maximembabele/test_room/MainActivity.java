package com.example.maximembabele.test_room;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Room;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maximembabele.test_room.model.AppDatabase;
import com.example.maximembabele.test_room.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<User> adapter;
    TextView tvFirstName, tvLastName;
    AppDatabase db;
    List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        tvFirstName = (EditText) findViewById(R.id.firstName);
        tvLastName = (EditText) findViewById(R.id.lastName);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, Environment.getExternalStorageDirectory().getAbsolutePath()+"/database-name.db")
                /*.openHelperFactory(new SupportSQLiteOpenHelper.Factory() {
                    @Override
                    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
                        return null;
                    }
                })*/
                .build();
        findViewById(R.id.bSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.post(new Runnable() {
                    @Override
                    public void run() {
                        save();
                    }
                });
            }
        });
        adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, users);
        listView.setAdapter(adapter);
        load();
    }

    String tos(TextView textView) {
        return textView.getText().toString();
    }

    public void save() {
        final String first = tos(tvFirstName);
        final String last = tos(tvLastName);
        if (TextUtils.isEmpty(first) || TextUtils.isEmpty(last)) {
            if (TextUtils.isEmpty(first))
                tvFirstName.setError("Invalid input");
            if (TextUtils.isEmpty(last))
                tvLastName.setError("Invalid input");
        } else {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    User user = new User(first, last);
                    db.userDao().insertAll(user);
                    toast("saved!");
                    load();
                }
            }).start();

        }
    }

    private void toast(final String s) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (s != null)
                    Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            }
        });

    }
    final Object lock = new Object();
    public void load() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final List<User> data = db.userDao().getAll();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (lock) {
                            users.clear();
                            users.addAll(data);
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }
}
