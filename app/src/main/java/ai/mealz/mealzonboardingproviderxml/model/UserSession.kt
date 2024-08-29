package ai.mealz.mealzonboardingproviderxml.model

import ai.mealz.mealzonboardingproviderxml.repository.PretendUserRepository
import android.content.Context

//class UserSession(context: Context) {
//    public val sharedInstance = UserSession(context)
//
//    var user: PretendUser? = null
//
//    val userRepository = PretendUserRepository(context)
//
//    init {
//        userRepository.getStoredUser()?.let { setUser(it) }
//    }
//
//    fun setUser(user: PretendUser?) {
//        this.user = user
//    }
//
//    fun disconnectUser() {
//        setUser(null)
//        userRepository.deleteStoredUser()
//    }
//}