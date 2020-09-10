package com.sundayamuke.leaderboard.utilities

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sundayamuke.leaderboard.adapters.LearningBoardAdapter
import com.sundayamuke.leaderboard.adapters.SkillBoardAdapter
import com.sundayamuke.leaderboard.model.LearningLeader
import com.sundayamuke.leaderboard.model.SkillLeader

@BindingAdapter("learningData")
fun RecyclerView.bindLearningAdapter(data: List<LearningLeader> ?) {
    val adapter = adapter as LearningBoardAdapter

    adapter.submitList(data)
}

@BindingAdapter("skillData")
fun RecyclerView.bindSkillAdapter(data: List<SkillLeader> ?) {
    val adapter = adapter as SkillBoardAdapter

    adapter.submitList(data)
}

@BindingAdapter("sourceUrl")
fun ImageView.loadImage(imgUrl: String?) {
    Picasso.get().load(imgUrl).into(this)
}