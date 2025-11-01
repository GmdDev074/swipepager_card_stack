package com.zatswahm.swipepager.ui.main

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class SwipeTouchHelper(
    private val onSwiped: (Int, Int) -> Unit
) : ItemTouchHelper.SimpleCallback(
    0,
    ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT or ItemTouchHelper.UP or ItemTouchHelper.DOWN
) {

    override fun onMove(
        rv: RecyclerView, vh: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder
    ) = false

    override fun onSwiped(vh: RecyclerView.ViewHolder, dir: Int) {
        onSwiped(vh.bindingAdapterPosition, dir)
    }
}