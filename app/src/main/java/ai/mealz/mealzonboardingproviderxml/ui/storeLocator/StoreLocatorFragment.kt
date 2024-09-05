package ai.mealz.mealzonboardingproviderxml.ui.storeLocator

import ai.mealz.marmiton.config.components.webview.MealzStoreLocatorWebView
import ai.mealz.mealzonboardingproviderxml.R
import ai.mealz.mealzonboardingproviderxml.databinding.FragmentStoreLocatorBinding
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

/**
 * TODO (Step 4): Set Store Selector Redirect
 * B. Create new Fragment file
 * https://miamtech.github.io/mealz-documentation/docs/android/advanced/store-configuration#%23SetStore
 */
class StoreLocatorFragment : DialogFragment() {

    private var _binding: FragmentStoreLocatorBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("JavascriptInterface", "RestrictedApi")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStoreLocatorBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /**
         * TODO (Step 4): Set Store Selector Redirect
         * C. Call Webview from Marmiton Package
         * https://miamtech.github.io/mealz-documentation/docs/android/advanced/store-configuration#%23SetStore
         */
        // Ensure you reference the correct WebView instance
        val myWebView: MealzStoreLocatorWebView = root.findViewById(R.id.store_locator)
        myWebView.urlToLoad = "file:///android_asset/index.html"
        myWebView.onShowChange = {
            dismiss()
        }

        myWebView.onSelectStore = { _ ->
            dismiss()
        }

        // Return the correctly inflated view
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
