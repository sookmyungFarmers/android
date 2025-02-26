package com.example.sprinkler_frontend

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // 첫 화면을 HomeFragment로 설정
        replaceFragment(HomeFragment())

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> replaceFragment(HomeFragment())
                R.id.questionFragment -> replaceFragment(QuestionFragment())
                R.id.reviewFragment -> replaceFragment(ReviewFragment())
                R.id.friendsFragment -> replaceFragment(FriendsFragment())
                R.id.profileFragment -> replaceFragment(ProfileFragment())
            }
            true
        }
    }

    // 프래그먼트를 변경하는 함수
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
