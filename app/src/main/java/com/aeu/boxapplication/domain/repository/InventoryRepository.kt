package com.aeu.boxapplication.domain.repository

import com.aeu.boxapplication.core.network.NetworkResult
import com.aeu.boxapplication.domain.model.Inventory
import kotlinx.coroutines.flow.Flow

interface InventoryRepository {
    suspend fun getInventory(page: Int): NetworkResult<List<Inventory>>
    suspend fun allocateInventory(productId: String, quantity: Int): NetworkResult<Inventory>
    suspend fun updateInventory(inventoryId: String, quantity: Int): NetworkResult<Inventory>
    suspend fun trackInventory(productId: String): NetworkResult<Inventory>
    fun getInventoryFromLocal(): Flow<List<Inventory>>
    suspend fun clearCache()
}
