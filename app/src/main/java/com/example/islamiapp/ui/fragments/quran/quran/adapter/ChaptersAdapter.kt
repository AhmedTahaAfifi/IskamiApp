package com.example.islamiapp.ui.fragments.quran.quran.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.data.models.quran.QuranData
import com.example.islamiapp.databinding.ItemSuraBinding

class ChaptersAdapter(private val onClick: (QuranData) -> Unit): ListAdapter<QuranData, ChaptersAdapter.ChapterViewHolder>(DiffCallBack) {

    companion object DiffCallBack: DiffUtil.ItemCallback<QuranData>() {
        override fun areItemsTheSame(oldItem: QuranData, newItem: QuranData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: QuranData, newItem: QuranData): Boolean {
            return oldItem.name == newItem.name
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val binding = ItemSuraBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val item = getItem(position)

        with(holder) {
            binding.suraName.text = item.name
            binding.ayahNumber.text = item.versesCount.toString()
            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

    class ChapterViewHolder(val binding: ItemSuraBinding): ViewHolder(binding.root)

}