package ai.mealz.mealzonboardingproviderxml.ui.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ai.mealz.mealzonboardingproviderxml.databinding.FragmentBasketBinding

/**
 * TODO (Step 5): Show My Basket
 * A. Update Basket XML to use Mealz Component
 * B. Update BasketFragment to show MyBasket
 * C. Recipe Details "See my basket" navigates to MyBasket
 * https://miamtech.github.io/mealz-documentation/docs/android/features/MyBasket/Overview
 */

class BasketFragment : Fragment() {

    private var _binding: FragmentBasketBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val basketViewModel =
            ViewModelProvider(this).get(BasketViewModel::class.java)

        _binding = FragmentBasketBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textBasket
        basketViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}