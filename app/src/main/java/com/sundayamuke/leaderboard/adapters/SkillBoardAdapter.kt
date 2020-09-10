package com.sundayamuke.leaderboard.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sundayamuke.leaderboard.databinding.ItemSkillBinding
import com.sundayamuke.leaderboard.model.SkillLeader

class SkillBoardAdapter()
    : ListAdapter<SkillLeader, SkillBoardAdapter.SkillViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        return SkillViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        val skill = getItem(position)
        holder.bind(skill)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<SkillLeader>() {
        override fun areItemsTheSame(oldItem: SkillLeader, newItem: SkillLeader): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: SkillLeader, newItem: SkillLeader): Boolean {
            return oldItem == newItem
        }
    }

    class SkillViewHolder private constructor(private var binding: ItemSkillBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(skillLeader: SkillLeader) {
            binding.skillLeader = skillLeader
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): SkillViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemSkillBinding.inflate(layoutInflater, parent, false)
                return SkillViewHolder(binding)
            }

        }
    }

}
