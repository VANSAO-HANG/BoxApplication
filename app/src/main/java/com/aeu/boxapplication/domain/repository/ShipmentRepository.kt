package com.aeu.boxapplication.domain.repository

import com.aeu.boxapplication.core.network.NetworkResult
import com.aeu.boxapplication.domain.model.Shipment
import kotlinx.coroutines.flow.Flow

interface ShipmentRepository {
    suspend fun getShipments(page: Int): NetworkResult<List<Shipment>>
    suspend fun getShipment(shipmentId: String): NetworkResult<Shipment>
    suspend fun generateShipmentManifest(): NetworkResult<Shipment>
    suspend fun updateShipmentStatus(shipmentId: String, status: String): NetworkResult<Shipment>
    suspend fun trackShipment(trackingNumber: String): NetworkResult<Shipment>
    fun getShipmentsFromLocal(): Flow<List<Shipment>>
    suspend fun clearCache()
}
