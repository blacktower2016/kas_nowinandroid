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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework14

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.google.samples.apps.nowinandroid.MainActivity
import com.google.samples.apps.nowinandroid.ui.homeworks.homework14.screens.MainScreen
import com.google.samples.apps.nowinandroid.ui.homeworks.homework15.screens.SearchScreen
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.common.utilities.getResourceString
import org.junit.Rule
import org.junit.Test
import com.google.samples.apps.nowinandroid.feature.foryou.R as foryouR
import com.google.samples.apps.nowinandroid.feature.search.R as searchR

class MainScreenTest : TestCase(Kaspresso.Builder.withComposeSupport()) {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    val mainScreen = MainScreen(composeTestRule)

    @Test
    fun testMainScreen() {
        run("") {
            with(mainScreen) {
                step("Check Done button is displayed") {
                    perform {
                        doneButton.assertIsDisplayed()
                        doneButton.assertTextContains("Done")
                    }
                }
                step("Check top bar") {
                    step("Check search icon is displayed") {
                        topBarSearchIcon.perform {
                            assertIsDisplayed()
                        }
                    }
                    step("Check three dost button is displayed") {
                        topBarThreeDots.perform {
                            assertIsDisplayed()
                        }
                    }
                    step("Check top bas title") {
                        topBarTitle.perform {
                            assertIsDisplayed()
                            assertTextEquals("Now in Android")
                        }
                    }
                }

                step("Check title") {
                    mainTitle.perform {
                        assertIsDisplayed()
                        assertTextEquals(getResourceString(foryouR.string.feature_foryou_onboarding_guidance_title))
                    }
                }

                step("Check subtitle") {
                    mainSubTitle.perform {
                        assertIsDisplayed()
                        assertTextEquals(getResourceString(foryouR.string.feature_foryou_onboarding_guidance_subtitle))
                    }
                }
            }
        }
    }

    @Test
    fun testSearchScreen() {
        run("Check search screen") {
            step("Open search screen") {
                mainScreen.topBarSearchIcon.perform {
                    assertIsDisplayed()
                    performClick()
                }
            }

            SearchScreen(composeTestRule).perform {
                step("Check button 'Back' is displayed") {
                    buttonBack.assertIsDisplayed()
                }
                step("Check search field is displayed") {
                    searchTextField.assertIsDisplayed()
                }
                step("Check recent searches") {
                    recentSearches.assertIsDisplayed()
                    recentSearches.assertTextEquals(getResourceString(searchR.string.feature_search_recent_searches))
                }
            }
        }
    }
}
