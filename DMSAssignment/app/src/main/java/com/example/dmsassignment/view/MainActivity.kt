package com.example.dmsassignment.view

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import com.example.dmsassignment.R
import com.example.dmsassignment.UtilClass
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.internal.Util
import splitties.toast.toast

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkUsername()


        button.setOnClickListener {
            if(editText.text==null)
                toast("유저 이름을 입력하세요")
            else
            showSubmitDialog(editText.text.toString())

        }
    }
    fun checkUsername(){
       if(UtilClass.getUsername(applicationContext)!="default"){
           val intent= Intent(this,UserActivity::class.java)
           Log.d("username",UtilClass.getUsername(applicationContext))
           startActivity(intent)
           finish()
       }
    }
    fun showSubmitDialog(userId: String) {

        val dialog = SubmitDialogFragment(userId)
        dialog.show(supportFragmentManager, "SubmitDialogFragment")

        }

}
