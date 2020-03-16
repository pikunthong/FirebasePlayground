package th.ac.su.ict.firebaseplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.common.collect.Multimap
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherCollection = db.collection("weather")

        val data1:MutableMap<String,Any> = HashMap()
        data1["temp"] = 21
        data1["humidity"] = 90

        val data2:MutableMap<String,Any> = HashMap()
        data2["temp"] = 23
        data2["humidity"] = 60

        weatherCollection.document("BKK").set(data2)

        val bkkDocRef = db.collection("weather").document("BKK")

        bkkDocRef.get()
            .addOnSuccessListener {

                Log.d("Firebase_debug",it.data.toString())//ไอดีของไอเทม

                val temp = it["temp"]
                val Humidity = it ["Humidity"]
                tvTemp.setText(temp.toString())
                tvHumidity.setText(Humidity.toString())

            }//ถ้าทำสำเร็จจะให้เกิดอะไรขึ้น

            .addOnFailureListener({

            })//ถ้าทำไมสำเร็จจะเกิดอะไรขึ้น

       // weatherCollection.document("FnrUlgRhQ00PaZ13dO8B").set(data1) //เปลี่ยนข้อมูล


//        weatherCollection.add(data1)

//        weatherCollection.add(data1)

//            .addOnSuccessListener {
//
//                Log.d("Firebase_debug",it.id)//ไอดีของไอเทม
//
//            }//ถ้าแอดสำเร็จจะทำงานนี้
//
//            .addOnFailureListener({
//
//                Log.d("Firebase_debug",it.toString())//ไอดีของไอเทม
//
//            })//ถ้าแอดไม่สำเร็จจะทำงานนี้



    }
}
