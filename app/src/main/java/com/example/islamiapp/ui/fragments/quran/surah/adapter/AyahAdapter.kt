package com.example.islamiapp.ui.fragments.quran.surah.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.R
import com.example.islamiapp.data.models.quran.AyahData
import com.example.islamiapp.databinding.ItemAyahBinding

class AyahAdapter: ListAdapter<AyahData, AyahAdapter.AyahViewHolder>(DiffCallBack) {

    companion object DiffCallBack: DiffUtil.ItemCallback<AyahData>() {
        override fun areItemsTheSame(oldItem: AyahData, newItem: AyahData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AyahData, newItem: AyahData): Boolean {
            return oldItem.ayahNumber == newItem.ayahNumber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyahViewHolder {
        val binding = ItemAyahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AyahViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AyahViewHolder, position: Int) {
        val ayah = getItem(position)

        with(holder) {
            binding.ayah.text = binding.root.context.getString(R.string.item_ayah_number, ayah.ayah?.replace("\n",""), ayah.ayahNumber)
        }
    }

    class AyahViewHolder(val binding: ItemAyahBinding): ViewHolder(binding.root)
}