
package com.nsamedia.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    private val background = Color.rgb(15, 18, 28)
    private val panel = Color.rgb(29, 34, 48)
    private val white = Color.WHITE
    private val muted = Color.rgb(165, 174, 192)
    private val accent = Color.rgb(80, 170, 255)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(22), dp(28), dp(22), dp(24))
            setBackgroundColor(background)
        }

        val scroll = ScrollView(this)
        scroll.addView(root)

        val title = TextView(this).apply {
            text = "NSA MEDIA"
            textSize = 29f
            setTextColor(white)
            setTypeface(null, android.graphics.Typeface.BOLD)
        }

        val subtitle = TextView(this).apply {
            text = "YOUR PERSONAL MEDIA CENTRE"
            textSize = 11f
            setTextColor(muted)
            letterSpacing = 0.15f
        }

        val connection = TextView(this).apply {
            text = "●  NAS SERVER  •  192.168.0.27"
            textSize = 13f
            setTextColor(Color.rgb(100, 210, 140))
            setPadding(dp(14), dp(16), dp(14), dp(16))
            setBackgroundColor(panel)
        }

        root.addView(title)
        root.addView(subtitle, margin(0, 4, 0, 28))
        root.addView(connection, margin(0, 0, 0, 30))

        addHeading(root, "YOUR LIBRARY")
        addCategory(root, "🎬", "MOVIES", "Your film collection")
        addCategory(root, "📺", "TV SHOWS", "Your television series")
        addCategory(root, "♫", "MUSIC", "Your music collection")

        val footer = TextView(this).apply {
            text = "NSA310  •  MEDIA LIBRARY"
            textSize = 11f
            gravity = Gravity.CENTER
            setTextColor(muted)
            setPadding(0, dp(30), 0, dp(10))
        }

        root.addView(footer)
        setContentView(scroll)
    }

    private fun addHeading(root: LinearLayout, text: String) {
        val heading = TextView(this).apply {
            this.text = text
            textSize = 13f
            setTextColor(muted)
            setPadding(0, 0, 0, dp(14))
        }
        root.addView(heading)
    }

    private fun addCategory(
        root: LinearLayout,
        symbol: String,
        heading: String,
        description: String
    ) {
        val card = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(18), dp(22), dp(18), dp(22))
            setBackgroundColor(panel)
        }

        val icon = TextView(this).apply {
            text = symbol
            textSize = 30f
            setTextColor(white)
        }

        val details = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(18), 0, 0, 0)
        }

        val name = TextView(this).apply {
            text = heading
            textSize = 17f
            setTextColor(white)
            setTypeface(null, android.graphics.Typeface.BOLD)
        }

        val info = TextView(this).apply {
            text = description
            textSize = 12f
            setTextColor(muted)
        }

        details.addView(name)
        details.addView(info, margin(0, 4, 0, 0))

        card.addView(icon)
        card.addView(details)

        card.setOnClickListener {
            Toast.makeText(
                this,
                "$heading library is coming in the next upgrade",
                Toast.LENGTH_SHORT
            ).show()
        }

        root.addView(card, margin(0, 0, 0, 14))
    }

    private fun dp(value: Int): Int =
        (value * resources.displayMetrics.density).toInt()

    private fun margin(
        left: Int,
        top: Int,
        right: Int,
        bottom: Int
    ): LinearLayout.LayoutParams {
        return LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(dp(left), dp(top), dp(right), dp(bottom))
        }
    }
}
