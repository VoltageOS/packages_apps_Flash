/*
 * SPDX-FileCopyrightText: 2022 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package com.voltage.flash.utils

import com.voltage.flash.ext.*

enum class GridMode {
    OFF,
    ON_3,
    ON_4,
    ON_GOLDENRATIO;

    /**
     * Get the next mode.
     */
    fun next() = values().next(this)
}
