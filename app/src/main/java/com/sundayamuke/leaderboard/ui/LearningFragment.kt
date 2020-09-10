package com.sundayamuke.leaderboard.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sundayamuke.leaderboard.R
import com.sundayamuke.leaderboard.adapters.LearningBoardAdapter
import com.sundayamuke.leaderboard.databinding.FragmentLearningBinding
import com.sundayamuke.leaderboard.viewmodels.LearningViewModel

class LearningFragment : Fragment() {

    private lateinit var binding: FragmentLearningBinding

    private val viewModel: LearningViewModel by lazy {
        ViewModelProvider(this).get(LearningViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_learning, container, false)

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        binding.learningRecyclerView.adapter = LearningBoardAdapter()

        return binding.root
    }

}