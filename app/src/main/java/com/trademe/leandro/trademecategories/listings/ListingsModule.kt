package com.trademe.leandro.trademecategories.listings

import com.trademe.leandro.trademecategories.TradeMeService
import dagger.Module
import dagger.Provides
import io.reactivex.Observable

/**
 * Created by Leandro on 10/11/2017.
 */
@Module
object ListingsModule {
    @JvmStatic
    @Provides
    fun viewModelFactory(
            categoryNumberObservable: Observable<String>,
            service: TradeMeService
    ) = ListingsViewModel.Factory(categoryNumberObservable, service)
}