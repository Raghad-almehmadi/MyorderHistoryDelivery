package com.ntg.lmd.network.queue

import android.content.Context
import androidx.room.Room
import com.ntg.lmd.network.queue.storage.AppDatabase
import com.ntg.network.connectivity.NetworkMonitor

object ServiceLocator {
    private var db: AppDatabase? = null

    private fun database(ctx: Context): AppDatabase =
        db ?: Room
            .databaseBuilder(
                ctx.applicationContext,
                AppDatabase::class.java,
                "app.db",
            ).fallbackToDestructiveMigration()
            .build()
            .also { db = it }

//    fun requestRepository(ctx: Context): RequestRepository {
//        val dao = database(ctx).requestDao()
//        //val retrofit = RetrofitProviderTest.retrofit
//        val network = NetworkMonitor(ctx)
//       // return RequestRepository(dao, retrofit, network)
//    }
}
