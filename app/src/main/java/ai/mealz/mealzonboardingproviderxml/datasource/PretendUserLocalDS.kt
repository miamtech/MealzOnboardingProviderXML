package ai.mealz.mealzonboardingproviderxml.datasource

import ai.mealz.mealzonboardingproviderxml.model.PretendUser
import android.content.Context
import android.content.SharedPreferences
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PretendUserLocalDS(context: Context) {
    private val userKey = "com.mealz.PretendUser"
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("PretendUserPrefs", Context.MODE_PRIVATE)

    // Save user to local storage
    fun saveUserToLocalStorage(user: PretendUser) {
        val editor = sharedPreferences.edit()
        val json = Json.encodeToString(user)
        editor.putString(userKey, json)
        editor.apply()
    }

    // Load user from local storage
    fun loadUserFromLocalStorage(): PretendUser? {
        val json = sharedPreferences.getString(userKey, null)
        return if (json != null) {
            Json.decodeFromString(json)
        } else {
            null
        }
    }

    // Delete user from local storage
    fun deleteUserFromLocalStorage() {
        val editor = sharedPreferences.edit()
        editor.remove(userKey)
        editor.apply()
    }
}

