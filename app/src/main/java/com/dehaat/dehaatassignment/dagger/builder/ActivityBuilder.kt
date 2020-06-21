package com.dehaat.dehaatassignment.dagger.builder

import com.dehaat.dehaatassignment.activity.LoginActivity
import com.dehaat.dehaatassignment.activity.MainActivity
import com.dehaat.dehaatassignment.activity.SplashAcitivy
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [ActivityProviders::class])
    abstract fun bindSplashAcitivy(): SplashAcitivy

    @ContributesAndroidInjector(modules = [ActivityProviders::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ActivityProviders::class])
    abstract fun bindLoginActivity(): LoginActivity

}