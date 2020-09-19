package com.rayray.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import com.rayray.madlevel1task2.databinding.ActivityMainBinding

/**
 * @author Raymond Chang
 *
 * Made this class for MadLevel1Task2 assignment.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            checkAnswer()
        }
    }

    private fun checkAnswer(){
        val etList = listOf(binding.etCase1.text, binding.etCase2.text,
            binding.etCase3.text, binding.etCase4.text)
        val answers = listOf("T", "F", "F", "F")

        if (checkIfAnswersAreEmpty(etList))
            Toast.makeText(applicationContext, "Niet alle velden zijn ingevuld!",
                Toast.LENGTH_LONG).show()
        else
            Toast.makeText(applicationContext, "Aantal correcte antwoorden: " + checkAnswersFromList(etList, answers).toString() + "/4",
                Toast.LENGTH_LONG).show()
    }

    /**
     * @param etList a list with answers from user
     * @param answers a list with correct answers
     *
     * This method checks if answers are correct or not. At every correct answer, it will add 1
     * to the count variable.
     *
     * In this for loop, we use the index number of etList. This index variable will be used to not only
     * get an item from etList, but also from answers list. This way, we compare these value.
     * If these value are the same, then we will increment count variable by 1.
     */
    private fun checkAnswersFromList(etList: List<Editable>, answers: List<String>) : Int {
        var count = 0;

        for(index in etList.indices){
            Log.d("TAG", "answer ${etList[index]} :  ${answers[index]}")

            if (etList[index].toString().equals(answers[index]))
                count += 1
        }
        return count
    }

    /**
     * @param etList a list with answers from user
     *
     * Checks if fields are not empty
     */
    private fun checkIfAnswersAreEmpty(etList: List<Editable>): Boolean {
        for (answer in etList)
            if (answer.isEmpty())
                return true

        return false
    }

}