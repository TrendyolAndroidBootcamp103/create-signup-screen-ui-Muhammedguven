package school.cactus.succulentshop
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private val passwordVerifyValidator = PasswordVerifyValidator()
    private val emailValidator = EmailValidator()
    private val usernameValidator = UsernameValidator()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.sign_up)

        binding.apply {
            signupButton.setOnClickListener {
                passwordInputLayout.validate()
                emailInputLayout.validate()
                usernameInputLayout.validate()
            }
        }
        binding.alreadyHaveAnAccountButton.setOnClickListener{
            navigateToLoginActivity()
        }
    }
    private fun navigateToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
    private fun TextInputLayout.validate() {
        val errorMessage = validator().validate(editText!!.text.toString())
        error = errorMessage?.resolveAsString()
        isErrorEnabled = errorMessage != null
    }
    private fun Int.resolveAsString() = getString(this)

    private fun TextInputLayout.validator() = when (this) {
        binding.passwordInputLayout -> passwordVerifyValidator
        binding.emailInputLayout -> emailValidator
        binding.usernameInputLayout -> usernameValidator
        else -> throw IllegalArgumentException("Cannot find any validator for the given TextInputLayout")
    }
}