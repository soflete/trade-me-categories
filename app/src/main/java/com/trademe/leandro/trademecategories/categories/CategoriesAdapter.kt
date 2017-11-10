package com.trademe.leandro.trademecategories.categories

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.trademe.leandro.trademecategories.R
import com.trademe.leandro.trademecategories.data.Category


/**
 * Created by Leandro on 10/11/2017.
 */
class CategoriesAdapter(
        private val categories: List<Category>,
        private val onCategorySelected: (category: Category) -> Unit
) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.nameView?.text = categories[position].name
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val nameView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_category, parent, false) as TextView
        return ViewHolder(nameView, { onCategorySelected(categories[it]) })
    }

    override fun getItemCount(): Int {
        return categories.size;
    }

    class ViewHolder(
            val nameView: TextView,
            private val onViewClicked: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(nameView) {
        init {
            nameView.setOnClickListener { onViewClicked(adapterPosition) }
        }
    }
}