package com.dehaat.dehaatassignment.dagger.component

import android.app.Application
import androidx.fragment.app.Fragment
import com.dehaat.dehaatassignment.DehaatApplication
import com.dehaat.dehaatassignment.dagger.builder.ActivityBuilder
import com.dehaat.dehaatassignment.dagger.module.AppModule
import com.dehaat.dehaatassignment.dagger.module.DatabaseModule
import com.dehaat.dehaatassignment.dagger.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, NetworkModule::class, DatabaseModule::class, ActivityBuilder::class])
interface AppComponent : AndroidInjector<DehaatApplication>{


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

}

