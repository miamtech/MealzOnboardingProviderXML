package ai.mealz.mealzonboardingproviderxml.ui.home

import ai.mealz.core.Mealz
import ai.mealz.mealzonboardingproviderxml.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ai.mealz.mealzonboardingproviderxml.databinding.FragmentHomeBinding
import ai.mealz.sdk.components.recipeDetailButton.RecipeDetailButton
import ai.mealz.sdk.components.recipePrice.RecipePrice
import android.widget.ImageView
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

/**
 * TODO (Step 3): Open Recipe Details
 * A. Add RecipeDetail Button to RecipeCard
 * B. Init to  RecipeDetail Button that passes in recipe id
 * C. Update HomeFragment to open RecipeDetails dialog when See Details button called
 * https://miamtech.github.io/mealz-documentation/docs/android/category/recipe-cards
 */

class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModels()
    private val firstRecipeId: String = "22509"
    private val secondRecipeId: String = "14472"
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    /**
     * TODO (Step 6): Get Price Button
     * A. Declare the getPrice Text view
     */
    private lateinit var buttonShowPriceRecipe1: TextView
    private lateinit var buttonShowPriceRecipe2: TextView

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

        val firstCtaGetPrice = firstRecipeCard.findViewById<RecipePrice>(R.id.cta_get_price)
        firstCtaGetPrice.bind(firstRecipeId, 4, true)
        val firstCtaSeeDetails = firstRecipeCard.findViewById<RecipeDetailButton>(R.id.cta_see_details)
        // Set click listener for cta_get_price

        firstCtaSeeDetails.bind(firstRecipeId,true)
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

        val secondCtaGetPrice = secondRecipeCard.findViewById<RecipePrice>(R.id.cta_get_price)
        secondCtaGetPrice.bind(secondRecipeId, 4, true)
        val secondCtaSeeDetails = secondRecipeCard.findViewById<RecipeDetailButton>(R.id.cta_see_details)
        secondCtaSeeDetails.bind(secondRecipeId, isExtId = true)



        // Load image with Picasso
        Picasso.get()
            .load(secondImageUrl)
            .into(secondImageView)

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}