package com.example.maximembabele.test_recyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter());
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        String[] data = {"one", "two", "three", "four", "five"};
        static final int TYPE_HEADER = 0, TYPE_ITEM = 1;

        @NonNull @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            switch (viewType) {
                case TYPE_HEADER:
                    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false);
                    return new MyViewHolder(view);
                case TYPE_ITEM:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
                    return new MyViewHolder(view);
            }
            throw new IllegalArgumentException("Invalid View Type");
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            if (holder instanceof MyViewHolderItem) {
                ((MyViewHolderItem) holder).setText(data[position]);
            } else if(holder instanceof MyViewHolderHeader) {
                // Header
            }
        }

        @Override public int getItemViewType(int position) {
            return position == 0 ? TYPE_HEADER: TYPE_ITEM;
        }

        @Override
        public int getItemCount() {
            return data.length;
        }

        class MyViewHolderHeader  extends MyViewHolder{
            public MyViewHolderHeader(View itemView) {
                super(itemView);
            }
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            public MyViewHolder(View itemView) {
                super(itemView);
            }
        }

        class MyViewHolderItem extends MyViewHolder {
            TextView textView;

            public MyViewHolderItem(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.tv);
            }

            void setText(String text) {
                textView.setText(text);
            }
        }
    }
}