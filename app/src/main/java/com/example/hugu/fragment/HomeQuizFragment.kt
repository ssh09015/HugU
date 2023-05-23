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
                yes_body.setText("‘세움’은 수용자 자녀와 가족을 \n\n세상의 중심에 세우고 함께 걸어가기 위해\n\n2015년 설립된 아동복지 전문단체입니다.")
            }else if(easy_count==2){
                score++
                yes_body.setText("2")
            }else if(easy_count==3){
                score++
                yes_body.setText("3")
            }else if(easy_count==4){
                score++
                yes_body.setText("4")
            }else if(easy_count==5) {
                score++
                yes_body.setText("5")
            }
        }

        dialog4.show() // 팝업창 보이기
        val next = dialog4.findViewById<ImageView>(R.id.next)
        next.setOnClickListener {
            dialog4.dismiss()
            if(easy_count >=5){
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
                no_body.setText("‘세움’은 수용자 자녀와 가족을 \n\n세상의 중심에 세우고 함께 걸어가기 위해\n\n2015년 설립된 아동복지 전문단체입니다.")
            }else if(easy_count==2){
                no_body.setText("2")
            }else if(easy_count==3){
                no_body.setText("3")
            }else if(easy_count==4){
                no_body.setText("4")
            }else if(easy_count==5) {
                no_body.setText("5")
            }
        }

        dialog6.show() // 팝업창 보이기
        val next = dialog6.findViewById<ImageView>(R.id.next)
        next.setOnClickListener {
            dialog6.dismiss()
            if(easy_count >=5){
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
        val quiz_num = dialog1.findViewById<TextView>(R.id.quiz_num)
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
                        quiz_num.setText("수용자 자녀를 지원하는\n\n해외 민간 단체가 \n\n아닌 것은 무엇인가요?")
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
    }
    var easy_count=1
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
                normal_body.setText("미성년자 수용자 자녀는 핸드폰 개통, 여권\n\n발급, 개인정보 열람 등을 만들기 힘듭니다.\n\n그 이유는 무엇일까요?")
                checkans.visibility = View.GONE
                first_option.setText("피해자들이 반대운동을 하기 때문")
                second_option.setText("편견으로 인해 발급기관에서 거부하기 때문")
                third_option.setText("신용 문제로 인해 법으로 금지하고 있기 때문")
                fourth_option.setText("법정대리인 동반이 있어야 본인 확인이 가능하기 때문")
            } else if (easy_count == 3) {
                line2.visibility = View.INVISIBLE
                line3.visibility = View.VISIBLE
                quiz_num.setText("Q.3")
                normal_body.setText("우리나라에서 수용자 자녀에 관한 법률과 \n\n관련된 내용으로 \n\n옳은 것은 무엇일까요?")
                checkans.visibility = View.GONE
                first_option.setText("아동복지법")
                second_option.setText("형의 집행 및 수용자 처우에 관한 법")
                third_option.setText("청소년 보호법")
                fourth_option.setText("모두 다")
            } else if (easy_count == 4) {
                line3.visibility = View.INVISIBLE
                line4.visibility = View.VISIBLE
                quiz_num.setText("Q.4")
                normal_body.setText("교정본부가 하는 일로\n\n옳지 않은 내용은 무엇일까요?")
                checkans.visibility = View.GONE
                first_option.setText("판결")
                second_option.setText("형벌의 관리, 감독")
                third_option.setText("교화활동")
                fourth_option.setText("사회복귀 준비")
            } else if (easy_count == 5) {
                line4.visibility = View.INVISIBLE
                line5.visibility = View.VISIBLE
                quiz_num.setText("Q.5")
                normal_body.setText("UN 아동권리위원회의 권고 후\n\n우리 사회가 수용자 자녀를 위해\n\n변화한 것 중 아닌 것은?")
                checkans.visibility = View.GONE
                first_option.setText("아동친화적 가족 접결실을 교정시설에 설치")
                second_option.setText("수용자자녀 보호 3법을 개정발의하여 국회에서 논의 중")
                third_option.setText("수용자 자녀를 위한 관련부처 협의체 구성")
                fourth_option.setText("지방교정청 위기수용자자녀 지원팀 운영")
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
                    } else if (easy_count == 4) {
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
                    if (easy_count == 3) {
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
                    if (easy_count == 5) {
                        showDialog4(requireContext(), easy_count, dialog2)
                    } else {
                        showDialog6(requireContext(), easy_count, dialog2)
                    }
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
                    if (easy_count == 2) {
                        showDialog4(requireContext(), easy_count, dialog2)
                    } else {
                        showDialog6(requireContext(), easy_count, dialog2)
                    }
                    easy_count++
                    count()
                }
        }
    }

    fun showDialog3(context: Context) {
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
                hard_body.setText("미성년자 수용자 자녀는 핸드폰 개통, 여권\n\n발급, 개인정보 열람 등을 만들기 힘듭니다.\n\n그 이유는 무엇일까요?")
                checkans.visibility = View.INVISIBLE
                first_option.setText("피해자들이 반대운동을 하기 때문")
                second_option.setText("편견으로 인해 발급기관에서 거부하기 때문")
                third_option.setText("신용 문제로 인해 법으로 금지하고 있기 때문")
                fourth_option.setText("법정대리인 동반이 있어야 본인 확인이 가능하기 때문")
            } else if (easy_count == 3) {
                line2.visibility = View.INVISIBLE
                line3.visibility = View.VISIBLE
                quiz_num.setText("Q.3")
                hard_body.setText("우리나라에서 수용자 자녀에 관한 법률과 \n\n관련된 내용으로 \n\n옳은 것은 무엇일까요?")
                checkans.visibility = View.INVISIBLE
                first_option.setText("아동복지법")
                second_option.setText("형의 집행 및 수용자 처우에 관한 법")
                third_option.setText("청소년 보호법")
                fourth_option.setText("모두 다")
            } else if (easy_count == 4) {
                line3.visibility = View.INVISIBLE
                line4.visibility = View.VISIBLE
                quiz_num.setText("Q.4")
                hard_body.setText("교정본부가 하는 일로\n\n옳지 않은 내용은 무엇일까요?")
                checkans.visibility = View.INVISIBLE
                first_option.setText("판결")
                second_option.setText("형벌의 관리, 감독")
                third_option.setText("교화활동")
                fourth_option.setText("사회복귀 준비")
            } else if (easy_count == 5) {
                line4.visibility = View.INVISIBLE
                line5.visibility = View.VISIBLE
                quiz_num.setText("Q.5")
                hard_body.setText("UN 아동권리위원회의 권고 후\n\n우리 사회가 수용자 자녀를 위해\n\n변화한 것 중 아닌 것은?")
                checkans.visibility = View.INVISIBLE
                first_option.setText("아동친화적 가족 접결실을 교정시설에 설치")
                second_option.setText("수용자자녀 보호 3법을 개정발의하여 국회에서 논의 중")
                third_option.setText("수용자 자녀를 위한 관련부처 협의체 구성")
                fourth_option.setText("지방교정청 위기수용자자녀 지원팀 운영")
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
                } else if (easy_count == 4) {
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
                if (easy_count == 3) {
                    showDialog4(requireContext(), easy_count, dialog3)
                } else {
                    showDialog6(requireContext(), easy_count, dialog3)
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
                if (easy_count == 5) {
                    showDialog4(requireContext(), easy_count, dialog3)
                } else {
                    showDialog6(requireContext(), easy_count, dialog3)
                }
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
                if (easy_count == 2) {
                    showDialog4(requireContext(), easy_count, dialog3)
                } else {
                    showDialog6(requireContext(), easy_count, dialog3)
                }
                easy_count++
                count()
            }
        }

    }
}