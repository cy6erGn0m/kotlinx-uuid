/*
 * Copyright 2020-2020 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package kotlinx.uuid.ktor

import io.ktor.util.converters.*
import io.ktor.util.reflect.*
import kotlinx.uuid.*

/**
 * ktor [ConversionService] implementation that does conversion for [UUID]
 */
public object UUIDConversionService : ConversionService {
    override fun fromValues(values: List<String>, type: TypeInfo): Any? = fromValuesImpl(values, type.reifiedType)

    override fun toValues(value: Any?): List<String> = toValuesImpl(value)
}
