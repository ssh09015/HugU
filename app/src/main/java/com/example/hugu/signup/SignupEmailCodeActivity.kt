package com.example.hugu.signup
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hugu.databinding.ActivitySignupEmailCodeBinding

class SignupEmailCodeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySignupEmailCodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivitySignupEmailCodeBinding.inflate(layoutInflater)


        viewBinding.signupOkBtn.setOnClickListener {
            val intent = Intent(this, SignupNicknameActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0)
        }

        setContentView(viewBinding.root)
    }
}