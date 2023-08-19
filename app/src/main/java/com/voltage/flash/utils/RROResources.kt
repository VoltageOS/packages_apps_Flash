/*
 * SPDX-FileCopyrightText: 2022 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package com.voltage.flash.utils

import android.content.Context

class RROResources private constructor(val context: Context, private val packageName: String) {
    private val resources = context.packageManager.getResourcesForApplication(packageName)

    @Suppress("DiscouragedApi")
    private fun getIdentifier(id: Int) =
        resources.getIdentifier(
            context.resources.getResourceEntryName(id),
            context.resources.getResourceTypeName(id),
            packageName
        )

    fun getBoolean(id: Int): Boolean =
        resources.getBoolean(getIdentifier(id))

    fun getStringArray(id: Int): Array<String> =
        resources.getStringArray(getIdentifier(id))

    companion object {
        fun getAutoGeneratedRROResources(context: Context) =
            listOf(
                "com.voltage.flash.auto_generated_rro_product__",
                "com.voltage.flash.auto_generated_rro_vendor__",
            ).mapNotNull {
                runCatching {
                    RROResources(context, it)
                }.getOrNull()
            }
    }
}
