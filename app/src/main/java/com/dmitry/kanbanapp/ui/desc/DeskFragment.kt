package com.dmitry.kanbanapp.ui.desc

import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmitry.kanbanapp.R
import com.dmitry.kanbanapp.databinding.FragmentDeskBinding

private var _binding: FragmentDeskBinding? = null
private val binding get() = _binding!!

class DeskFragment: Fragment(R.layout.fragment_desk) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toDoRecyclerView = binding.rvTodo
        val doingRecyclerView = binding.rvDoing
        val doneRecyclerView = binding.rvDone

        val toDoLayoutManager = LinearLayoutManager(requireContext())
        val doingLayoutManager = LinearLayoutManager(requireContext())
        val doneLayoutManager = LinearLayoutManager(requireContext())

        val toDoAdapter = RVAdapter(mutableListOf("task_1", "task_2", "task_3", "task_4"))
        val doingAdapter = RVAdapter(mutableListOf("task_5", "task_6", "task_7", "task_8"))
        val doneAdapter = RVAdapter(mutableListOf("task_9", "task_10", "task_11", "task_12"))

        toDoRecyclerView.layoutManager = toDoLayoutManager
        toDoRecyclerView.adapter = toDoAdapter

        doingRecyclerView.layoutManager = doingLayoutManager
        doingRecyclerView.adapter = doingAdapter

        doneRecyclerView.layoutManager = doneLayoutManager
        doneRecyclerView.adapter = doneAdapter

        // Set the drag event listener for the View.
//        toDoRecyclerView.setOnDragListener { v, e ->
//
//            // Handles each of the expected events.
//            when (e.action) {
//                DragEvent.ACTION_DRAG_STARTED -> {
//                    // Determines if this View can accept the dragged data.
//                    if (e.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
//                        // As an example of what your application might do, applies a blue color tint
//                        // to the View to indicate that it can accept data.
//                        (v as? ImageView)?.setColorFilter(Color.BLUE)
//
//                        // Invalidate the view to force a redraw in the new tint.
//                        v.invalidate()
//
//                        // Returns true to indicate that the View can accept the dragged data.
//                        true
//                    } else {
//                        // Returns false to indicate that, during the current drag and drop operation,
//                        // this View will not receive events again until ACTION_DRAG_ENDED is sent.
//                        false
//                    }
//                }
//                DragEvent.ACTION_DRAG_ENTERED -> {
//                    // Applies a green tint to the View.
//                    (v as? ImageView)?.setColorFilter(Color.GREEN)
//
//                    // Invalidates the view to force a redraw in the new tint.
//                    v.invalidate()
//
//                    // Returns true; the value is ignored.
//                    true
//                }
//
//                DragEvent.ACTION_DRAG_LOCATION ->
//                    // Ignore the event.
//                    true
//                DragEvent.ACTION_DRAG_EXITED -> {
//                    // Resets the color tint to blue.
//                    (v as? ImageView)?.setColorFilter(Color.BLUE)
//
//                    // Invalidates the view to force a redraw in the new tint.
//                    v.invalidate()
//
//                    // Returns true; the value is ignored.
//                    true
//                }
//                DragEvent.ACTION_DROP -> {
//                    // Gets the item containing the dragged data.
//                    val item: ClipData.Item = e.clipData.getItemAt(0)
//
//                    // Gets the text data from the item.
//                    val dragData = item.text
//
//                    // Displays a message containing the dragged data.
//                    Toast.makeText(this, "Dragged data is $dragData", Toast.LENGTH_LONG).show()
//
//                    // Turns off any color tints.
//                    (v as? ImageView)?.clearColorFilter()
//
//                    // Invalidates the view to force a redraw.
//                    v.invalidate()
//
//                    // Returns true. DragEvent.getResult() will return true.
//                    true
//                }
//
//                DragEvent.ACTION_DRAG_ENDED -> {
//                    // Turns off any color tinting.
//                    (v as? ImageView)?.clearColorFilter()
//
//                    // Invalidates the view to force a redraw.
//                    v.invalidate()
//
//                    // Does a getResult(), and displays what happened.
//                    when(e.result) {
//                        true ->
//                            Toast.makeText(this, "The drop was handled.", Toast.LENGTH_LONG)
//                        else ->
//                            Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_LONG)
//                    }.show()
//
//                    // Returns true; the value is ignored.
//                    true
//                }
//                else -> {
//                    // An unknown action type was received.
//                    Log.e("DragDrop Example", "Unknown action type received by View.OnDragListener.")
//                    false
//                }
//            }
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}