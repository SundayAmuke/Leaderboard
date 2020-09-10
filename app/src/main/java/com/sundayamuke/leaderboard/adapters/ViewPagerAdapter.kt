package com.sundayamuke.leaderboard.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sundayamuke.leaderboard.ui.LearningFragment
import com.sundayamuke.leaderboard.ui.SkillFragment
import java.lang.Exception

class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LearningFragment()
            1 -> SkillFragment()
            else -> throw Exception("Invalid position")
        }
    }
}