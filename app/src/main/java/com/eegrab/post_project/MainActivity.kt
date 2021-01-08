package com.eegrab.post_project

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.eegrab.post_project.repository.Repository
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var tempEmp: String
    private lateinit var response_text: String
    private lateinit var name: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.pushPost3("10235884", "contractor_id")
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()

                val jsonString = Gson().toJson(response.body())
                val obj = JSONObject(jsonString)
                tempEmp = obj.getString("user")
                Log.d("Main code is", tempEmp)
                System.out.println("Main type is " + tempEmp.javaClass.name)

//                val obj1 = JSONObject(tempEmp)
//                val tempEmp1: String = obj.getString("contractorId")
//                Log.d("Main contract is", tempEmp1)

                val jsonarray = JSONArray(tempEmp)
                var id: String =""
                for (i in 0 until jsonarray.length()) {
                    val jsonobject = jsonarray.getJSONObject(i)
                    id = jsonobject.getString("contractCompanyId")
                }
                Log.d("Main contract is", id)


//                System.out.println(obj.javaClass.name)
//                response_text = response.body().toString().trim()
//                var jsonString1 = "{\"employee\":\"abhi\",\"pet\":\"parrot\"}"
//
//                try {
//                    // some code

//                }
//                catch (e: Exception) {
//                    // handler
//                    println("Main exception is " + e)
//                }
//
//                println("Main employee name is " + tempEmp)
                Log.d("Main", response.code().toString())
                //Do something after 100ms
                Log.d("Main", response.body().toString())
//                    Log.d("Main", tempEmp)


            } else {
                Log.d("Error", response.errorBody().toString())
                Toast.makeText(this, response.errorBody().toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }


}