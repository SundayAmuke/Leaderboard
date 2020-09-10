package com.sundayamuke.leaderboard.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sundayamuke.leaderboard.R
import com.sundayamuke.leaderboard.adapters.SkillBoardAdapter
import com.sundayamuke.leaderboard.databinding.FragmentSkillBinding
import com.sundayamuke.leaderboard.viewmodels.SkillViewModel

class SkillFragment : Fragment() {

    private lateinit var binding: FragmentSkillBinding

    private val viewModel: SkillViewModel by lazy {
        ViewModelProvider(this).get(SkillViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_skill, container, false)

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        binding.skillRecyclerView.adapter = SkillBoardAdapter()

        return binding.root
    }
}