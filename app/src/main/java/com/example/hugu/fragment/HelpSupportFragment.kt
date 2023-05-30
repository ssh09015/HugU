package com.example.hugu.fragment

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Rect
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import com.example.hugu.databinding.FragmentHelpSupportBinding


class HelpSupportFragment : Fragment() {
    private lateinit var viewbinding:FragmentHelpSupportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewbinding = FragmentHelpSupportBinding.inflate(inflater, container, false)
        viewbinding.shareButton.setOnClickListener {
            try {
                val sendText = "https://bit.ly/3Lvjb1g"
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_TEXT, sendText)
                sendIntent.type = "text/plain"
                startActivity(Intent.createChooser(sendIntent, "Share"))
            } catch (ignored: ActivityNotFoundException) {
                Log.d("test", "ignored : $ignored")
            }
        }
        viewbinding.join.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/3Lvjb1g"))
            startActivity(intent)
        }

        viewbinding.btnJoin.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/3Lvjb1g"))
            startActivity(intent)
        }
        setupStickyFooter()
        return viewbinding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setupStickyFooter(){
        viewbinding.clBtnJoin.isInvisible=viewbinding.nsSign.isViewVisible(viewbinding.clBtnJoin)==false
        viewbinding.nsSign.setOnScrollChangeListener { _, _, _, _, _ ->
            viewbinding.clBtnJoin.isInvisible=viewbinding.nsSign.isViewVisible(viewbinding.clBtnJoin)==false
            viewbinding.clJoin.isVisible = viewbinding.nsSign.isViewVisible(viewbinding.clBtnJoin) == false

        }
    }

    companion object {
        fun NestedScrollView.isViewVisible(view: View): Boolean {
            val scrollBounds = Rect()
            this.getDrawingRect(scrollBounds)
            val top = view.y
            val bottom = view.height + top
            return scrollBounds.bottom > bottom
        }
    }
}