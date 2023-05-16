package com.example.hugu.fragment

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.hugu.R
import com.example.hugu.databinding.FragmentHomeQuizBinding
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeQuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeQuizFragment : Fragment() {
    lateinit var viewbinding: FragmentHomeQuizBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewbinding = FragmentHomeQuizBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_quiz, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var hardQuiz = view.findViewById<ImageView>(R.id.hard_quiz)
        var normalQuiz = view.findViewById<ImageView>(R.id.normal_quiz)
        var easyQuiz = view.findViewById<ImageView>(R.id.easy_quiz)

        var check_option = view.findViewById<ImageView>(R.id.first_option)
        hardQuiz.setOnClickListener {
            //check_option.setColorFilter(Color.parseColor("#000000000"))
            showDialog3(requireContext())
        }
        normalQuiz.setOnClickListener {

            showDialog2(requireContext())
        }
        easyQuiz.setOnClickListener {
            showDialog1(requireContext())
        }
    }

    fun showDialog4(context: Context, easy_count:Int, dialog1: Dialog) {
        val dialog4 = Dialog(context)
        dialog4.requestWindowFeature(Window.FEATURE_NO_TITLE) // 타이틀바 없애기
        dialog4.setContentView(R.layout.fragment_home_answer_yes) // 레이아웃 설정

        // 팝업창 크기 설정
        dialog4.window?.let {
            it.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        dialog4.setCanceledOnTouchOutside(false) // 외부 여백 클릭 시 Dialog 닫히지 않도록 설정
        dialog4.show() // 팝업창 보이기
        val next = dialog4.findViewById<ImageView>(R.id.next)
        next.setOnClickListener {
            dialog4.dismiss()
            if(easy_count ==5){
                showDialog5(requireContext())
                dialog1.dismiss()
            }
        }
    }
    fun showDialog5(context: Context) {
        val dialog5 = Dialog(context)
        dialog5.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog5.setContentView(R.layout.fragment_home_quiz_end_easy)
        val end_btn = dialog5.findViewById<ImageView>(R.id.end_btn)

        dialog5.window?.let {
            it.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        dialog5.setCanceledOnTouchOutside(false) // 외부 여백 클릭 시 Dialog 닫히지 않도록 설정

        dialog5.show()

        end_btn.setOnClickListener {
            dialog5.dismiss()
        }
    }
    fun showDialog1(context: Context) {
        var easy_count = 0
        var count = 0
        val dialog1 = Dialog(context)
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE) // 타이틀바 없애기
        dialog1.setContentView(R.layout.fragment_home_quiz_easy) // 레이아웃 설정

        // 팝업창 크기 설정
        dialog1.window?.let {
            it.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            it.setBackgroundDrawable(ColorDrawable(Color.WHITE)) // 배경을 투명하게 만듦
        }

        dialog1.show() // 팝업창 보이기
        val easy_body = dialog1.findViewById<TextView>(R.id.easy_body)
        val whitecorrect = dialog1.findViewById<ImageView>(R.id.whitecorrect)
        val whitewrong = dialog1.findViewById<ImageView>(R.id.whitewrong)
        val checkans_easy = dialog1.findViewById<ImageView>(R.id.checkans_easy)
        val drawable1 = ContextCompat.getDrawable(context, R.drawable.home_quiz_bluecorrect)
        val drawable2 = ContextCompat.getDrawable(context, R.drawable.home_quiz_redwrong)
        val drawable3 = ContextCompat.getDrawable(context, R.drawable.home_quiz_correct_btn)
        val drawable4 = ContextCompat.getDrawable(context, R.drawable.home_quiz_wrong_btn)

        val line1 = dialog1.findViewById<ImageView>(R.id.line1)
        val line2 = dialog1.findViewById<ImageView>(R.id.line2)
        val line3 = dialog1.findViewById<ImageView>(R.id.line3)
        val line4 = dialog1.findViewById<ImageView>(R.id.line4)
        val line5 = dialog1.findViewById<ImageView>(R.id.line5)
        val line6 = dialog1.findViewById<ImageView>(R.id.line6)
        whitecorrect.setOnClickListener {
            Log.e("HelpFragment", "Count1 $count")
            if (count == 0) {
                count=1
                easy_count++
                Log.e("HelpFragment", "Count2 $count")
                checkans_easy.setBackgroundResource(R.drawable.home_quiz_checkans_easy_yello)
                whitecorrect.setImageDrawable(drawable1)
                checkans_easy.setOnClickListener {
                    if(count==1) {
                        Log.e("HelpFragment", "Count3 $count")
                        showDialog4(requireContext(), easy_count,dialog1)
                        whitecorrect.setImageDrawable(drawable3)
                        checkans_easy.setBackgroundResource(R.drawable.home_quiz_check_answer)
                        count = 0
                        if (easy_count == 1) {
                            Log.e("HelpFragment", "Quiz2")
                            line1.visibility = View.INVISIBLE
                            line2.visibility = View.VISIBLE
                            count = 0
                            easy_body.setText("미성년자 수용자 자녀는\n\n핸드폰 개통, 여권 발급, 개인정보 열람 등을 만들기 힘듭니다.\n\n그 이유는 무엇일까요?")
                        } else if (easy_count == 2) {
                            line2.visibility = View.INVISIBLE
                            line3.visibility = View.VISIBLE
                            count = 0
                            easy_body.setText("수용자 자녀를 지원하는 해외 민간 단체가\n\n아닌 것은 무엇인가요?")
                            Log.e("HelpFragment", "Quiz3")
                        } else if (easy_count == 3) {
                            line3.visibility = View.INVISIBLE
                            line4.visibility = View.VISIBLE
                            count = 0
                            easy_body.setText("우리나라에서 법률과 관련된 내용으로\n\n옳은 것은 무엇일까요?")
                            Log.e("HelpFragment", "Quiz4")
                        } else if (easy_count == 4) {
                            line4.visibility = View.INVISIBLE
                            line5.visibility = View.VISIBLE
                            count = 0
                            easy_body.setText("교정본부가 하는 일로 \n\n옳지 않은 내용은 무엇일까요?")
                            Log.e("HelpFragment", "Quiz5")
                        } else if (easy_count == 5) {
                            line5.visibility = View.INVISIBLE
                            line6.visibility = View.VISIBLE
                            count = 0
                            Log.e("HelpFragment", "Quiz6")
                        }
                    }
                }
            }
        }
        whitewrong.setOnClickListener {
            if (count == 0) {
                count=1
                easy_count++
                whitecorrect.setImageDrawable(drawable3)
                whitewrong.setImageDrawable(drawable2)
                checkans_easy.setBackgroundResource(R.drawable.home_quiz_checkans_easy_yello)
                checkans_easy.setOnClickListener {
                    showDialog4(requireContext(),easy_count,dialog1)
                    whitewrong.setImageDrawable(drawable4)
                    checkans_easy.setBackgroundResource(R.drawable.home_quiz_check_answer)
                    count = 0
                    if (easy_count == 1) {
                        Log.e("HelpFragment", "Quiz2")
                        line1.visibility = View.INVISIBLE
                        line2.visibility = View.VISIBLE
                        count = 0
                    } else if (easy_count == 2) {
                        line2.visibility = View.INVISIBLE
                        line3.visibility = View.VISIBLE
                        count = 0
                        Log.e("HelpFragment", "Quiz3")
                    } else if (easy_count == 3) {
                        line3.visibility = View.INVISIBLE
                        line4.visibility = View.VISIBLE
                        count = 0
                        Log.e("HelpFragment", "Quiz4")
                    } else if (easy_count == 4){
                        line4.visibility = View.INVISIBLE
                        line5.visibility = View.VISIBLE
                        count = 0
                        Log.e("HelpFragment", "Quiz5")
                    }else if (easy_count == 5){
                        line5.visibility = View.INVISIBLE
                        line6.visibility = View.VISIBLE
                        count = 0
                        Log.e("HelpFragment", "Quiz6")
                    }
                }
            }
        }
    }
    fun showDialog2(context: Context) {
        var count = 0
        val dialog2 = Dialog(context)
        dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE) // 타이틀바 없애기
        dialog2.setContentView(R.layout.fragment_home_quiz_normal) // 레이아웃 설정
        // 팝업창 크기 설정
        dialog2.window?.let {
            it.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            it.setBackgroundDrawable(ColorDrawable(Color.WHITE)) // 배경을 투명하게 만듦
        }

        dialog2.show() // 팝업창 보이기
        val first_option = dialog2.findViewById<TextView>(R.id.first_option)
        val second_option = dialog2.findViewById<TextView>(R.id.second_option)
        val third_option = dialog2.findViewById<TextView>(R.id.third_option)
        val fourth_option = dialog2.findViewById<TextView>(R.id.fourth_option)
        val checkans = dialog2.findViewById<ImageView>(R.id.checkans_normal)
        first_option.setOnClickListener {
            count++
            if (count == 1) {
                first_option.setBackgroundResource(R.drawable.home_quiz_round_yello)
                checkans.visibility = View.VISIBLE
            }
        }
        second_option.setOnClickListener {
            count++
            if (count == 1) {
                second_option.setBackgroundResource(R.drawable.home_quiz_round_yello)
                checkans.visibility = View.VISIBLE
            }
        }
        third_option.setOnClickListener {
            count++
            if (count == 1) {
                third_option.setBackgroundResource(R.drawable.home_quiz_round_yello)
                checkans.visibility = View.VISIBLE
            }
        }
        fourth_option.setOnClickListener {
            count++
            if (count == 1) {
                fourth_option.setBackgroundResource(R.drawable.home_quiz_round_yello)
                checkans.visibility = View.VISIBLE
            }
        }
    }

    fun showDialog3(context: Context) {
        val dialog3 = Dialog(context)
        dialog3.requestWindowFeature(Window.FEATURE_NO_TITLE) // 타이틀바 없애기
        dialog3.setContentView(R.layout.fragment_home_quiz_hard) // 레이아웃 설정

        // 팝업창 크기 설정
        dialog3.window?.let {
            it.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            it.setBackgroundDrawable(ColorDrawable(Color.WHITE)) // 배경을 투명하게 만듦
        }

        dialog3.show() // 팝업창 보이기

    }
}