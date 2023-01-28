package com.example.tasklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private val mList = arrayListOf<ToDoItem>()

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val headerTitle: TextView = itemView.findViewById(R.id.item_recycler_title)
        val description: TextView = itemView.findViewById(R.id.item_recycler_discription)
        val number: TextView = itemView.findViewById(R.id.item_recycler_number)
    }
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // увеличивает представление card_view_design, которое используется для хранения элемента списка
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    // привязывает элементы списка к представлению
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.headerTitle.text = mList[position].title_header
        holder.description.text = mList[position].description
        holder.number.text = mList[position].number
    }
    //создаем функцию добавления данных и будем ее вызывать из адаптера в MainActivity

    fun additem(item: ToDoItem) {
        mList.add(item) //добавляем ячейку (item) в наш список
        //notifyDataSetChanged()/* что бы список обновился после добавление элемента */
    }

    //fun deleteItem (item: ToDoItem) {
    //    mList.clear()
    //}

    override fun getItemCount(): Int {
        return mList.size
    }


}