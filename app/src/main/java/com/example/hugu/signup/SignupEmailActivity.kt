package com.example.hugu.signup
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hugu.databinding.ActivitySignupEmailBinding

class SignupEmailActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySignupEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivitySignupEmailBinding.inflate(layoutInflater)


        viewBinding.signupOkBtn.setOnClickListener {
            val intent = Intent(this, SignupEmailCodeActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(0, 0)
        }

        setContentView(viewBinding.root)
    }
}