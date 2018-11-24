package com.example.maximembabele.test_room;

import android.arch.persistence.room.Room;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maximembabele.test_room.model.AppDatabase;
import com.example.maximembabele.test_room.model.Countries;
import com.example.maximembabele.test_room.model.CountriesGreen;
import com.example.maximembabele.test_room.model.DaoMaster;
import com.example.maximembabele.test_room.model.DaoSession;
import com.example.maximembabele.test_room.model.User;
import com.example.maximembabele.test_room.model.UserGreen;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.AbstractDaoSession;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<User> adapter;
    TextView tvFirstName, tvLastName;
    AppDatabase db;
    List<User> users = new ArrayList<>();
    TextView textView;
    DaoSession dbSession;
    String dbPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/db-00.db";
        dbSession = new DaoMaster(new DaoMaster.DevOpenHelper(this, dbPath).getWritableDb()).newSession();
        listView = (ListView) findViewById(R.id.listView);
        tvFirstName = (EditText) findViewById(R.id.firstName);
        tvLastName = (EditText) findViewById(R.id.lastName);
        textView = (TextView) findViewById(R.id.textView);

        try {
            db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, dbPath)
                    /*.openHelperFactory(new SupportSQLiteOpenHelper.Factory() {
                        @Override
                        public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
                            return null;
                        }
                    })*/
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            toast(e.toString());
            Log.d("x-", "room failed");
        }
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
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<com.example.maximembabele.test_room.model.Log> logs = dbSession.getLogDao().loadAll();
                for(com.example.maximembabele.test_room.model.Log log: logs){
                    Log.d("x-[", "> " + log.getEntry());
                }
            }
        }).start();
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
                }
            }).start();
        }
    }

    public void insertGreenCountry(View view){
        dbSession.getCountriesGreenDao().insert(new CountriesGreen("Gabon-" + System.currentTimeMillis(), 1));
    }
    String chars= "ABCDEFGHEJKLMNOPKRSTUVWXYZ";
    public void insertGreenUser(View view){
        int x = (int)(System.nanoTime()%chars.length());
        long id = dbSession.getUserGreenDao().insert(new UserGreen(chars.charAt(x)+"+BoyY"+(System.currentTimeMillis()%1000),"NewTonY"));
        Log.d("x-", "insert User:  " + id);
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

    public void loadCountry(View view) {
        textView.setText("Loading...");
        new Thread(new Runnable() {
            @Override
            public void run() {
                final List<CountriesGreen> data = dbSession.getCountriesGreenDao().loadAll();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (lock) {
                            textView.setText("");
                            if (data == null || data.isEmpty()) textView.setText("[Empty]");
                            else
                                for (CountriesGreen countries : data) {
                                    textView.setText(textView.getText() + " . {" + countries+"} ");
                                }
                        }
                    }
                });
            }
        }).start();
    }

    public void load(View view) {
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

    public void loadUserGreen(View view) {
        users.clear();
        adapter.notifyDataSetChanged();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final List<UserGreen> dataGreen = dbSession.getUserGreenDao().loadAll();
                final List<User> data = new ArrayList<>();
                for (UserGreen user : dataGreen) data.add(new User(user.uid.intValue(),  user.firstName, user.lastName));
                if (data.isEmpty()) toast("data is empty");
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
