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

class LoginFragment : Fragment() {
    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_login, container, false)

        username = view.findViewById(R.id.log_username)
        password = view.findViewById(R.id.log_password)

        view.findViewById<Button>(R.id.btn_register).setOnClickListener {
            var navRegister = activity as FragmentNavigation
            navRegister.navigateFrag(RegisterFragment(), false)
        }

        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            validateForm()
        }

        return view
    }

    private fun validateForm() {
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

            username.text.toString().isNotEmpty() &&
                    password.text.toString().isNotEmpty() ->
            {
                if (
                    username.text.toString().matches(Regex("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}\$"))) {
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                }
                else {
                    username.setError("Please enter valid Email Id",icon)
                }
            }
        }
    }

}