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
        if(dialog1.findViewById<TextView>(R.id.difficulty).text=="easy"){
            if(easy_count==1){
                score++
                Log.e("HelpFragment", "111")
                yes_body.setText("2017년 국가인권위원회의 실태조사결과\n\n수용자 자녀는 연간 약 5만 4천명입니다.\n\n또한 2021년 전국 교정시설 수용자 전수조사 결과\n\n1만 2천명으로 나타났습니다.")
            }else if(easy_count==2){
                score++
                yes_body.setText("심리정서 상담, 성장지원비, 멘토링 활동,\n\n당사자 청년 자문단, 면회 지원 등\n\n수용자 자녀가 당당하게 서기 위해\n\n세움에서 많은 지원을 하고 있습니다.")
            }else if(easy_count==3){
                score++
                yes_body.setText("일반 수용자는 재복역률이 3년 안에 25%입니다.\n\n반면, 세움에서 수용자 자녀를 지원했을 때, 부모가\n\n다시 복역하는 비율은 5.7%에 머물렀습니다.")
            }else if(easy_count==4){
                score++
                yes_body.setText("수용자 자녀 부모와의 격리로\n\n경제적 고통뿐만 아니라\n\n사회적 편견과 낙인으로 인한 \n\n심리적/정서적 고통도 크다.")
            }else if(easy_count==5) {
                score++
                yes_body.setText("우리나라 헌법 제13조 3항은 \n\n연좌제를 금하고 있습니다.\n\n그러므로 ‘범죄자의 자녀’로 낙인찍어\n\n고통을 받게 해서는 안 됩니다.")
            }
        }
        Log.e("HelpFragmeddddnt", "normal1${dialog1.findViewById<TextView>(R.id.difficulty).text}")
        if(dialog1.findViewById<TextView>(R.id.difficulty).text=="noraml"){
            if(easy_count==1){
                score++
                yes_body.setText("국내 유일의 수용자자녀 전문지원기관 “세움”은\n\n수용자의 자녀와 가족을 세상의 중심에\n\n세우고 함께 걸아가기 위해 설립되었습니다.")
            }else if(easy_count==2){
                score++
                yes_body.setText("법무부의 2021년 조사 결과, 미성년 자녀가 있는\n\n수용자 중 양육비를 지원에 의지하는 수용자는\n\n444명(5.7%)으로 밝혀졌습니다. 입소 전 \n\n기초생활 수급 등 국가지원 대상자가 1,649명으로\n\n지원을 받지 못한다는 것을 알 수 있습니다.")
            }else if(easy_count==3){
                score++
                yes_body.setText("유엔 아동권리협약 - 제2조 차별금지\n\n아동은 차별받지 않을 권리가 있습니다.\n\n부모의 상황이나 사회적 신분 등에 상관없이\n\n모든 아동은 동등한 권리를 누려야 합니다.")
            }else if(easy_count==4){
                score++
                yes_body.setText("이외에도 부모가 수용된 후에도\n\n안정적인 집에서 건강한 어른의 보살핌을 받고\n\n보호받을 권리,부모가 수용된 후에도\n\n신체적으로 건강하게 심리적으로\n\n보호받을 수 있는 권리등이 존재합니다.")
            }else if(easy_count==5) {
                score++
                yes_body.setText("형사절차가 진행되는 동안 자녀를\n\n보호하기 위해서는 아동보호환경 마련하기,\n\n부모를 만날 권리 지키기,수용자 자녀 전문\n\n지원기관의 도움 받기등이 필요합니다.  ")
            }
        }
        if(dialog1.findViewById<TextView>(R.id.difficulty).text=="hard"){
            if(easy_count==1){
                score++
                yes_body.setText("유엔아동권리협약 - 제 9조\n\n'부모와 떨어져 지내지않을 권리'\n\n아동은 부모와 떨어져 지내지 않을 권리가 있습니다.\n\n어쩔 수 없이 헤어져 살아야 하는 경우에는\n\n정기적으로 부모와 만날 수 있어야 합니다")
            }else if(easy_count==2){
                score++
                yes_body.setText("보통 재범률은 25%으로 알려져 있는 것에 비해,\n\n세움에서 지원해 온 수용자들의 재범률은\n\n5.7%에 불과했습니다.이로써,수용자 자녀 지원이\n\n단순히 자녀 본인뿐 아니라 가족 전체에 영향을\n\n미친다는 것을 알 수 있습니다.")
            }else if(easy_count==3){
                score++
                yes_body.setText("법률에서는 남성 수용자의 자녀 양육은\n\n허락하지 않고 있으며, 출산이 아닌\n\n수감 전 양육을 하던 자녀를 위한 교정시설 내\n\n양육에 대해서는 법률적 지원 및 근거가\n\n존재하지 않습니다.")
            }else if(easy_count==4){
                score++
                yes_body.setText("유럽연합에서는 매년6월\n\n'Not my crime, Still my sentence!'라는\n\n캐치프레이즈를 가지고 수용자 자녀에 대한 관심을\n\n촉구하고 있습니다. 모든 아동은 유엔아동권리협약의\n\n무차별원칙에 의해서 살아갈 권리가 있습니다.")
            }else if(easy_count==5) {
                score++
                yes_body.setText("한정애 국회의원은 수용자 자녀 인권 관련 문제점을\n\n전반적으로 점검해 ‘수용자 자녀 보호3법’을\n\n마련했습니다. 하지만, 자녀의 법정 대리인 동의와\n\n관련된 내용은 담겨있지 않아 수용자 자녀의\n\n이러한 어려움은 여전히 지속되고 있습니다.")
            }
        }

        dialog4.show() // 팝업창 보이기
        val next = dialog4.findViewById<ImageView>(R.id.next)
        next.setOnClickListener {
            dialog4.dismiss()
            if(easy_count >=5){
                showDialog5(requireContext(),dialog1)
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

        if(dialog1.findViewById<TextView>(R.id.difficulty).text=="easy") {
            if (easy_count == 1) {
                no_body.setText("2017년 국가인권위원회의 실태조사결과\n\n수용자 자녀는 연간 약 5만 4천명입니다.\n\n또한 2021년 전국 교정시설 수용자 전수조사 결과\n\n1만 2천명으로 나타났습니다.")
            } else if (easy_count == 2) {
                no_body.setText("심리정서 상담, 성장지원비, 멘토링 활동,\n\n당사자 청년 자문단, 면회 지원 등\n\n수용자 자녀가 당당하게 서기 위해\n\n세움에서 많은 지원을 하고 있습니다.")
            } else if (easy_count == 3) {
                no_body.setText("일반 수용자는 재복역률이 3년 안에 25%입니다.\n\n반면, 세움에서 수용자 자녀를 지원했을 때, 부모가\n\n다시 복역하는 비율은 5.7%에 머물렀습니다.")
            } else if (easy_count == 4) {
                no_body.setText("수용자 자녀 부모와의 격리로\n\n경제적 고통뿐만 아니라\n\n사회적 편견과 낙인으로 인한 \n\n심리적/정서적 고통도 크다.")
            } else if (easy_count == 5) {
                no_body.setText("우리나라 헌법 제13조 3항은 \n\n연좌제를 금하고 있습니다.\n\n그러므로 ‘범죄자의 자녀’로 낙인찍어\n\n고통을 받게 해서는 안 됩니다.")
            }
        }
        if(dialog1.findViewById<TextView>(R.id.difficulty).text=="noraml"){
            if(easy_count==1){
                no_body.setText("국내 유일의 수용자자녀 전문지원기관 “세움”은\n\n수용자의 자녀와 가족을 세상의 중심에\n\n세우고 함께 걸아가기 위해 설립되었습니다.")
            }else if(easy_count==2){
                no_body.setText("법무부의 2021년 조사 결과, 미성년 자녀가 있는\n\n수용자 중 양육비를 지원에 의지하는 수용자는\n\n444명(5.7%)으로 밝혀졌습니다. 입소 전 \n\n기초생활 수급 등 국가지원 대상자가 1,649명으로\n\n지원을 받지 못한다는 것을 알 수 있습니다.")
            }else if(easy_count==3){
                no_body.setText("유엔 아동권리협약 - 제2조 차별금지\n\n아동은 차별받지 않을 권리가 있습니다.\n\n부모의 상황이나 사회적 신분 등에 상관없이\n\n모든 아동은 동등한 권리를 누려야 합니다.")
            }else if(easy_count==4){
                no_body.setText("이외에도 부모가 수용된 후에도\n\n안정적인 집에서 건강한 어른의 보살핌을 받고\n\n보호받을 권리,부모가 수용된 후에도\n\n신체적으로 건강하게 심리적으로\n\n보호받을 수 있는 권리등이 존재합니다.")
            }else if(easy_count==5) {
                no_body.setText("형사절차가 진행되는 동안 자녀를\n\n보호하기 위해서는 아동보호환경 마련하기,\n\n부모를 만날 권리 지키기,수용자 자녀 전문\n\n지원기관의 도움 받기등이 필요합니다.  ")
            }
        }
        if(dialog1.findViewById<TextView>(R.id.difficulty).text=="hard"){
            if(easy_count==1){
                no_body.setText("유엔아동권리협약 - 제 9조\n\n'부모와 떨어져 지내지않을 권리'\n\n아동은 부모와 떨어져 지내지 않을 권리가 있습니다.\n\n어쩔 수 없이 헤어져 살아야 하는 경우에는\n\n정기적으로 부모와 만날 수 있어야 합니다")
            }else if(easy_count==2){
                no_body.setText("보통 재범률은 25%으로 알려져 있는 것에 비해,\n\n세움에서 지원해 온 수용자들의 재범률은\n\n5.7%에 불과했습니다.이로써,수용자 자녀 지원이\n\n단순히 자녀 본인뿐 아니라 가족 전체에 영향을\n\n미친다는 것을 알 수 있습니다.")
            }else if(easy_count==3){
                no_body.setText("법률에서는 남성 수용자의 자녀 양육은\n\n허락하지 않고 있으며, 출산이 아닌\n\n수감 전 양육을 하던 자녀를 위한 교정시설 내\n\n양육에 대해서는 법률적 지원 및 근거가\n\n존재하지 않습니다.")
            }else if(easy_count==4){
                no_body.setText("유럽연합에서는 매년6월\n\n'Not my crime, Still my sentence!'라는\n\n캐치프레이즈를 가지고 수용자 자녀에 대한 관심을\n\n촉구하고 있습니다. 모든 아동은 유엔아동권리협약의\n\n무차별원칙에 의해서 살아갈 권리가 있습니다.")
            }else if(easy_count==5) {
                no_body.setText("한정애 국회의원은 수용자 자녀 인권 관련 문제점을\n\n전반적으로 점검해 ‘수용자 자녀 보호3법’을\n\n마련했습니다. 하지만, 자녀의 법정 대리인 동의와\n\n관련된 내용은 담겨있지 않아 수용자 자녀의\n\n이러한 어려움은 여전히 지속되고 있습니다.")
            }
        }

        dialog6.show() // 팝업창 보이기
        val next = dialog6.findViewById<ImageView>(R.id.next)
        next.setOnClickListener {
            dialog6.dismiss()
            if(easy_count >=5){
                showDialog5(requireContext(),dialog1)
                dialog1.dismiss()
            }
        }
    }
    fun showDialog5(context: Context,dialog: Dialog) {
        val dialog5 = Dialog(context)
        dialog5.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog5.setContentView(R.layout.fragment_home_quiz_end_easy)
        val end_btn = dialog5.findViewById<ImageView>(R.id.end_btn)
        val score_text = dialog5.findViewById<TextView>(R.id.score)
        val easy_word = dialog5.findViewById<TextView>(R.id.easy_word)

        dialog5.window?.let {
            it.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        dialog5.setCanceledOnTouchOutside(false) // 외부 여백 클릭 시 Dialog 닫히지 않도록 설정
        score_text.setText("$score / 5") //!!!!!!!!!!!!!!!!!!!!!11
        if(dialog.findViewById<TextView>(R.id.difficulty).text=="noraml"){
            easy_word.setText("NORM")
        } else if (dialog.findViewById<TextView>(R.id.difficulty).text=="hard"){
            easy_word.setText("HARD")
        }
        dialog5.show()

        end_btn.setOnClickListener {
            dialog5.dismiss()
            easy_count=0
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
        val quiz_num = dialog1.findViewById<TextView>(R.id.quiz_num)
        val whitecorrect = dialog1.findViewById<ImageView>(R.id.whitecorrect)
        val whitewrong = dialog1.findViewById<ImageView>(R.id.whitewrong)
        val checkans_easy = dialog1.findViewById<ImageView>(R.id.checkans_easy)
        val drawable1 = ContextCompat.getDrawable(context, R.drawable.home_quiz_bluecorrect)
        val drawable2 = ContextCompat.getDrawable(context, R.drawable.home_quiz_redwrong)
        val drawable3 = ContextCompat.getDrawable(context, R.drawable.home_quiz_correct_btn)
        val drawable4 = ContextCompat.getDrawable(context, R.drawable.home_quiz_wrong_btn)

        val backbtn = dialog1.findViewById<ImageView>(R.id.backbtn)
        val outbtn = dialog1.findViewById<ImageView>(R.id.outbtn)

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
                            quiz_num.setText("Q.2")
                            easy_body.setText("수용자 자녀가 건강하게 성장할 수\n\n있도록 세움에서\n\n정기적으로 지원한다")
                        } else if (easy_count == 2) {
                            showDialog6(requireContext(), easy_count, dialog1) //맞은거
                            line2.visibility = View.INVISIBLE
                            line3.visibility = View.VISIBLE
                            count = 0
                            quiz_num.setText("Q.3")
                            easy_body.setText("세움에서 정기적으로\n\n지원한 수용자의 재복역율은 \n\n5.7%이다")
                            Log.e("HelpFragment", "Quiz3")
                        } else if (easy_count == 3) {
                            showDialog4(requireContext(), easy_count, dialog1) //틀린거
                            line3.visibility = View.INVISIBLE
                            line4.visibility = View.VISIBLE
                            count = 0
                            quiz_num.setText("Q.4")
                            easy_body.setText("수용자 자녀는\n\n경제적 고통뿐만 아니라\n\n심리적 정서적 고통도 함께 겪고 있는\n\n‘숨겨진 피해자’이다.")
                            Log.e("HelpFragment", "Quiz4")
                        } else if (easy_count == 4) {
                            showDialog4(requireContext(), easy_count, dialog1) //맞은거
                            line4.visibility = View.INVISIBLE
                            line5.visibility = View.VISIBLE
                            count = 0
                            quiz_num.setText("Q.5")
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
                        quiz_num.setText("Q.2")
                        easy_body.setText("미성년자 수용자 자녀는 핸드폰 개통, \n\n여권 발급, 개인정보 열람 등을\n\n만들기 힘듭니다.\n\n그 이유는 무엇일까요?")
                        count = 0
                    } else if (easy_count == 2) {
                        showDialog4(requireContext(), easy_count, dialog1) //틀린거
                        line2.visibility = View.INVISIBLE
                        line3.visibility = View.VISIBLE
                        quiz_num.setText("Q.3")
                        easy_body.setText("수용자 자녀를 지원하는\n\n해외 민간 단체가 \n\n아닌 것은 무엇인가요?")
                        count = 0
                        Log.e("HelpFragment", "Quiz3")
                    } else if (easy_count == 3) {
                        showDialog6(requireContext(), easy_count, dialog1) //맞는거
                        line3.visibility = View.INVISIBLE
                        line4.visibility = View.VISIBLE
                        quiz_num.setText("Q.4")
                        easy_body.setText("우리나라에서 법률과 관련된 내용으로\n\n옳은 것은 무엇일까요?")
                        count = 0
                        Log.e("HelpFragment", "Quiz4")
                    } else if (easy_count == 4){
                        showDialog6(requireContext(), easy_count, dialog1) //틀린거
                        line4.visibility = View.INVISIBLE
                        line5.visibility = View.VISIBLE
                        quiz_num.setText("Q.5")
                        easy_body.setText("교정본부가 하는 일로 \n\n옳지 않은 내용은 무엇일까요?")
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
        backbtn.setOnClickListener {
            dialog1.dismiss()
            easy_count=0
        }
        outbtn.setOnClickListener {
            dialog1.dismiss()
            easy_count=0
        }
    }
    var easy_count=1
    fun showDialog2(context: Context) {
        easy_count=1
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
        val line1 = dialog2.findViewById<ImageView>(R.id.line1)
        val line2 = dialog2.findViewById<ImageView>(R.id.line2)
        val line3 = dialog2.findViewById<ImageView>(R.id.line3)
        val line4 = dialog2.findViewById<ImageView>(R.id.line4)
        val line5 = dialog2.findViewById<ImageView>(R.id.line5)
        val line6 = dialog2.findViewById<ImageView>(R.id.line6)
        val quiz_num = dialog2.findViewById<TextView>(R.id.quiz_num)
        val normal_body = dialog2.findViewById<TextView>(R.id.normal_body)

        dialog2.show() // 팝업창 보이기
        val first_option = dialog2.findViewById<TextView>(R.id.first_option)
        val second_option = dialog2.findViewById<TextView>(R.id.second_option)
        val third_option = dialog2.findViewById<TextView>(R.id.third_option)
        val fourth_option = dialog2.findViewById<TextView>(R.id.fourth_option)
        val checkans = dialog2.findViewById<ImageView>(R.id.checkans_normal)

        val outbtn = dialog2.findViewById<ImageView>(R.id.outbtn)
        val backbtn = dialog2.findViewById<ImageView>(R.id.backbtn)

        fun reset(){
            first_option.setBackgroundResource(R.drawable.home_quiz_round)
            second_option.setBackgroundResource(R.drawable.home_quiz_round)
            third_option.setBackgroundResource(R.drawable.home_quiz_round)
            fourth_option.setBackgroundResource(R.drawable.home_quiz_round)
        }
        fun count(){
            if (easy_count == 2) {
                line1.visibility = View.INVISIBLE
                line2.visibility = View.VISIBLE
                quiz_num.setText("Q.2")
                normal_body.setText("미성년 자녀가 있는 수용자 중,양육비를 \n\n국가 지원에 의지하는 수용자 비율은? ")
                checkans.visibility = View.GONE
                first_option.setText("5.7%")
                second_option.setText("10.2%")
                third_option.setText("30.4%")
                fourth_option.setText("70.8%")
            } else if (easy_count == 3) {
                line2.visibility = View.INVISIBLE
                line3.visibility = View.VISIBLE
                quiz_num.setText("Q.3")
                normal_body.setText("유엔 아동 권리 협약\n\n제2조의 내용으로 옳은 것은?")
                checkans.visibility = View.GONE
                first_option.setText("아동은 차별받지 않을 권리가 있다")
                second_option.setText("아동은 부모 잘못을 책임져야 할 의무가 있다")
                third_option.setText("범법행위를 한 부모는 자녀를 만날 수 없다")
                fourth_option.setText("아동은 수용자 부모와 만나지 않을 의무가 있다")
            } else if (easy_count == 4) {
                line3.visibility = View.INVISIBLE
                line4.visibility = View.VISIBLE
                quiz_num.setText("Q.4")
                normal_body.setText("세움에서 만든 한국의 수용자 자녀 8대\n\n권리에 대해서 옳지 않은 것은?")
                checkans.visibility = View.GONE
                first_option.setText("부모의 수용사실로 인해 사회적 비난 받거나\n차별 받지 않고 살아갈 권리")
                second_option.setText("부모 수용으로 인해 경제/심리/사회적인\n어려움일 경우 도움을 받을 수 있는 권리")
                third_option.setText("부모 수용으로 인해 지원을 받을 때 정보가\n노출되지 않도록 보호받을 권리")
                fourth_option.setText("부모 범죄 사실에 대해\n정서/사회적 책임을 다할 권리")
            } else if (easy_count == 5) {
                line4.visibility = View.INVISIBLE
                line5.visibility = View.VISIBLE
                quiz_num.setText("Q.5")
                normal_body.setText("형사절차가 진행되는 동안 자녀를 보호하기 위해\n\n필요한 것으로 적절하지 않은 것은?")
                checkans.visibility = View.GONE
                first_option.setText("아동보호환경 마련하기")
                second_option.setText("임의로 주변인물에게 수용 사실에 대해 알리기")
                third_option.setText("부모를 만날 권리 지키기")
                fourth_option.setText("수용자 자녀 전문 지원 기관 도움 받기")
            }
            reset()
        }

        first_option.setOnClickListener {
                if(count==1){
                    reset()
                    count=0
                }
                count=1
                first_option.setBackgroundResource(R.drawable.home_quiz_round_yello)
                checkans.visibility = View.VISIBLE
                checkans.setOnClickListener {
                    if (easy_count == 1) {
                        showDialog4(requireContext(), easy_count, dialog2)
                    } else if (easy_count == 2) {
                        showDialog4(requireContext(), easy_count, dialog2)
                    } else if (easy_count == 3) {
                        showDialog4(requireContext(), easy_count, dialog2)
                    } else {
                        showDialog6(requireContext(), easy_count, dialog2)
                    }
                    easy_count++
                    count()
                }
        }
        second_option.setOnClickListener {
            if(count==1){
                reset()
                count=0
            }
                count = 1
                second_option.setBackgroundResource(R.drawable.home_quiz_round_yello)
                checkans.visibility = View.VISIBLE
                checkans.setOnClickListener {
                    if (easy_count == 5) {
                        showDialog4(requireContext(), easy_count, dialog2)
                    } else {
                        showDialog6(requireContext(), easy_count, dialog2)
                    }
                    easy_count++
                    count()
                }
        }
        third_option.setOnClickListener {
            if(count==1){
                reset()
                count=0
            }
                count = 1
                third_option.setBackgroundResource(R.drawable.home_quiz_round_yello)
                checkans.visibility = View.VISIBLE
                checkans.setOnClickListener {
                        showDialog6(requireContext(), easy_count, dialog2)
                    easy_count++
                    count()
                }
        }
        fourth_option.setOnClickListener {
            if(count==1){
                reset()
                count=0
            }
                count = 1
                fourth_option.setBackgroundResource(R.drawable.home_quiz_round_yello)
                checkans.visibility = View.VISIBLE
                checkans.setOnClickListener {
                    if (easy_count == 4) {
                        showDialog4(requireContext(), easy_count, dialog2)
                    } else {
                        showDialog6(requireContext(), easy_count, dialog2)
                    }
                    easy_count++
                    count()
                }
        }
        backbtn.setOnClickListener {
            dialog2.dismiss()
            easy_count=0
        }
        outbtn.setOnClickListener {
            dialog2.dismiss()
            easy_count=0
        }
    }

    fun showDialog3(context: Context) {
        easy_count=1
        score = 0
        var count = 0
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
        val line1 = dialog3.findViewById<ImageView>(R.id.line1)
        val line2 = dialog3.findViewById<ImageView>(R.id.line2)
        val line3 = dialog3.findViewById<ImageView>(R.id.line3)
        val line4 = dialog3.findViewById<ImageView>(R.id.line4)
        val line5 = dialog3.findViewById<ImageView>(R.id.line5)
        val line6 = dialog3.findViewById<ImageView>(R.id.line6)
        val quiz_num = dialog3.findViewById<TextView>(R.id.quiz_num)
        val hard_body = dialog3.findViewById<TextView>(R.id.hard_body)
        val backbtn = dialog3.findViewById<ImageView>(R.id.backbtn)
        val outbtn = dialog3.findViewById<ImageView>(R.id.outbtn)

        dialog3.show() // 팝업창 보이기
        val first_option = dialog3.findViewById<TextView>(R.id.first_option)
        val second_option = dialog3.findViewById<TextView>(R.id.second_option)
        val third_option = dialog3.findViewById<TextView>(R.id.third_option)
        val fourth_option = dialog3.findViewById<TextView>(R.id.fourth_option)
        val checkans = dialog3.findViewById<ImageView>(R.id.checkans_hard)

        fun reset(){
            first_option.setBackgroundResource(R.drawable.home_quiz_round)
            second_option.setBackgroundResource(R.drawable.home_quiz_round)
            third_option.setBackgroundResource(R.drawable.home_quiz_round)
            fourth_option.setBackgroundResource(R.drawable.home_quiz_round)
        }
        fun count(){
            if (easy_count == 2) {
                line1.visibility = View.INVISIBLE
                line2.visibility = View.VISIBLE
                quiz_num.setText("Q.2")
                hard_body.setText("보통 국내 재범률은 25% 남짓으로\n\n알려져 있습니다. 그렇다면 세움에서 지원해 온\n\n수용자들의 재범률은 약 몇 퍼센트 일까요? ")
                checkans.visibility = View.INVISIBLE
                first_option.setText("5.7%")
                second_option.setText("20.5%")
                third_option.setText("53.6%")
                fourth_option.setText("77.4%")
            } else if (easy_count == 3) {
                line2.visibility = View.INVISIBLE
                line3.visibility = View.VISIBLE
                quiz_num.setText("Q.3")
                hard_body.setText("형의 집행 및 수용자 처우에 관한\n\n법률개정(2019.4.5)의 내용으로\n\n적절하지 않은 것은?")
                checkans.visibility = View.INVISIBLE
                first_option.setText("소장은 신입자에게 아동복지법에 따른\n보호조치를 의뢰할 수 있음을 알려주어야 한다.")
                second_option.setText("수용자가 미성년 자녀를 면회할 경우,\n접촉차단 시설이 설치되지 아니한 장소에서\n접견하게 할 수 있다. ")
                third_option.setText("수용자가 임신 중이거나 출산 한 경우에는\n모성보호 및 건강유지를 위하여 적절한 조치를 취한다.")
                fourth_option.setText("여성과 남성 수용자 모두 교도소 내\n생후 18개월까지의 자녀 양육을 허락한다.")
            } else if (easy_count == 4) {
                line3.visibility = View.INVISIBLE
                line4.visibility = View.VISIBLE
                quiz_num.setText("Q.4")
                hard_body.setText("유럽연합(EU)에서 수용자 자녀에 대한\n\n관심을 촉구하기 위해 만든\n\n캐치 프레이즈로 적절한 것은?")
                checkans.visibility = View.INVISIBLE
                first_option.setText("Stand up and go forward")
                second_option.setText("Yes, One more time")
                third_option.setText("Fly high!")
                fourth_option.setText("Not my crime, Still my sentence!")
            } else if (easy_count == 5) {
                line4.visibility = View.INVISIBLE
                line5.visibility = View.VISIBLE
                quiz_num.setText("Q.5")
                hard_body.setText("유엔 아동권리위원회는 대한민국 정부에\n\n수용자자녀의 권리보장을 권고했습니다.\n\n이에 발의된 ‘수용자 자녀 보호3법’으로\n\n적절하지 않은 것은 무엇일까요?")
                checkans.visibility = View.INVISIBLE
                first_option.setText("구속 시 자녀 유무와 보호대상아동 여부를 확인하고,\n복지서비스를 제공받을 수 있는 법적 근거를 마련한다.")
                second_option.setText("수용자가 자녀를 접견할 때에는 차단 시설이 없는 장소에서\n자유로운 접견이 가능하도록 한다.")
                third_option.setText("수용자 자녀에 대한 지원·인권 보호에 대한 규정을\n마련하고, 교정시설 최초 입소 과정에서 자녀 양육환경을\n조사하고 결과를 통보하도록 한다.")
                fourth_option.setText("수용자 자녀가 법정 대리인의 동의가 필요한 경우,\n지원 기관 등이 대리할 수 있는 적절한 시스템을 마련한다.")
            }
            reset()
        }

        first_option.setOnClickListener {
            if(count==1){
                reset()
                count=0
            }
            count=1
            first_option.setBackgroundResource(R.drawable.home_quiz_round_yello)
            checkans.visibility = View.VISIBLE
            checkans.setOnClickListener {
                if (easy_count == 1) {
                    showDialog4(requireContext(), easy_count, dialog3)
                } else if (easy_count == 2) {
                    showDialog4(requireContext(), easy_count, dialog3)
                } else {
                    showDialog6(requireContext(), easy_count, dialog3)
                }
                easy_count++
                count()
            }
        }
        second_option.setOnClickListener {
            if(count==1){
                reset()
                count=0
            }
            count = 1
            second_option.setBackgroundResource(R.drawable.home_quiz_round_yello)
            checkans.visibility = View.VISIBLE
            checkans.setOnClickListener {
                    showDialog6(requireContext(), easy_count, dialog3)
                easy_count++
                count()
            }
        }
        third_option.setOnClickListener {
            if(count==1){
                reset()
                count=0
            }
            count = 1
            third_option.setBackgroundResource(R.drawable.home_quiz_round_yello)
            checkans.visibility = View.VISIBLE
            checkans.setOnClickListener {
                    showDialog6(requireContext(), easy_count, dialog3)
                easy_count++
                count()
            }
        }
        fourth_option.setOnClickListener {
            if(count==1){
                reset()
                count=0
            }
            count = 1
            fourth_option.setBackgroundResource(R.drawable.home_quiz_round_yello)
            checkans.visibility = View.VISIBLE
            checkans.setOnClickListener {
                if (easy_count == 3) {
                    showDialog4(requireContext(), easy_count, dialog3)
                } else if (easy_count == 4) {
                showDialog4(requireContext(), easy_count, dialog3)
                } else if (easy_count == 5) {
                    showDialog4(requireContext(), easy_count, dialog3)
                } else {
                    showDialog6(requireContext(), easy_count, dialog3)
                }
                easy_count++
                count()
            }
        }
        backbtn.setOnClickListener {
            dialog3.dismiss()
            easy_count=0
        }
        outbtn.setOnClickListener {
            dialog3.dismiss()
            easy_count=0
        }
    }
}