package com.example.improve

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.compose.ui.res.stringArrayResource
import com.example.improve.data.DataSource
import com.example.improve.databinding.FragmentCalculateE1rmBinding
import kotlinx.coroutines.NonCancellable.cancel

class CalculateE1RMFragment : Fragment() {
    private  var _binding: FragmentCalculateE1rmBinding? = null
    private val binding get() = _binding!!

    private var selected_reps : Int = 0
    private var selected_rpe : Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCalculateE1rmBinding.inflate(inflater,container,false)
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
                        binding.rpeEdit.text = rpe_array[which].toString()
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
                        binding.repsEdit.text = reps_array[which].toString()
                        selected_reps = reps_array[which].toInt()
                    })
            builder.create()
        }

        binding.rpeEdit.setOnClickListener { rpeDialog?.show() }
        binding.repsEdit.setOnClickListener { repsDialog?.show() }
        binding.calculate1rmBtn.setOnClickListener { calculateE1RM() }

    }
    fun calculateE1RM(){
        //get rpe value
        var rpe_value: Double? = DataSource.getRpeValue(selected_rpe,selected_reps) ?: return
        //get weight
        var weight: Double? = binding.weightEdit.text.toString().toDoubleOrNull() ?: return
        //calculate e1rm
        var result = weight?.div(rpe_value!!)
        //format to 2 digit
        var formatted = String.format("%.2f",result)
        //show result
        binding.e1rmTextView.text = getString(R.string.calculated_e1rm, formatted)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}