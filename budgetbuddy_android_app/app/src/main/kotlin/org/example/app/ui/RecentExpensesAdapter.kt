package org.example.app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.example.app.R

/**
 * PUBLIC_INTERFACE
 * RecentExpensesAdapter
 * Minimal adapter for recent expenses list showing amount, category, and note.
 */
class RecentExpensesAdapter : RecyclerView.Adapter<RecentExpensesAdapter.VH>() {

    data class Item(val amount: Double, val category: String, val note: String?)

    private val items = mutableListOf<Item>()

    // PUBLIC_INTERFACE
    fun submitList(newItems: List<Item>) {
        /** Replaces the data set and refreshes the list. */
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recent_expense, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.txtTitle)
        private val subtitle: TextView = itemView.findViewById(R.id.txtSubtitle)

        fun bind(item: Item) {
            title.text = String.format("$%.2f • %s", item.amount, item.category)
            subtitle.text = item.note ?: ""
            subtitle.visibility = if (item.note.isNullOrBlank()) View.GONE else View.VISIBLE
        }
    }
}
