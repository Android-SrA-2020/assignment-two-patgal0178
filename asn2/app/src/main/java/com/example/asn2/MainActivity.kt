package com.example.asn2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextButton: Button = findViewById(R.id.btnNext)
        nextButton.setOnClickListener { next() }

        val prevButton: Button = findViewById(R.id.btnPrev)
        prevButton.setOnClickListener { prev() }
        val tButton: Button = findViewById(R.id.btnTrue)
        tButton.setOnClickListener { tVal() }
        val fButton: Button = findViewById(R.id.btnFalse)
        fButton.setOnClickListener { fVal() }

        number++
        when (number) {
            0 -> txtQuestion.text=one
            1 -> txtQuestion.text=two
            2 -> txtQuestion.text=three
            3 -> txtQuestion.text=four
            4 -> txtQuestion.text=five
        }
    }

    private val questionBank = listOf(
        Question("Q1", false),
        Question("Q2", true),
        Question("Q3", true),
        Question("Q4", false),
        Question("Q5", false))



    private var number=0
    private fun next() {
        val resultText: TextView = findViewById(R.id.txtQuestion)
        if(number==4){
            Toast.makeText(applicationContext,
                "No more Questions", Toast.LENGTH_LONG).show()
        }else{
            number++
            when (number) {
                0 -> resultText.text=one
                1 -> resultText.text=two
                2 -> resultText.text=three
                3 -> resultText.text=four
                4 -> resultText.text=five
            }
        }
    }

    private val one = "The Rick & Morty That The Show Follows Are Originally From Dimension C-173"
    private val two = "Jerry's Station Wagon Is Based On The Car From National Lampoon's Vacation?"
    private val three ="Rick & Morty Have Appeared In The Opening Title Screen Of The Simpsons?"
    private val four ="Jaguar From 'Pickle Rick' Had His Own Spin Off Show With Adult Swim?"
    private val five ="Two Brothers' Is The First Show Rick & Morty Watch On Inter-Dimensional Cable?"
    private fun prev() {
        val resultText: TextView = findViewById(R.id.txtQuestion)
        if(number==0){
            Toast.makeText(applicationContext,
                "this is the first Question", Toast.LENGTH_LONG).show()
        }else{
            number--
            when (number) {
                0 -> resultText.text=one
                1 -> resultText.text=two
                2 -> resultText.text=three
                3 -> resultText.text=four
                4 -> resultText.text=five
            }
        }
    }

    private fun tVal() {
        val question = questionBank[number]
        if (question.isRes) {
            Toast.makeText(applicationContext, "correct answer", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(applicationContext, "incorrect answer", Toast.LENGTH_LONG).show()
        }
    }

    private fun fVal() {
        val question = questionBank[number]
        if(!question.isRes){
            Toast.makeText(applicationContext, "correct answer", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(applicationContext, "incorrect answer", Toast.LENGTH_LONG).show()
        }
    }
}
