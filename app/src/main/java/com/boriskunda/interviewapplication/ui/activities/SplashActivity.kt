package com.boriskunda.interviewapplication.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.boriskunda.interviewapplication.R
import com.boriskunda.interviewapplication.utilities.SPLASH_COUNT_INTERVAL
import com.boriskunda.interviewapplication.utilities.SPLASH_DURATION
import com.boriskunda.interviewapplication.viewmodel.SharedViewModel

class SplashActivity : AppCompatActivity() {

    private val sharedViewModel: SharedViewModel by viewModels()
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var alertDialog: AlertDialog
    private var areMoviesStoredInDb: Boolean = false
    private var temp: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_cl)

        setErrorDialog()
        initCountDown()
        observeViewModel(sharedViewModel)

    }

    private fun observeViewModel(vm: SharedViewModel) {
        vm.moviesListLD.observe(this, Observer {

            if (it.isEmpty()) {
                vm.loadMovies()
            } else {
                areMoviesStoredInDb = true
            }

        })
    }

    private fun initCountDown() {

        countDownTimer = object : CountDownTimer(SPLASH_DURATION, SPLASH_COUNT_INTERVAL) {
            override fun onFinish() {

                runOnUiThread {

                    if (areMoviesStoredInDb) {
                        val intent = Intent(
                            this@SplashActivity,
                            MainActivity::class.java
                        )
                        startActivity(intent)
                        cancel()
                        finish()
                    } else {
                        alertDialog.show()
                        cancel()
                    }

                }

            }

            override fun onTick(millisUntilFinished: Long) {
                //do nothing
            }

        }.start()

    }

    private fun setErrorDialog() {
        val builder = AlertDialog.Builder(this@SplashActivity)
        //Retry
        builder.setPositiveButton(getString(R.string.Dialog_Positive_Button_Text)) { _, _ ->
            sharedViewModel.loadMovies()
            countDownTimer.start()
        }
        //Close
        builder.setNegativeButton(getString(R.string.Dialog_Negative_Button_Text)) { _, _ ->
            finish()
        }

        alertDialog = builder.create().apply {
            setIcon(R.drawable.ic__error)
            setTitle(getString(R.string.Dialog_Title_Error))
            setMessage(getString(R.string.Dialog_Message_Error))
        }

    }

}