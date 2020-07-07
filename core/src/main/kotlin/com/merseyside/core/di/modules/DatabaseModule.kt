

package com.merseyside.core.di.modules

import android.content.Context
import androidx.room.Room
import com.merseyside.core.db.NewsDatabase
import com.merseyside.core.di.CoreComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Class that contributes to the object graph [CoreComponent].
 *
 * @see Module
 */
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideNewsDatabase(context: Context) =
        Room.databaseBuilder(
            context,
            NewsDatabase::class.java,
            "news-db"
        ).build()


    @Singleton
    @Provides
    fun provideNewsDao(db: NewsDatabase) = db.newsDao()
}
