package com.fatima.tuzzahra

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class TuzZahra : AppCompatActivity() {
    private lateinit var view:View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tuz_zahra)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        view = findViewById(R.id.main)

        val nextBtn = findViewById<Button>(R.id.btnNext)
        nextBtn.setOnClickListener {
            val chkBx1 = findViewById<CheckBox>(R.id.chk1)
            val chkBx2 = findViewById<CheckBox>(R.id.chk2)
            val chkBx3 = findViewById<CheckBox>(R.id.chk3)
            val chkBx4 = findViewById<CheckBox>(R.id.chk4)

            var selectedExercises = " ";

            if(chkBx1.isChecked()) selectedExercises += chkBx1.text.toString() + ","
            if(chkBx2.isChecked()) selectedExercises += chkBx2.text.toString() + ","
            if(chkBx3.isChecked()) selectedExercises += chkBx3.text.toString() + ","
            if(chkBx4.isChecked()) selectedExercises += chkBx4.text.toString() + ","

            Snackbar.make(view,
                "Selected Exercises:$selectedExercises", Snackbar.LENGTH_LONG).show()

        }

    }
}