package com.codelamps.newsapp.domain.usecase

import com.codelamps.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager : LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}