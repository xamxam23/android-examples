package com.example.maximembabele.test_recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/*
- If you do not specify any visibility modifier, public is used by default, which means that your declarations will be visible everywhere;
- If you mark a declaration private, it will only be visible inside the file containing the declaration;
- If you mark it internal, it is visible everywhere in the same module;
- protected is not available for top-level declarations.
 */
class MainKActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = MyAdapter()
    }

    internal inner class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        var data = arrayOf("one", "two", "three", "four", "five")
        val TYPE_HEADER = 0
        val TYPE_ITEM = 1
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            when (viewType) {
                TYPE_HEADER -> {
                    val view = LayoutInflater.from(parent.context).inflate(R.layout.header, parent, false)
                    return MyViewHolder(view)
                }
                TYPE_ITEM -> {
                    val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
                    return MyViewHolder(view)
                }
            }
            throw IllegalArgumentException("Invalid View Type")
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            if (holder is MyViewHolderItem) {
                holder.setText(data[position])
            } else if (holder is MyViewHolderHeader) {
                // Header
            }
        }

        override fun getItemViewType(position: Int): Int {
            return if (position == 0) TYPE_HEADER else TYPE_ITEM
        }

        override fun getItemCount(): Int {
            return data.size
        }

        internal inner class MyViewHolderHeader(itemView: View) : MyViewHolder(itemView)

        internal open inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

        internal inner class MyViewHolderItem(itemView: View) : MyViewHolder(itemView) {
            var textView: TextView

            init {
                textView = itemView.findViewById(R.id.tv)
            }

            fun setText(text: String) {
                textView.text = text
            }
        }
    }
}