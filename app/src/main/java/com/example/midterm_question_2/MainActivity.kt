package com.example.midterm_question_2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Objects

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val spinnerContainer = findViewById<Spinner>(R.id.spinner)
        val findBtn = findViewById<Button>(R.id.findBtn)
        val resultText = findViewById<TextView>(R.id.resultText)
        val countriesList = arrayOf("Please select a country","Canada","USA","India")
        var countrySelected = ""
        val intent = intent
        val action = intent.action
        val type = intent.type
        if (Intent.ACTION_SEND == action && type != null) {
            if ("text/plain" == type) {

                val sharedText = intent.getStringExtra(Intent.EXTRA_TEXT)

                if(!(sharedText.isNullOrEmpty())){
                    resultText.text = sharedText.toString()
                }
            }
        }
        val countryAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countriesList)
        spinnerContainer.adapter = countryAdapter
        spinnerContainer.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                countrySelected = countriesList.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }
        findBtn.setOnClickListener{
            when(countrySelected){
                "Canada"->{
                    resultText.text = "The famous cities of the Canada are Toronto, Vancover and Montreal.\n" +
                            "Toronto is capital of Ontario state and it is the biggest city of Canada.\n"+"Vancover is capital of British Columbia province it is the 2nd largest city\n"+"Montreal is a capital of Quebec province and it is just like any other European cities."
                }
                "USA"->{
                    resultText.text = "The famous cities of the USA are New York, Los Angeles and Las Vegas.\n" +
                            "New york is the financial capital of USA and it is the biggest city of USA.\n"+"Los Angeles is home of hollywood it is second largest city of USA\n"+"Las Vegas is home to world famous casions and people around the world visit this city every year."

                }
                "India"->{
                    resultText.text = "The famous cities of the India is Mumbai and Delhi.\n"+"Mumbai is home to bollywood and people all round the world visit this city. Bhaji Pav is the famous dish of this city.\n"+"Delhi is the capital of the India is the biggest city of India and all the central government of India buildings are located in Delhi"
                }
                "Please select a country"->{
                    resultText.text = "Please select a country."
                }
            }
        }
    }
}