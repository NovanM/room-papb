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

package com.example.inventory.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity data class represents a single row in the database.
 * * - Memberikan identitas bahwa kelas ini adalah entitas dalam database Room.
 *  * - Parameter `tableName = "items"` menunjukkan bahwa tabel ini diberi nama `items`.
 *  *
 *  * Kolom dan Primary Key:
 *  * - `id`: Kolom ini digunakan sebagai primary key dalam tabel. Anotasi `@PrimaryKey`
 *  *   dengan `autoGenerate = true` berarti Room akan secara otomatis men-generate nilai unik
 *  *   untuk kolom ini, yang berguna saat data baru disimpan.
 *  * - `name`: Nama dari item, ditetapkan sebagai kolom string. Tidak ada anotasi khusus,
 *  *   yang menunjukkan ini sebagai kolom biasa.
 *  * - `price`: Menyimpan harga item dalam bentuk `Double`. Kolom ini menyimpan informasi
 *  *   numerik yang terkait dengan harga setiap item.
 *  * - `quantity`: Menyimpan jumlah item yang tersedia, dalam bentuk `Int`. Kolom ini dapat
 *  *   digunakan untuk melacak stok atau jumlah barang dalam inventaris.
 */
@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int
)
