package com.example.aftecalintweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    lateinit var Buttonadd:Button
    lateinit var Buttonminus:Button
    lateinit var Buttondivide:Button
    lateinit var Buttonmultiply:Button
    lateinit var firstnumber:EditText
    lateinit var secondnumber:EditText
    lateinit var textanswer:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        Buttonadd=findViewById(R.id.Btn_Add)
        Buttonminus=findViewById(R.id.Btn_Minus)
        Buttondivide=findViewById(R.id.Btn_Divide)
        Buttonmultiply=findViewById(R.id.Btn_Multiply)
        firstnumber=findViewById(R.id.Edt_FirstNumber)
        secondnumber=findViewById(R.id.Edt_SecondNumber)
        textanswer=findViewById(R.id.txt_Answer)

        Buttonadd.setOnClickListener {
            var firstnum=firstnumber.text.toString()
            var secondnum=secondnumber.text.toString()
            if (firstnum.isEmpty() && secondnum.isEmpty()){
                textanswer.text="please fill in all the details"
            }else{
                var answer=firstnum.toDouble()+secondnum.toDouble()
                textanswer.text=answer.toString()
            }
        }
        Buttonminus.setOnClickListener {
            var firstnum=firstnumber.text.toString()
            var secondnum=secondnumber.text.toString()
            if (firstnum.isEmpty() && secondnum.isEmpty()){
                textanswer.text="please fill in all the details"
            }else{
                var answer=firstnum.toDouble()-secondnum.toDouble()
                textanswer.text=answer.toString()
            }
        }
        Buttondivide.setOnClickListener {
            var firstnum=firstnumber.text.toString()
            var secondnum=secondnumber.text.toString()
            if (firstnum.isEmpty() && secondnum.isEmpty()){
                textanswer.text="please fill in all the details"
            }else{
                var answer=firstnum.toDouble()/secondnum.toDouble()
                textanswer.text=answer.toString()
            }
        }
        Buttonmultiply.setOnClickListener {
            var firstnum=firstnumber.text.toString()
            var secondnum=secondnumber.text.toString()
            if (firstnum.isEmpty() && secondnum.isEmpty()){
                textanswer.text="please fill in all the details"
            }else{
                var answer=firstnum.toDouble()*secondnum.toDouble()
                textanswer.text=answer.toString()
            }
        }

    }
}