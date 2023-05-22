package com.example.zd8

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        El1 = findViewById<TextView>(R.id.ABut)
        El2 = findViewById<TextView>(R.id.bbut)
        El3 = findViewById<TextView>(R.id.Cbut)
        Znak = findViewById<TextView>(R.id.znak)
        Sr = findViewById<TextView>(R.id.SredText)
        MinT = findViewById<TextView>(R.id.MinText)
        MaxT = findViewById<TextView>(R.id.MaxText)
        Truetxt = findViewById<TextView>(R.id.trueT)
        Faulsetxt = findViewById<TextView>(R.id.faulseT)
        True = findViewById<Button>(R.id.TrueBtn)
        Faulse = findViewById<Button>(R.id.FaulseBtn)
        Start = findViewById<Button>(R.id.startBtn)
        Znak=findViewById<TextView>(R.id.znak)
        Reseno=findViewById<TextView>(R.id.resh)
        Sek=findViewById<TextView>(R.id.sek)
    }
    lateinit var True: Button
    lateinit var Start: Button
    lateinit var Faulse: Button
    lateinit var Znak: TextView
    lateinit var El1: TextView
    lateinit var El2: TextView
    lateinit var El3: TextView
    lateinit var Sr: TextView
    lateinit var MinT: TextView
    lateinit var Sek: TextView
    lateinit var MaxT: TextView
    lateinit var Truetxt: TextView
    lateinit var Reseno: TextView
    lateinit var Faulsetxt: TextView
    val RandZnak = arrayOf("+","-","*","/")
    var a:Int=0
    var b:Int=0
    var c:Int=0
    var Pr:Int=0
    var Tr:Int=0
    var Ft:Int=0
    var i:Int=0
    var counter = 0
    var unrec=0;
    private var record = 60
    var ArTime = mutableListOf<Int>()
    fun StartPr(view: View){
        True.isEnabled=true
        Faulse.isEnabled=true
        Start.isEnabled=false
        Resh()
        timerStart()
    }
    fun TrueBtn(view: View){
        i++
        Reseno.text=i.toString()
        if(Pr==1){
           Tr++
            Truetxt.text=Tr.toString()
            recordSecond()
        }else if(Pr==2){
            Ft++
            Faulsetxt.text=Ft.toString()

        }
        Resh()

        timerStop()
        timerStart()

    }
    fun FaulseBtn(view: View){
        i++
        Reseno.text=i.toString()
        if(Pr==2){
            Tr++
            Truetxt.text=Tr.toString()
            recordSecond()
        }else if(Pr==1){
            Ft++
            Faulsetxt.text=Ft.toString()
        }
        Resh()
        timerStop()
        timerStart()
    }
    fun Resh(){
        Pr = (1..2).random()
        b = (1..999).random()
        a = (1..999).random()
        El1.setText("" + a)
        El2.setText("" + b)
        if(Pr==1){
            Znak()
            El3.setText("" + c)
        }else if(Pr==2){
            var Rnd = RandZnak.random()
            Znak.text=Rnd
            c = (1..999).random()
            El3.setText("" + c)
        }
    }
    fun Znak(){
        var Rnd = RandZnak.random()
        Znak.text=Rnd
        when (Znak.text.toString()) {
            "+" -> { c=(a+b) }
            "*" -> { c=(a*b) }
            "-" -> { c=(a-b) }
            "/" -> { c=(a/b) }
                }
            }

    private val timer = object: CountDownTimer(50000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            counter++
            Sek.text=("$counter")
        }
        override fun onFinish() {}
    }
    private fun timerStart(){
        timer.start()
    }
    private fun timerStop(){
        timer.cancel()
        counter = 0
    }
    private fun recordSecond(){
        if(record > counter) {
          record=counter
            MinT.text=record.toString()
        }
        if(unrec<counter){
            unrec=counter
            MaxT.text=unrec.toString()
        }
       ArTime.add(counter)
       Sr.text= ArTime.average().toString()

    }



}



