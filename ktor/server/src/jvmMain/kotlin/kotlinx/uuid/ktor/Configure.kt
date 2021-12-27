/*
 * Copyright 2020-2020 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package kotlinx.uuid.ktor

import io.ktor.util.converters.*
import kotlinx.uuid.*

/**
 * Installs kotlinx-uuid [UUID] data converter to [DataConversion] feature.
 */
public fun DataConversion.Configuration.uuid() {
    convert(UUID::class, UUIDConversionService)
}

/**
 * Installs kotlinx-uuid [UUID] data converter to [DataConversion] feature.
 */
public fun io.ktor.features.DataConversion.Configuration.uuid() {
    convert<UUID> {
        encode { toValuesImpl(it) }
        decode { values, type -> fromValuesImpl(values, type) }
    }
}
