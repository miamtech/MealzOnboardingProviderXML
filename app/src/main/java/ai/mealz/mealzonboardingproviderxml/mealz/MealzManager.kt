package ai.mealz.mealzonboardingproviderxml.mealz

import android.content.Context
import ai.mealz.core.Mealz
import ai.mealz.core.init.option
import ai.mealz.core.init.sdkRequirement

/**
 * TODO (Step 2): Initialization
 * B. Add supplier key
 * https://miamtech.github.io/mealz-documentation/docs/android/overview/supplierInit
 */

object MealzManager {
    /**
     * TODO (Step 2): Initialization
     * B. Add supplier key
     * https://miamtech.github.io/mealz-documentation/docs/android/overview/supplierInit
     */
    val supplierKey = "ewogICAgICAgICJwcm92aWRlcl9pZCI6ICJtYXJtaXRvbiIKCSJwbGF1c2libGVfZG9tYWluZSI6ICJtaWFtLm1hcm1pdG9uLmFwcCIsCgkibWlhbV9vcmlnaW4iOiAibWFybWl0b24iLAoJIm9yaWdpbiI6ICJtaWFtLm1hcm1pdG9uLmFwcCIsCgkibWlhbV9lbnZpcm9ubWVudCI6ICJVQVQiCn0"
    /**
     * TODO (Step 2): Initialization
     * C. Init the SDK
     * https://miamtech.github.io/mealz-documentation/docs/android/overview/supplierInit
     */
    private var isInitialized = false

    fun initialize(applicationContext: Context) {
        if(isInitialized) return
        Mealz.Core {
            sdkRequirement {
                key = supplierKey
                context = applicationContext
            }
            option { isAnonymousModeEnabled =  true }
        }
        isInitialized = true
    }
}