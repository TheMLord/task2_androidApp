package com.example.habitstracker

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import kotlin.properties.Delegates


fun generateId(): Int {
    return dataBase.getLenData() + 1
}


class AddActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val priorityList: List<Int> = listOf(1, 2, 3)
    private val NEW_SPINNER_ID = 1


    private lateinit var typeHabits: String
    private lateinit var nameHabits: String
    private lateinit var descriptionHabits: String
    private var priority by Delegates.notNull<Int>()
    private lateinit var countHabits : String
    private lateinit var frequencyHabits: String

    private lateinit var radioGroup: RadioGroup
    private lateinit var inputName: TextInputEditText
    private lateinit var inputDescription: TextInputEditText
    private lateinit var inputCount: TextInputEditText
    private lateinit var inputFrequency: TextInputEditText
    private lateinit var spinnerPriority: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_habits)
        inputName = findViewById(R.id.nameHabits)
        inputDescription = findViewById(R.id.descriptionHabits)
        inputCount = findViewById(R.id.quantityHabits)
        inputFrequency = findViewById(R.id.periodicityHabits)
//        spinnerPriority = findViewById(R.id.getPriority)
//        spinnerPriority = Spinner(this)
//        val arrSpiner = ArrayAdapter(
//            this,
//            android.R.layout.simple_spinner_item,
//            priorityList
//        )
//        arrSpiner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//
//        with(spinnerPriority) {
//            adapter = arrSpiner
//            setSelection(0, false)
//            onItemSelectedListener = this@AddActivity
//            prompt = "Выберите приоритет вашего хобби"
//        }
//        spinnerPriority.id = NEW_SPINNER_ID

//        setupListeners()
    }

    private fun isValidate(): Boolean =
        validateNameHabits() && valideDescriptionHabits() && validateCountHabits() && validateFrequencyHabits()

    fun validateNameHabits(): Boolean {
        when {
            inputName.toString().trim().isEmpty() ->
                return false
        }
        return true
    }

    fun valideDescriptionHabits(): Boolean {
        when {
            inputDescription.toString().trim().isEmpty() ->
                return false
        }
        return true
    }

    fun validateCountHabits(): Boolean {
        when {
            inputCount.toString().trim().isEmpty() ->
                return false
        }
        return true
    }

    fun validateFrequencyHabits(): Boolean {
        when {
            inputFrequency.toString().trim().isEmpty() ->
                return false
        }
        return true
    }

    private fun setupListeners() {
        inputName.addTextChangedListener(TextFieldValidation(inputName))
        inputDescription.addTextChangedListener(TextFieldValidation(inputDescription))
        inputCount.addTextChangedListener(TextFieldValidation(inputCount))
        inputFrequency.addTextChangedListener(TextFieldValidation(inputFrequency))
    }

    inner class TextFieldValidation(private val view: View) : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            when (view.id) {
                R.id.nameHabits -> {
                    validateNameHabits()
                    nameHabits = inputName.text.toString()
                }
                R.id.descriptionHabits -> {
                    valideDescriptionHabits()
                    descriptionHabits = inputDescription.text.toString()
                }
                R.id.quantityHabits -> {
                    validateCountHabits()
                    countHabits = inputFrequency.text.toString()
                }
                R.id.periodicityHabits -> {
                    validateFrequencyHabits()
                    frequencyHabits = inputDescription.text.toString()

                }
            }
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        showToast(message = "Nothing selected")
    }

    private fun showToast(
        context: Context = applicationContext,
        message: String,
        duration: Int = Toast.LENGTH_LONG
    ) {
        Toast.makeText(context, message, duration).show()
    }

    fun onClickComplete(view: View) {
        val id = generateId()
//        val habit = Habits(
//            id, nameHabits, descriptionHabits, priority,
//            typeHabits, countHabits, frequencyHabits
//        )
//        dataBase.addHabits(id, habit)
        setupListeners()
        print(id)
        print(nameHabits)
        print(descriptionHabits)
        print(countHabits)
        print(frequencyHabits)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
//    fun onCheckedChangeListener(view: View) {
//        when (view.id) {
//            R.id.typeOne -> typeHabits = "Учеба"
//            R.id.typeTwo -> typeHabits = "Развлечение"
//            R.id.typeThree -> typeHabits = "Работа"
//        }
//    }
}




