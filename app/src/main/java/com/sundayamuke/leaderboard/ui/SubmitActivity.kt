package com.sundayamuke.leaderboard.ui

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.sundayamuke.leaderboard.R
import com.sundayamuke.leaderboard.databinding.ActivitySubmitBinding
import com.sundayamuke.leaderboard.databinding.ConfirmationLayoutBinding


class SubmitActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubmitBinding
    private lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_submit)

        dialog = Dialog(this)
        setDialogTransparentBackground()

        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_long_back_arrow_24)
        }

        binding.btnSubmit.setOnClickListener {

            val confirmationLayoutBinding: ConfirmationLayoutBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.confirmation_layout, null, false
            )

            dialog.apply {

                setContentView(confirmationLayoutBinding.root)

                confirmationLayoutBinding.txtCloseDialog.setOnClickListener {
                    dismiss()
                    setContentView(R.layout.not_successful_layout)
                    show()
                }

                confirmationLayoutBinding.btnYes.setOnClickListener {
                    dismiss()
                    setContentView(R.layout.successful_layout)
                    show()
                }

                setDialogLayout()
                show()
            }
        }
    }

    private fun setDialogLayout() {
        dialog.window?.setLayout(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
    }

    private fun setDialogTransparentBackground() {
        dialog.window?.setBackgroundDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.transparent_background
            )
        )
    }
}