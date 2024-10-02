package ai.mealz.mealzonboardingproviderxml

import ai.mealz.core.Mealz
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import ai.mealz.mealzonboardingproviderxml.databinding.ActivityMainBinding
import ai.mealz.mealzonboardingproviderxml.mealz.MealzManager
import ai.mealz.mealzonboardingproviderxml.ui.storeLocator.StoreLocatorFragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * TODO (Step 2): Initialization
         * D. Call the init method of MealzManager
         * https://miamtech.github.io/mealz-documentation/docs/android/overview/supplierInit
         */
        MealzManager.initialize(this)
        /**
         * TODO (Step 4): Set Store Selector Redirect
         * D. Update MealzManager to set redirection
         * https://miamtech.github.io/mealz-documentation/docs/android/advanced/store-configuration#%23SetStore
         */
        Mealz.user.setStoreLocatorRedirection {
            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            val newFragment = StoreLocatorFragment()
            newFragment.show(ft, "storeSelectorDialog")
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_basket
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}