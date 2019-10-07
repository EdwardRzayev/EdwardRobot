package com.miemdynamics.gnurobot

import android.app.Application
import com.miemdynamics.gnurobot.data.db.ServoDatabase
import com.miemdynamics.gnurobot.data.network.*
import com.miemdynamics.gnurobot.data.repository.ServoRepository
import com.miemdynamics.gnurobot.data.repository.ServoRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class ControlApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ControlApplication))

        bind() from singleton { ServoDatabase(instance()) }
        bind() from singleton { instance<ServoDatabase>().servoDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { FakeServoApiService(instance()) }
        bind<ServoNetworkDataSource>() with singleton { ServoNetworkDataSourceImpl(instance()) }
        bind<ServoRepository>() with singleton { ServoRepositoryImpl(instance(), instance()) }
    }
}