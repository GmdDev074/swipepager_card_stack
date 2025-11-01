package com.zatswahm.swipepager.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zatswahm.swipepager.R
import com.zatswahm.swipepager.data.Question
import com.zatswahm.swipepager.databinding.ItemQuestionCardBinding

class QuestionAdapter(private val items: List<Question>) :
    RecyclerView.Adapter<QuestionAdapter.VH>() {

    inner class VH(val binding: ItemQuestionCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemQuestionCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]

        holder.binding.txtQuestion.text = item.text
        holder.binding.txtProgress.text = "Card ${position + 1} of ${items.size}"

        val container = holder.binding.answersContainer
        container.removeAllViews()

        item.answers.forEach { ans ->
            val answerBtn = LayoutInflater.from(holder.itemView.context)
                .inflate(R.layout.answer_button_item, container, false) as TextView
            answerBtn.text = ans
            container.addView(answerBtn)
        }
    }


    override fun getItemCount() = items.size
}
