package com.onimus.courseandroidkotlinudemy.mytrip

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.onimus.courseandroidkotlinudemy.MainActivity
import com.onimus.courseandroidkotlinudemy.R
import kotlinx.android.synthetic.main.activity_my_trip.*

class MyTripActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_trip)

        //var etDistance = findViewById<EditText>(R.id.etDistance)
        //etDistance
        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btnCalculate) {
            handleCalculate()
        }
    }

    private fun handleCalculate() {
        if (isValid()) {
            try {
                // (distance * price) / autonomy
                val distance = etDistance.text.toString().toFloat()
                val price = etPrice.text.toString().toFloat()
                val autonomy = etAutonomy.text.toString().toFloat()

                val result = ((distance * price) / autonomy)

                tvResult.text = ("${this.getString(R.string.tv_result)} $result")

            } catch (e: NumberFormatException) {
                Toast.makeText(this, getString(R.string.toast_valid_values), Toast.LENGTH_SHORT)
                    .show()
            }
        } else {
            Toast.makeText(this, getString(R.string.toast_valid_values), Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValid(): Boolean {
        return etDistance.text.toString().isNotBlank()
                && etPrice.text.toString().isNotBlank()
                && etAutonomy.text.toString().isNotBlank()
                && etAutonomy.text.toString() != "0"
    }

    override fun onBackPressed() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()
        super.onBackPressed()
    }
}
