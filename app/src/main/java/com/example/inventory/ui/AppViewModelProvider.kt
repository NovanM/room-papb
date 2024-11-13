/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.inventory.InventoryApplication
import com.example.inventory.ui.home.HomeViewModel
import com.example.inventory.ui.item.ItemDetailsViewModel
import com.example.inventory.ui.item.ItemEditViewModel
import com.example.inventory.ui.item.ItemEntryViewModel
/**
 * `AppViewModelProvider` menyediakan factory untuk membuat instance `ViewModel`
 * untuk seluruh aplikasi Inventory. Dengan menggunakan `viewModelFactory`,
 * `AppViewModelProvider` menyediakan cara untuk menginisialisasi berbagai `ViewModel`
 * yang digunakan dalam aplikasi.
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer untuk `ItemEditViewModel`, yang membutuhkan SavedStateHandle
        // dan repository item yang diakses dari aplikasi.
        initializer {
            ItemEditViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository
            )
        }
        // Initializer untuk `ItemEntryViewModel`, yang mengakses repository item dari aplikasi.
        initializer {
            ItemEntryViewModel(inventoryApplication().container.itemsRepository)
        }

        // Initializer untuk `ItemDetailsViewModel`, yang juga membutuhkan SavedStateHandle
        // dan repository item.
        initializer {
            ItemDetailsViewModel(
                this.createSavedStateHandle(),
                inventoryApplication().container.itemsRepository
            )
        }

        // Initializer untuk `HomeViewModel`, yang mengakses repository item dari aplikasi.
        initializer {
            HomeViewModel(inventoryApplication().container.itemsRepository)
        }
    }
}

/**
 * Fungsi ekstensi untuk mendapatkan objek [Application] dan mengonversinya menjadi
 * instance dari [InventoryApplication], yang digunakan untuk mengakses container
 * dan dependensi aplikasi lainnya.
 */
fun CreationExtras.inventoryApplication(): InventoryApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as InventoryApplication)
