package com.example.busstop

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.busstop.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val result: TextView = findViewById(R.id.result)

        GlobalScope.launch {
            try {
                val appDatabase = AppDatabase.getDatabase(applicationContext)
                val myDao = appDatabase.scheduleDao()
                val myList = myDao.getAll()
                Log.d("myList", "Number of records: ${myList.size}")
                GlobalScope.launch(Dispatchers.Main) {
//                    val firstTime = SimpleDateFormat(
//                        "h:mm a").format(
//                        Date(myList[0].arrivalTime.toLong() * 1000)
                    result.text = "Number of records: ${myList.size}\n ${myList[0].stopName}"
                }
//                result.text = "Number of records: ${myList.size}"
            }catch (e: Exception){
                Log.d("myLog", e.toString())
            }
        }
    }
}