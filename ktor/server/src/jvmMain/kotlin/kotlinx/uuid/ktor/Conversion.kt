/*
 * Copyright 2020-2021 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package kotlinx.uuid.ktor

import io.ktor.util.converters.*
import kotlinx.uuid.*
import java.lang.reflect.*

internal fun fromValuesImpl(values: List<String>, type: Type): Any? {
    if (type == UUID::class.java) {
        return when (values.size) {
            0 -> null
            1 -> fromValue(values[0])
            else -> conversionFailed("Multiple UUID values can't be converted to a single UUID")
        }
    }

    conversionFailed("Type $type is not supported by this ConversionService")
}

private fun fromValue(value: String): UUID = try {
    UUID(value)
} catch (cause: Throwable) {
    conversionFailed(cause.message ?: "Failed to convert UUID: $cause")
}

internal fun toValuesImpl(value: Any?): List<String> {
    return when (value) {
        is UUID -> listOf(value.toString())
        null -> emptyList()
        else -> conversionFailed("Value $value is not supported by UUIDConversionService")
    }
}

private fun conversionFailed(message: String): Nothing =
    throw DataConversionException(message)
