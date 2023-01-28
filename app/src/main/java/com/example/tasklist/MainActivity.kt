package com.example.tasklist

import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    //инициализируем переменные которые будем использовать во всем классе
    //lateinit - поздняя инициализация (тоесть то что мы будем использовать вдальнейшем)
    private lateinit var fab: FloatingActionButton
    private lateinit var stubContainer: LinearLayout
    private lateinit var recyclerview: RecyclerView
    private lateinit var adapter: CustomAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Метод findViewById() позволяет получить ссылку на View, которая размещена в разметке (xml) через его идентификатор.
        recyclerview = findViewById<RecyclerView>(R.id.My_RecyclerView)
        stubContainer = findViewById(R.id.no_item_conteiner)
        fab = findViewById(R.id.Add_item)

        fab.setOnClickListener {
            val dialog = CustomDialogClass(this)
            dialog.show()
        }
            // здесь создаем layoutManager который у нас LinearLayoutManager
        recyclerview.layoutManager = LinearLayoutManager(this)

            // ArrayList of class ToDoItem
        val data = ArrayList<ToDoItem>()
            // for (item in 1..20) {
            //    data.add(ToDoItem("A","B", "S"))
            //}

        if (data.isEmpty()) {
            stubContainer.visibility = VISIBLE
            recyclerview.visibility = INVISIBLE
        } else {
                stubContainer.visibility = INVISIBLE
                recyclerview.visibility = VISIBLE
            }

            // Создаем адаптер и передаем ему данные (data)
            adapter = CustomAdapter()

            // Настройка адаптера с помощью recyclerview
            recyclerview.adapter = adapter
            adapter.notifyDataSetChanged()

        }

        fun addItem(item: ToDoItem) {
        stubContainer.visibility = INVISIBLE
        recyclerview.visibility = VISIBLE
        adapter.additem(item)
    }


}