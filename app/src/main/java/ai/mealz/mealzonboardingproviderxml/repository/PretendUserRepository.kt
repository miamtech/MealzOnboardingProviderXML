package ai.mealz.mealzonboardingproviderxml.repository

import ai.mealz.mealzonboardingproviderxml.datasource.PretendUserLocalDS
import ai.mealz.mealzonboardingproviderxml.model.PretendUser
import android.content.Context

class PretendUserRepository(context: Context) {
    private val localDataSource = PretendUserLocalDS(context)

    fun signInUser(user: PretendUser) {
        // make api req
        localDataSource.saveUserToLocalStorage(user)
    }

    fun getStoredUser(): PretendUser? {
        return localDataSource.loadUserFromLocalStorage()
    }

    fun deleteStoredUser() {
        localDataSource.deleteUserFromLocalStorage()
    }
}