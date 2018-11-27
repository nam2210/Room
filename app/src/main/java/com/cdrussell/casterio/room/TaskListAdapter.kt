package com.cdrussell.casterio.room

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cdrussell.casterio.room.TaskListAdapter.ViewHolder
import kotlinx.android.synthetic.main.item_task_row.view.*


class TaskListAdapter(private val clickListener: (Task) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    private val tasks: MutableList<Task> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_task_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tasks[position], clickListener)
    }

    override fun getItemCount(): Int = tasks.size

    fun addTask(task: Task) {
        if (!tasks.contains(task)) {
            tasks.add(task)
            notifyItemInserted(tasks.size)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(task: Task, clickListener: (Task) -> Unit) {
            itemView.taskTitle.text = task.title
            itemView.setOnClickListener { clickListener(task) }
        }

    }
}