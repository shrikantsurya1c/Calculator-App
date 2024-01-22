package com.surya.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    lateinit var btn_0: android.widget.Button
    lateinit var btn_1: android.widget.Button
    lateinit var btn_2: android.widget.Button
    lateinit var btn_3: android.widget.Button
    lateinit var btn_4: android.widget.Button
    lateinit var btn_5: android.widget.Button
    lateinit var btn_6: android.widget.Button
    lateinit var btn_7: android.widget.Button
    lateinit var btn_8: android.widget.Button
    lateinit var btn_9: android.widget.Button
    lateinit var btn_00: android.widget.Button
    lateinit var btn_percent: android.widget.Button
    lateinit var btn_clear: android.widget.Button
    lateinit var btn_dot: android.widget.Button
    lateinit var btn_equal: android.widget.Button
    lateinit var btn_add: android.widget.Button
    lateinit var btn_sub: android.widget.Button
    lateinit var btn_mul: android.widget.Button
    lateinit var btn_divi: android.widget.Button
    lateinit var btn_backspace: android.widget.Button
    lateinit var btn_inputext: EditText
    lateinit var btn_resultext: EditText

    var check = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        btn_0=findViewById(R.id.btn_0)
        btn_00 = findViewById(R.id.btn_00)
        btn_1 = findViewById(R.id.btn_1)
        btn_2 = findViewById(R.id.btn_2)
        btn_3 = findViewById(R.id.btn_3)
        btn_4 = findViewById(R.id.btn_4)
        btn_5 = findViewById(R.id.btn_5)
        btn_6 = findViewById(R.id.btn_6)
        btn_7 = findViewById(R.id.btn_7)
        btn_8 = findViewById(R.id.btn_8)
        btn_9 = findViewById(R.id.btn_9)
        btn_percent = findViewById(R.id.btn_percent)
        btn_clear = findViewById(R.id.btn_clear)
        btn_dot = findViewById(R.id.btn_dot)
        btn_equal = findViewById(R.id.btn_equal)
        btn_add = findViewById(R.id.btn_add)
        btn_sub = findViewById(R.id.btn_subtract)
        btn_mul = findViewById(R.id.btn_multiply)
        btn_divi = findViewById(R.id.btn_divide)
        btn_backspace = findViewById(R.id.btn_backspace)
        btn_resultext = findViewById(R.id.result)
        btn_inputext = findViewById(R.id.inputnumber)
        btn_inputext.movementMethod = ScrollingMovementMethod()
        btn_inputext.setActivated(true)
        btn_inputext.setPressed(true)

        var text: String

        btn_1.setOnClickListener{
            text = btn_inputext.text.toString()+"1"
            btn_inputext.setText(text)
            btn_resultext(text)
        }
        btn_00.setOnClickListener{
            text = btn_inputext.text.toString()+"00"
            btn_inputext.setText(text)
            btn_resultext(text)
        }
        btn_0.setOnClickListener{
            text = btn_inputext.text.toString()+"0"
            btn_inputext.setText(text)
            btn_resultext(text)
        }
        btn_2.setOnClickListener{
            text = btn_inputext.text.toString()+"2"
            btn_inputext.setText(text)
            btn_resultext(text)
        }
        btn_3.setOnClickListener{
            text = btn_inputext.text.toString()+"3"
            btn_inputext.setText(text)
            btn_resultext(text)
        }
        btn_4.setOnClickListener{
            text = btn_inputext.text.toString()+"4"
            btn_inputext.setText(text)
            btn_resultext(text)
        }
        btn_5.setOnClickListener{
            text = btn_inputext.text.toString()+"5"
            btn_inputext.setText(text)
            btn_resultext(text)
        }

        btn_6.setOnClickListener{
            text = btn_inputext.text.toString()+"6"
            btn_inputext.setText(text)
            btn_resultext(text)
        }
        btn_7.setOnClickListener{
            text = btn_inputext.text.toString()+"7"
            btn_inputext.setText(text)
            btn_resultext(text)
        }
        btn_8.setOnClickListener{
            text = btn_inputext.text.toString()+"8"
            btn_inputext.setText(text)
            btn_resultext(text)
        }

        btn_9.setOnClickListener{
            text = btn_inputext.text.toString()+"9"
            btn_inputext.setText(text)
            btn_resultext(text)
        }
        btn_dot.setOnClickListener{
            text = btn_inputext.text.toString()+"."
            btn_inputext.setText(text)
            btn_resultext(text)
        }

        btn_add.setOnClickListener {
            text = btn_inputext.text.toString() + "+"
            btn_inputext.setText(text)
            check = check + 1
        }
        btn_sub.setOnClickListener {
            text = btn_inputext.text.toString() + "-"
            btn_inputext.setText(text)
            check = check + 1
        }
        btn_mul.setOnClickListener {
            text = btn_inputext.text.toString() + "*"
            btn_inputext.setText(text)
            check = check + 1
        }
        btn_divi.setOnClickListener {
            text = btn_inputext.text.toString() + "/"
            btn_inputext.setText(text)
            check = check + 1
        }
        btn_percent.setOnClickListener {
            text = btn_inputext.text.toString() + "%"
            btn_inputext.setText(text)
            check = check + 1
        }
        btn_equal.setOnClickListener {
            text = btn_resultext.text.toString()
            btn_inputext.setText(text)
            btn_resultext.setText(null)
        }
        btn_clear.setOnClickListener {
            btn_inputext.setText(null)
            btn_resultext.setText(null)
        }
        btn_backspace.setOnClickListener {

            var Backspace: String?= null
            if(btn_inputext.text.length>0)
            {
                val stringBuilder : StringBuilder = StringBuilder(btn_inputext.text)
                val find=btn_inputext.text.toString()
                val find2=find.last()


                if(find2.equals("+")||find2.equals("-")||find2.equals("*")||find2.equals("/")||find2.equals("%"))
                {
                    check = check-1
                }
                stringBuilder.deleteCharAt(btn_inputext.text.length-1)
                Backspace= stringBuilder.toString()
                btn_inputext.setText(Backspace)
                btn_resultext(Backspace)
            }

        }
    }

    private fun btn_resultext(text: String) {


       val engine:ScriptEngine=ScriptEngineManager().getEngineByName("rhino")
        try{
            val result: Any=engine.eval(text)
            val main=result.toString()
            if(check==0)
            {
                btn_resultext.setText(null)
            }
            else
            {
                btn_resultext.setText(main)

            }
        }
        catch (e: ScriptException)
        {
            Log.d("Tag","Error")
        }

    }
}