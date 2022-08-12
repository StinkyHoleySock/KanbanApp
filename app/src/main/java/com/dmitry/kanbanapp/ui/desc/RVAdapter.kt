package com.dmitry.kanbanapp.ui.desc

import android.content.ClipData
import android.content.ClipDescription
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmitry.kanbanapp.R
import com.dmitry.kanbanapp.databinding.FragmentDeskBinding
import com.dmitry.kanbanapp.databinding.TaskItemBinding

class RVAdapter(
    private val list: MutableList<String>
    ) : RecyclerView.Adapter<RVAdapter.RVViewHolder>() {

    fun removeItem(text: String) {
        val index = list.indexOf(text)
        list.removeAt(index)
        notifyItemRemoved(index)
    }

    fun addItem(text: String) {
        val index = list.size
        list.add(text)
        notifyItemInserted(index)
    }


    abstract class RVViewHolder(
        view: View,
        val binding: TaskItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        abstract fun bind(data: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder =
        OneTextViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false),
            TaskItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: RVViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size

    class OneTextViewHolder(view: View, binding: TaskItemBinding) : RVViewHolder(view, binding) {
        override fun bind(data: String) = with(itemView) {
            binding.tvTask.text = data
            setOnLongClickListener {
                val item = ClipData.Item(data)

                val dragData = ClipData(data, arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN), item)

                val myShadow = View.DragShadowBuilder(this)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    it.startDragAndDrop(dragData, myShadow, null, 0)
                }
                true
            }
        }

    }
}