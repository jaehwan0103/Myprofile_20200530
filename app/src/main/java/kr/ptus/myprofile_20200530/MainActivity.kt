package kr.ptus.myprofile_20200530

import android.app.Activity
import android.content.Intent
import android.net.Uri
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
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)

        }

        callBtn.setOnClickListener {

            val phoneNum = inputPhoneNumTxt.text.toString()

            val myUri = Uri.parse("tel:${phoneNum.replace("-","")}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

            startActivity(myIntent)
        }

        smsBtn.setOnClickListener {

            val phoneNum = inputPhoneNumTxt.text.toString()
            val smsDescription = smsTxt.text.toString()

            val myUri2 = Uri.parse("smsto:${phoneNum}")
            val myIntent2 = Intent(Intent.ACTION_SENDTO, myUri2)
            myIntent2.putExtra("sms_body", smsDescription)

            startActivity(myIntent2)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_FOR_NICKNAME) {
            if (resultCode == Activity.RESULT_OK) {

                val newNickname = data?.getStringExtra("nick")

                myNickNameTxt.text = newNickname


            }


        }

    }

}
