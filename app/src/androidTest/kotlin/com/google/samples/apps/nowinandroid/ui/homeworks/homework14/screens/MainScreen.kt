/*
 * Copyright 2025 The Android Open Source Project
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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework14.screens

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.kaspersky.components.composesupport.core.KNode
import io.github.kakaocup.compose.node.element.ComposeScreen

class MainScreen(semanticProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<MainScreen>(semanticProvider) {

    val doneButton = KNode(semanticProvider) {
        hasText("Done")
    }

    val topBarSearchIcon = KNode(semanticProvider) {
        hasTestTag("searchIcon")
    }

    val topBarTitle = KNode(semanticProvider) {
        hasTestTag("topBarText")
    }

    val topBarThreeDots = KNode(semanticProvider) {
        hasTestTag("threeDotsAction")
    }

    val mainTitle = KNode(semanticProvider) {
        hasTestTag("mainTitleText")
    }

    val mainSubTitle = KNode(semanticProvider) {
        hasTestTag("mainSubtitleText")
    }
}
