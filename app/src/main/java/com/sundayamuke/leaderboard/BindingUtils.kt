package com.sundayamuke.leaderboard

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sundayamuke.leaderboard.adapters.LeaderBoardAdapter
import com.sundayamuke.leaderboard.model.LearningLeader

@BindingAdapter("submitData")
fun RecyclerView.bindAdapter(data: List<LearningLeader> ?) {
    val adapter = adapter as LeaderBoardAdapter

    adapter.submitList(data)
}

@BindingAdapter("sourceUrl")
fun ImageView.loadImage(imgUrl: String?) {
    Picasso.get().load(imgUrl).into(this)
}