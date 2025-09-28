package com.example.myorderhistoryanddelivery.order.ui.components


import androidx.compose.foundation.lazy.LazyListState
import com.example.myorderhistoryanddelivery.order.domain.model.OrderHistoryStatus
import com.example.myorderhistoryanddelivery.order.domain.model.OrdersHistoryFilter
import com.example.myorderhistoryanddelivery.order.ui.viewmodel.OrderHistoryViewModel

data class OrdersHistoryUiConfig(
    val showFilterDialog: Boolean,
    val showSortDialog: Boolean,
    val menuOpen: Boolean,
    val filter: OrdersHistoryFilter,
    val onCloseMenu: () -> Unit,
    val onOpenFilter: () -> Unit,
    val onOpenSort: () -> Unit,
    val onApplyFilter: (Set<OrderHistoryStatus>) -> Unit,
    val onApplySort: (Boolean) -> Unit,
    val onExportPdf: () -> Unit,
    val onDismissFilter: () -> Unit,
    val onDismissSort: () -> Unit,
    val onLoadMore: () -> Unit,
)

data class OrdersHistoryEffectsConfig(
    val vm: OrderHistoryViewModel,
    val token: String,
    val ordersSize: Int,
    val listState: LazyListState,
    val registerOpenMenu: ((() -> Unit) -> Unit)?,
    val openMenu: () -> Unit,
)
