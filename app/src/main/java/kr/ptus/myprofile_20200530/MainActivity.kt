package kr.ptus.myprofile_20200530

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_NICKNAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNickNameBtn.setOnClickListener {

            val myIntent = Intent(this, EditNickNameActivity::class.java)
            startActivityForResult(myIntent,REQ_FOR_NICKNAME)

        }

    }


}
