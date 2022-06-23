package wary.bhaskar.shoppy

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources

class RegisterFragment : Fragment() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var cnfPassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_register, container, false)

        username = view.findViewById(R.id.reg_username)
        password = view.findViewById(R.id.reg_password)
        cnfPassword = view.findViewById(R.id.reg_cnf_password)

        view.findViewById<Button>(R.id.btn_login_reg).setOnClickListener {
            var navRegister = activity as FragmentNavigation
            navRegister.navigateFrag(LoginFragment(), false)
        }

        view.findViewById<Button>(R.id.btn_register_reg).setOnClickListener {
            validateEmptyForm()
        }
        return view
    }

    private fun validateEmptyForm() {
        val icon = AppCompatResources.getDrawable(requireContext(),
            R.drawable.ic_error
        )

        icon?.setBounds(0,0,icon.intrinsicWidth, icon.intrinsicHeight)
        when {
            TextUtils.isEmpty(username.text.toString().trim()) -> {
                username.setError("Please enter username", icon)
            }
            TextUtils.isEmpty(password.text.toString().trim()) -> {
                password.setError("Please enter password", icon)
            }
            TextUtils.isEmpty(cnfPassword.text.toString().trim()) -> {
                cnfPassword.setError("Please enter password again", icon)
            }

            username.text.toString().isNotEmpty() &&
                    password.text.toString().isNotEmpty() &&
                    cnfPassword.text.toString().isNotEmpty() ->
            {
                if (
                    username.text.toString().matches(Regex("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}\$"))) {
                    if (password.text.toString().length >= 5) {
                        if (password.text.toString() == cnfPassword.text.toString()) {
                            Toast.makeText(context, "Register Successfully", Toast.LENGTH_SHORT).show()
                        } else {
                            cnfPassword.setError("Password didn't match", icon)
                        }
                    } else {
                        password.setError("Please enter at least 5 characters", icon)
                    }
                }
                else {
                    username.setError("Please enter valid Email Id",icon)
                }
            }
        }
    }

}