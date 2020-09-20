package com.example.suvodeep.reach


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.volunteer_registration.*

class MainActivity : AppCompatActivity() {

    lateinit var handler : Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = Database(this)


        showHome()

        volunteer_registration.setOnClickListener {
            showRegistration()
        }

        login.setOnClickListener {
            showLogin()
        }

        save.setOnClickListener {
            handler.insertUserData(name.text.toString(),email.text.toString(),password_register.text.toString())

            showLogin()
        }

        /* login_button.setOnClickListener{
             if (handler.userPresent(login_email.text.toString(),login_password.text.toString()))
             {
                 Toast.makeText(this, "Logged in Successfully", Toast.LENGTH_SHORT).show()
             }
             else
                Toast.makeText(this, "Login Fail" , Toast.LENGTH_SHORT).show()
         }*/
        login_button.setOnClickListener{
            var status=if(login_email.text.toString().equals("suvodeep@gmail.com")&&login_password.text.toString().equals("suvodeep")) "Logged In Successfully " else "Login Fail"
            Toast.makeText(this,status,Toast.LENGTH_SHORT).show()


        }



    }
    private fun showRegistration() {

        registration_layout.visibility=View.VISIBLE
        login_layout.visibility= View.GONE
        home.visibility=View.GONE

    }

    private fun showLogin(){
        registration_layout.visibility=View.GONE
        login_layout.visibility= View.VISIBLE
        home.visibility=View.GONE

    }
    private fun showHome(){
        registration_layout.visibility=View.GONE
        login_layout.visibility= View.GONE
        home.visibility=View.VISIBLE

    }

}
