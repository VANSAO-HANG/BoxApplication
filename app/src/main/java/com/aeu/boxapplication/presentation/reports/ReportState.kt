package com.aeu.boxapplication.presentation.reports

data class ReportState(
    val isLoading: Boolean = false,
    val churnRate: Double? = null,
    val revenue: Double? = null,
    val activeSubscribers: Int? = null,
    val analyticsData: Map<String, Any> = emptyMap(),
    val error: String? = null
)

sealed class ReportEvent {
    data class LoadChurnRate(val startDate: String, val endDate: String) : ReportEvent()
    data class LoadRevenue(val startDate: String, val endDate: String) : ReportEvent()
    object LoadActiveSubscribers : ReportEvent()
    data class LoadAnalytics(val startDate: String, val endDate: String) : ReportEvent()
    object ClearError : ReportEvent()
}
