package com.example.aftecalintweb

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class IntentActivity : AppCompatActivity() {
    lateinit var buttonsms:Button
    lateinit var buttonshare:Button
    lateinit var buttonemail:Button
    lateinit var buttoncalls:Button
    lateinit var buttonstk:Button
    lateinit var buttoncamera:Button
    lateinit var buttondial:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        buttonsms=findViewById(R.id.btn_SMS)
        buttonshare=findViewById(R.id.btn_share)
        buttonemail=findViewById(R.id.btn_Email)
        buttoncalls=findViewById(R.id.btn_Calls)
        buttonstk=findViewById(R.id.btn_STK)
        buttoncamera=findViewById(R.id.btn_camera)
        buttondial=findViewById(R.id.btn_Dial)

        buttonsms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:YOUR_SMS_NUMBER")

            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("sms_body", "The SMS text")

            startActivity(intent)

        }
        buttonshare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            startActivity(shareIntent)

        }
        buttonemail.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }
        buttoncalls.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
            buttonstk.setOnClickListener {
                val simToolKitLaunchIntent =
                    applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

                simToolKitLaunchIntent?.let { startActivity(it) }

            }
            buttondial.setOnClickListener {
                val phone = "+34666777888"

                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

                startActivity(intent)
            }
            buttoncamera.setOnClickListener {
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                startActivityForResult(takePictureIntent, 1)

            }


        }






    }
}