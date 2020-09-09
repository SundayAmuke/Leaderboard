package com.sundayamuke.leaderboard.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sundayamuke.leaderboard.databinding.ItemDetailsBinding
import com.sundayamuke.leaderboard.model.LearningLeader

class LeaderBoardAdapter()
    : ListAdapter<LearningLeader, LeaderBoardAdapter.BoardViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        val hours = getItem(position)
        holder.bind(hours)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<LearningLeader>() {
        override fun areItemsTheSame(oldItem: LearningLeader, newItem: LearningLeader): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: LearningLeader, newItem: LearningLeader): Boolean {
            return oldItem == newItem
        }
    }

    class BoardViewHolder private constructor(private var binding: ItemDetailsBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(learningLeader: LearningLeader) {
            binding.learningLeader = learningLeader
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): BoardViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemDetailsBinding.inflate(layoutInflater, parent, false)
                return BoardViewHolder(binding)
            }

        }
    }

}
