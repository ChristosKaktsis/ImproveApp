package com.example.improve

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.improve.data.DataSource
import com.example.improve.databinding.FragmentCalculateE1rmBinding
import com.example.improve.databinding.FragmentCalculateWwBinding


class CalculateWWFragment : Fragment() {
    private  var _binding: FragmentCalculateWwBinding? = null
    private val binding get() = _binding!!

    private var selected_reps : Int = 0
    private var selected_rpe : Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculateWwBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rpe_array = resources.getStringArray(R.array.rpe_array)
        val reps_array = resources.getStringArray(R.array.reps_array)

        val rpeDialog: AlertDialog? = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(R.string.choose_rpe)
                .setItems(R.array.rpe_array,
                    DialogInterface.OnClickListener { dialog, which ->
                        // The 'which' argument contains the index position
                        // of the selected item
                        binding.rpeBtn.text = rpe_array[which].toString()
                        selected_rpe = rpe_array[which].toDouble()
                    })
            builder.create()
        }
        val repsDialog: AlertDialog? = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(R.string.choose_reps)
                .setItems(R.array.reps_array,
                    DialogInterface.OnClickListener { dialog, which ->
                        // The 'which' argument contains the index position
                        // of the selected item
                        binding.repsBtn.text = reps_array[which].toString()
                        selected_reps = reps_array[which].toInt()
                    })
            builder.create()
        }

        binding.rpeBtn.setOnClickListener { rpeDialog?.show() }
        binding.repsBtn.setOnClickListener { repsDialog?.show() }
        binding.calculateWwBtn.setOnClickListener { calculateWW() }
    }
    fun calculateWW(){
        //get rpe value
        var rpeValue: Double? = DataSource.getRpeValue(selected_rpe,selected_reps) ?: return
        //get weight
        var weight: Double? = binding.maxEdit.text.toString().toDoubleOrNull() ?: return
        //calculate e1rm
        var result = weight?.times(rpeValue!!)
        //format to 2 digit
        var formatted = String.format("%.2f",result)
        //show result
        binding.wwTextView.text = getString(R.string.calculated_weight, formatted)
        //show percent
        var format = String.format("%.2f",rpeValue?.times(100))
        var percent = format + "%"
        binding.percentTextView.text = getString(R.string.percent_1rm, percent)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}