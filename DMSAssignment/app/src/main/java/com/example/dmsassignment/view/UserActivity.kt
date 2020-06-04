package com.example.dmsassignment.view

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.example.dmsassignment.GithubApi
import com.example.dmsassignment.R
import com.example.dmsassignment.UtilClass
import com.example.dmsassignment.data.UserInfo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import splitties.toast.toast

class UserActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val username = intent.getStringExtra("username") ?: UtilClass.getUsername(applicationContext)


        val call = GithubApi().service.getUserInfo(username)
        loadInfo(call)

        text_repositories_list.setOnClickListener {
            val repoIntent = Intent(this, RepositoryActivity::class.java)
            repoIntent.putExtra("username",UtilClass.getUsername(applicationContext))
            startActivity(repoIntent)

        }

        text_stars_list.setOnClickListener {
            val starsIntent = Intent(this, StarsActivity::class.java)
            starsIntent.putExtra("username",UtilClass.getUsername(applicationContext))

            startActivity(starsIntent)

        }

        text_followers_list.setOnClickListener {
            val followersIntent = Intent(this, FollowersActivity::class.java)
            followersIntent.putExtra("username",UtilClass.getUsername(applicationContext))

            startActivity(followersIntent)


        }

        text_following_list.setOnClickListener {
            val followingIntent = Intent(this, FollowingActivity::class.java)
            followingIntent.putExtra("username",UtilClass.getUsername(applicationContext))

            startActivity(followingIntent)


        }
        change_username_button.setOnClickListener {
          showChangeUsernameDialog()


        }








    }
    fun showChangeUsernameDialog() {
        val dialog = ChangeUsernameDialogFragment()
        dialog.show(supportFragmentManager, "ChangeUsernameDialogFragment")
    }
    fun loadInfo(call : Call<UserInfo>){
        call.enqueue(object : Callback<UserInfo> {
            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                t.printStackTrace()
                Log.d("ㅇㅁ","ㅂㅁㅇㄻ")

            }

            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                if(response.code()==200){
                    Log.d("성공","ㅋ")

                    text_name.text = response.body()?.name ?: ""
                    text_id.text = response.body()?.id
                    text_blog.text = response.body()?.blog
                    text_followers.text = response.body()?.followers.toString() + " followers"

                    text_following.text = response.body()?.following.toString() + " following"
                    repositories_count.text = response.body()?.publicRepos.toString()

                    followers_count.text = response.body()?.followers.toString()

                    following_count.text = response.body()?.following.toString()
                    Glide.with(this@UserActivity)
                        .load(response.body()?.avatar_url.toString())
                        .into(profile_image)





                }
                else{
                    Log.d("ㅁㅇㄹ",response.code().toString())
                }

            }

        })
    }



}