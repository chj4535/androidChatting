package choi.mvvm.androidchatting.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import choi.mvvm.androidchatting.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() ,BottomNavigationView.OnNavigationItemSelectedListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<View>(R.id.bottomnavigationview) as BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragementView,FriendListFragment())
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d("onNavigationItemSelected",item.itemId.toString())
        when(item.itemId){
            R.id.navigation_friendList->{
                val fragmentA = FriendListFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragementView,fragmentA).commit()
            }
            R.id.navigation_chatList->{
                val fragmentB = ChatListFragement()
                supportFragmentManager.beginTransaction().replace(R.id.fragementView,fragmentB).commit()
            }
            R.id.navigation_info->{
                val fragmentC = InfoFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragementView,fragmentC).commit()
            }

        }
        return true
    }
}
