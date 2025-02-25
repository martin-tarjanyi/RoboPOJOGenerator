package com.robohorse.robopojogenerator.view

import com.robohorse.robopojogenerator.view.AdditionalPropertiesVM.*
import com.robohorse.robopojogenerator.view.FrameworkVW.*
import com.robohorse.robopojogenerator.view.LanguageVM.Java
import com.robohorse.robopojogenerator.view.LanguageVM.Kotlin
import com.robohorse.robopojogenerator.view.SourceVM.Json
import com.robohorse.robopojogenerator.view.SourceVM.JsonSchema

class PropertiesFactory {

    fun createControls(): ControlsModel {
        val result = ControlsModel(
            sources = listOf(
                Json(languages = createJsonLanguages()),
                JsonSchema(languages = createJsonLanguages())
            )
        )
        result.selectedSource = result.sources[0]
        result.selectedSource?.let { source ->
            source.selectedLanguage = source.languages[0]
            source.selectedLanguage?.let { language ->
                language.selectedFramework = language.frameworks[0]
            }
        }
        return result
    }

    private fun createJsonLanguages() = listOf(
        Java(
            frameworks = listOf(
                None(
                    properties = listOf(
                        UseJavaPrimitives(selected = true),
                        UseSetters(),
                        UseGetters(selected = true),
                        UseToString()
                    )
                ),
                NoneLombok(
                    properties = listOf(
                        UseJavaPrimitives(selected = true),
                        UseLombokValue()
                    )
                ),
                Gson(
                    properties = listOf(
                        UseJavaPrimitives(selected = true),
                        UseSetters(),
                        UseGetters(selected = true),
                        UseToString()
                    )
                ),
                Jackson(
                    properties = listOf(
                        UseJavaPrimitives(selected = true),
                        UseSetters(),
                        UseGetters(selected = true),
                        UseToString()
                    )
                ),
                LoganSquare(
                    properties = listOf(
                        UseJavaPrimitives(selected = true),
                        UseSetters(),
                        UseGetters(selected = true),
                        UseToString()
                    )
                ),
                Moshi(
                    properties = listOf(
                        UseJavaPrimitives(selected = true),
                        UseSetters(),
                        UseGetters(selected = true),
                        UseToString()
                    )
                ),
                FastJson(
                    properties = listOf(
                        UseJavaPrimitives(selected = true),
                        UseSetters(),
                        UseGetters(selected = true),
                        UseToString()
                    )
                ),
                AutoValue()
            )
        ),
        Kotlin(
            frameworks = listOf(
                None(
                    properties = listOf(
                        UseKotlinSingleDataClass(selected = true),
                        UseKotlinNullableFields(selected = true),
                        UseKotlinParcelable()
                    )
                ),
                Gson(
                    properties = listOf(
                        UseKotlinSingleDataClass(selected = true),
                        UseKotlinNullableFields(selected = true),
                        UseKotlinParcelable()
                    )
                ),
                Jackson(
                    properties = listOf(
                        UseKotlinSingleDataClass(selected = true),
                        UseKotlinNullableFields(selected = true),
                        UseKotlinParcelable()
                    )
                ),
                LoganSquare(
                    properties = listOf(
                        UseKotlinSingleDataClass(selected = true),
                        UseKotlinNullableFields(selected = true),
                        UseKotlinParcelable()
                    )
                ),
                Moshi(
                    properties = listOf(
                        UseKotlinSingleDataClass(selected = true),
                        UseKotlinNullableFields(selected = true),
                        UseKotlinParcelable()
                    )
                ),
                FastJson(
                    properties = listOf(
                        UseKotlinSingleDataClass(selected = true),
                        UseKotlinNullableFields(selected = true),
                        UseKotlinParcelable()
                    )
                )
            )
        )
    )
}
