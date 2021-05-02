package com.rainyseason.dogeapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {

  private lateinit var mainDogeIcon: ImageView
  private lateinit var mainDogeIconV2: ImageView
  private lateinit var mainFact: TextView
  private lateinit var notice: TextView

  private var showV2: Boolean = false
  private var clickCount = 0


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    mainDogeIcon = findViewById(R.id.main_doge_icon)
    mainDogeIconV2 = findViewById(R.id.main_doge_icon_v2)
    mainFact = findViewById(R.id.main_fact)
    notice = findViewById(R.id.notice)


    val onClick = View.OnClickListener {
      showV2 = !showV2
      invalidate()
      clickCount++
    }

    mainDogeIcon.setOnClickListener(onClick)
    mainDogeIconV2.setOnClickListener(onClick)

    invalidate()
  }

  private fun invalidate() {
    mainFact.text = if (showV2) {
      "10 Dogecoin = 10 Dogecoin"
    } else {
      "1 Dogecoin = 1 Dogecoin"
    }

    mainDogeIcon.isInvisible = showV2
    mainDogeIconV2.isInvisible = !showV2

    notice.text = if (clickCount < 10) {
      "Such click!"
    } else {
      "Wow, much click!"
    }

  }
}