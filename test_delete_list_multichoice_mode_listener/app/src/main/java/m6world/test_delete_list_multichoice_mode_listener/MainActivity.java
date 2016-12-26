package m6world.test_delete_list_multichoice_mode_listener;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    BaseAdapter adapter;
    ListView listView;
    List<String> data = new ArrayList<>();
    final SparseBooleanArray deletableItems = new SparseBooleanArray();
    ActionMode mode;
    View test;
    View buttonDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = findViewById(R.id.test);

        for (int i = 0; i < 11; i++)
            data.add(" item " + i);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, data);

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                deletableItems.put(position, !deletableItems.get(position, false));
                adapter.notifyDataSetChanged();

                view.setSelected(deletableItems.get(position, false));
                view.setSelected(true);

                test.setSelected(deletableItems.get(position, false));
                Log.d("x-x", deletableItems.toString());
            }
        });*/

        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                // Capture total checked items
                final int checkedCount = listView.getCheckedItemCount();
                Log.d("x-x", " checked=" + checked + ", position=" + position + ", count = " + checkedCount);
                deletableItems.put(position, checked);
                // Set the CAB title according to total checked items
                mode.setTitle(checkedCount + " Selected");
                //listView.setItemChecked(position, true);
                //listView.setSelection(position);
                //adapter.notifyDataSetChanged();
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.delete, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                if (item.getItemId() == R.id.menu_delete) {
                    delete();
                }
                mode.finish();
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                deletableItems.clear();
                if (buttonDelete!=null)
                    buttonDelete.setVisibility(View.VISIBLE);
            }
        });
    }

    public void delete() {

        long[] deleteIds = listView.getCheckedItemIds();
        List<String> newItems = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (deletableItems.get(i, false) == false) {
                newItems.add(data.get(i));
            }
        }
        data.clear();
        data.addAll(newItems);
        adapter.notifyDataSetChanged();

    }

    public void selectToDelete(View v) {
        buttonDelete = v;
        toast("delete");
        listView.setItemChecked(0, true);
        listView.setSelection(0);
        v.setVisibility(View.INVISIBLE);
        //adapter.notifyDataSetInvalidated();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    void toast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}

