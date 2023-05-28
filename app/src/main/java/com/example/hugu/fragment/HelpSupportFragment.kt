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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HelpSupportFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class HelpSupportFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewbinding:FragmentHelpSupportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HelpSupportFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HelpSupportFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}