package ai.mealz.mealzonboardingproviderxml.ui.home

import ai.mealz.mealzonboardingproviderxml.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ai.mealz.mealzonboardingproviderxml.databinding.FragmentHomeBinding
import android.widget.ImageView
import com.squareup.picasso.Picasso

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Access the first included local_recipe_card and set its title
        val firstRecipeCard = root.findViewById<View>(R.id.first_recipe_card)
        val firstTitleTextView = firstRecipeCard.findViewById<TextView>(R.id.title_item)
        firstTitleTextView.text = "Chicken Parm"
        val firstImageView = firstRecipeCard.findViewById<ImageView>(R.id.image_item)
        val firstImageUrl = "https://hips.hearstapps.com/hmg-prod/images/delish-202102-airfryerchickenparm-184-ls-1612561654.jpg?crop=1xw:0.84375xh;center,top&resize=1200:*"

        // Load image with Picasso
        Picasso.get()
            .load(firstImageUrl)
            .into(firstImageView)

        // Access the second included local_recipe_card and set its title
        val secondRecipeCard = root.findViewById<View>(R.id.second_recipe_card)
        val secondTitleTextView = secondRecipeCard.findViewById<TextView>(R.id.title_item)
        secondTitleTextView.text = "Croque Monsieur"
        val secondImageView = secondRecipeCard.findViewById<ImageView>(R.id.image_item)
        val secondImageUrl = "https://assets.afcdn.com/recipe/20170112/28965_w1024h768c1cx1500cy1000.webp"

        // Load image with Picasso
        Picasso.get()
            .load(secondImageUrl)
            .into(secondImageView)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}