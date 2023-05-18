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
var score =0
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
        val yes_body = dialog4.findViewById<TextView>(R.id.yes_body)
        // 팝업창 크기 설정
        dialog4.window?.let {
            it.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        dialog4.setCanceledOnTouchOutside(false) // 외부 여백 클릭 시 Dialog 닫히지 않도록 설정

        if(easy_count==1){
            score++
            yes_body.setText("2017년에서야 국가인권위의 의뢰를 받아\n\n법무부의 협조를 통해 수용자 자녀의\n\n실태를 파악할 수 있었습니다. \n\n이때 이루어진 조사가 수용자 자녀의 인권과 \n\n관련된 첫 조사였습니다. ")
        }else if(easy_count==2){
            score++
            yes_body.setText("핸드폰 개통 등을 할 때, 친권자인 부모가\n\n살아있는 경우에는 법정대리인 동반이\n\n필수이기에 많은 수용자 자녀들이\n\n이런 과정에서 어려움을 겪습니다.")
        }else if(easy_count==3){
            score++
            yes_body.setText("아동복지실천회 세움은 수용자(수감자) 자녀가\n\n당당하게 사는 세상을 만들기 위해서 \n\n2015년 설립된 비영리단체로서 수용자 자녀의 \n\n안전한 보호와 성장, 인권옹호를 위해 활동하는 \n\n국내 유일의 단체입니다.")
        }else if(easy_count==4){
            score++
            yes_body.setText("본 조사에서 확인한 우리나라 수용자자녀수는\n\n연간 5만 4천명으로 추산되었습니다.\n\n이는 우리나라 아동인구의 0.49%가량 됩니다.\n\n해마다 5만 명의 아동이 누적되어 가고 있는만큼\n\n이들에게는 적극적인 지원이 절실합니다.")
        }else if(easy_count==5) {
            score++
            yes_body.setText("우리나라 헌법 제13조 3항은 \n\n연좌제를 금하고 있습니다.\n\n그러므로 ‘범죄자의 자녀’로 낙인찍어\n\n고통을 받게 해서는 안 됩니다.")
        }

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
    fun showDialog6(context: Context, easy_count:Int, dialog1: Dialog) {
        val dialog6 = Dialog(context)
        dialog6.requestWindowFeature(Window.FEATURE_NO_TITLE) // 타이틀바 없애기
        dialog6.setContentView(R.layout.fragment_home_answer_no) // 레이아웃 설정
        val no_body = dialog6.findViewById<TextView>(R.id.no_body)

        // 팝업창 크기 설정
        dialog6.window?.let {
            it.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        dialog6.setCanceledOnTouchOutside(false) // 외부 여백 클릭 시 Dialog 닫히지 않도록 설정

        if(easy_count==1){
            no_body.setText("2017년에서야 국가인권위의 의뢰를 받아\n\n법무부의 협조를 통해 수용자 자녀의\n\n실태를 파악할 수 있었습니다. \n\n이때 이루어진 조사가 수용자 자녀의 인권과 \n\n관련된 첫 조사였습니다. ")
        }else if(easy_count==2){
            no_body.setText("핸드폰 개통 등을 할 때, 친권자인 부모가\n\n살아있는 경우에는 법정대리인 동반이\n\n필수이기에 많은 수용자 자녀들이\n\n이런 과정에서 어려움을 겪습니다.")
        }else if(easy_count==3){
            no_body.setText("아동복지실천회 세움은 수용자(수감자) 자녀가\n\n당당하게 사는 세상을 만들기 위해서 \n\n2015년 설립된 비영리단체로서 수용자 자녀의 \n\n안전한 보호와 성장, 인권옹호를 위해 활동하는 \n\n국내 유일의 단체입니다.")
        }else if(easy_count==4){
            no_body.setText("본 조사에서 확인한 우리나라 수용자자녀수는\n\n연간 5만 4천명으로 추산되었습니다.\n\n이는 우리나라 아동인구의 0.49%가량 됩니다.\n\n해마다 5만 명의 아동이 누적되어 가고 있는만큼\n\n이들에게는 적극적인 지원이 절실합니다.")
        }else if(easy_count==5) {
            no_body.setText("우리나라 헌법 제13조 3항은 \n\n연좌제를 금하고 있습니다.\n\n그러므로 ‘범죄자의 자녀’로 낙인찍어\n\n고통을 받게 해서는 안 됩니다.")
        }

        dialog6.show() // 팝업창 보이기
        val next = dialog6.findViewById<ImageView>(R.id.next)
        next.setOnClickListener {
            dialog6.dismiss()
            if(easy_count ==5){
                showDialog5(requireContext())
                dialog6.dismiss()
            }
        }
    }
    fun showDialog5(context: Context) {
        val dialog5 = Dialog(context)
        dialog5.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog5.setContentView(R.layout.fragment_home_quiz_end_easy)
        val end_btn = dialog5.findViewById<ImageView>(R.id.end_btn)
        val score_text = dialog5.findViewById<TextView>(R.id.score)

        dialog5.window?.let {
            it.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        dialog5.setCanceledOnTouchOutside(false) // 외부 여백 클릭 시 Dialog 닫히지 않도록 설정
        score_text.setText("$score / 5") //!!!!!!!!!!!!!!!!!!!!!11
        dialog5.show()

        end_btn.setOnClickListener {
            dialog5.dismiss()
        }
    }
    fun showDialog1(context: Context) {
        score = 0
        var easy_count = 0
        var count = 0
        var ox_count =0
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
        val difficulty = dialog1.findViewById<TextView>(R.id.difficulty)
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
                //easy_count++
                count=1
                Log.e("HelpFragment", "Count2 $count")
                checkans_easy.setBackgroundResource(R.drawable.home_quiz_checkans_easy_yello)
                whitecorrect.setImageDrawable(drawable1)
                checkans_easy.setOnClickListener {
                    ox_count=0
                    if(count==1) {
                        Log.e("HelpFragment", "Count3 $count")
                        //showDialog4(requireContext(), easy_count, dialog1) //맞은거
                        whitecorrect.setImageDrawable(drawable3)
                        checkans_easy.setBackgroundResource(R.drawable.home_quiz_check_answer)
                        count = 0
                        easy_count++
                        if (easy_count == 1) {
                            Log.e("HelpFragment", "Quiz2")
                            showDialog6(requireContext(), easy_count, dialog1) //틀린거
                            line1.visibility = View.INVISIBLE
                            line2.visibility = View.VISIBLE
                            count = 0
                            difficulty.setText("Q.2")
                            easy_body.setText("미성년자 수용자 자녀는 핸드폰 개통, \n\n여권 발급, 개인정보 열람 등에 대해\n\n법정대리인 동의없이 예외적으로 가능하다.\n\n")
                        } else if (easy_count == 2) {
                            showDialog6(requireContext(), easy_count, dialog1) //맞은거
                            line2.visibility = View.INVISIBLE
                            line3.visibility = View.VISIBLE
                            count = 0
                            difficulty.setText("Q.3")
                            easy_body.setText("세움은 국내에서 수용자 자녀의\n\n안전한 보호와 성장, 인권옹호를 위해\n\n활동하는 국내 유일 단체이다.")
                            Log.e("HelpFragment", "Quiz3")
                        } else if (easy_count == 3) {
                            showDialog4(requireContext(), easy_count, dialog1) //틀린거
                            line3.visibility = View.INVISIBLE
                            line4.visibility = View.VISIBLE
                            count = 0
                            difficulty.setText("Q.4")
                            easy_body.setText("2017년 국가인권위원회가 대대적인\n\n실태조사를 펼치며 추산한 결과로는\n\n연간 수용자 자녀는 5만4000여명에 달한다.")
                            Log.e("HelpFragment", "Quiz4")
                        } else if (easy_count == 4) {
                            showDialog4(requireContext(), easy_count, dialog1) //맞은거
                            line4.visibility = View.INVISIBLE
                            line5.visibility = View.VISIBLE
                            count = 0
                            difficulty.setText("Q.5")
                            easy_body.setText("대한민국 헌법은 연좌제\n\n(범죄인과 특정한 관계에 있는 사람에게 \n\n연대책임을 지게 하고 처벌하는 제도)\n\n를 금지하고 있다")
                            Log.e("HelpFragment", "Quiz5")
                        } else if (easy_count == 5) {
                            showDialog4(requireContext(), easy_count, dialog1) //맞은거
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
                    whitewrong.setImageDrawable(drawable4)
                    checkans_easy.setBackgroundResource(R.drawable.home_quiz_check_answer)
                    count = 0
                    if (easy_count == 1) {
                        Log.e("HelpFragment", "Quiz2")
                        showDialog4(requireContext(), easy_count, dialog1) //맞는거
                        line1.visibility = View.INVISIBLE
                        line2.visibility = View.VISIBLE
                        difficulty.setText("Q.2")
                        easy_body.setText("미성년자 수용자 자녀는 핸드폰 개통, \n\n여권 발급, 개인정보 열람 등에 대해\n\n법정대리인 동의없이 예외적으로 가능하다.\n\n")
                        count = 0
                    } else if (easy_count == 2) {
                        showDialog4(requireContext(), easy_count, dialog1) //틀린거
                        line2.visibility = View.INVISIBLE
                        line3.visibility = View.VISIBLE
                        difficulty.setText("Q.3")
                        easy_body.setText("세움은 국내에서 수용자 자녀의\n\n안전한 보호와 성장, 인권옹호를 위해\n\n활동하는 국내 유일 단체이다.")
                        count = 0
                        Log.e("HelpFragment", "Quiz3")
                    } else if (easy_count == 3) {
                        showDialog6(requireContext(), easy_count, dialog1) //맞는거
                        line3.visibility = View.INVISIBLE
                        line4.visibility = View.VISIBLE
                        difficulty.setText("Q.4")
                        easy_body.setText("2017년 국가인권위원회가 대대적인\n\n실태조사를 펼치며 추산한 결과로는\n\n연간 수용자 자녀는 5만4000여명에 달한다.")
                        count = 0
                        Log.e("HelpFragment", "Quiz4")
                    } else if (easy_count == 4){
                        showDialog6(requireContext(), easy_count, dialog1) //틀린거
                        line4.visibility = View.INVISIBLE
                        line5.visibility = View.VISIBLE
                        difficulty.setText("Q.5")
                        easy_body.setText("대한민국 헌법은 연좌제\n\n(범죄인과 특정한 관계에 있는 사람에게 \n\n연대책임을 지게 하고 처벌하는 제도)\n\n를 금지하고 있다")
                        count = 0
                        Log.e("HelpFragment", "Quiz5")
                    }else if (easy_count == 5){
                        showDialog4(requireContext(), easy_count, dialog1) //맞는거
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
        score = 0
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