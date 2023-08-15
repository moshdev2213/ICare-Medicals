package com.example.myapplication.FromData

import com.example.myapplication.Validations.ValidationResult

class UserLoginForm(
    private var email:String,
    private var password:String

) {
    fun validatePassword():ValidationResult{
        //the regex expression
        val passwordPattern = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$"

        return if(password.isEmpty()){
            ValidationResult.Empty("Enter Password")
        }else if(!password.matches(passwordPattern.toRegex())){
            ValidationResult.Invalid("Invalid ex:Aa@asda22")
        }else{
            ValidationResult.Valid
        }

    }

    fun validateEmail():ValidationResult{

        //the regex pattern
        val regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"

        return if(email.isEmpty()){
            ValidationResult.Empty("Enter Email")
        }else if(!email.matches(regex.toRegex())){
            ValidationResult.Invalid("Enter Valid Email")
        }else{
            ValidationResult.Valid
        }
    }
}