package com.example.brubankchallenge.ui.screens.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.brubankchallenge.R
import com.example.brubankchallenge.ui.screens.home_screen.viewmodel.MainScreenViewModel

@Composable
fun SearchTopBar(
    mainScreenViewModel: MainScreenViewModel = hiltViewModel()
) {
    val searchQuery by mainScreenViewModel.searchQuery.collectAsState()
    var isFocused by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(8.dp)
    ) {
        if (isFocused) {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .height(32.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFF1B1B1B))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = stringResource(R.string.search),
                            tint = Color(0xFF818181),
                            modifier = Modifier.padding(
                                start = 2.dp,
                                end = 2.dp,
                                bottom = 4.dp,
                                top = 4.dp
                            )
                        )

                        BasicTextField(
                            value = searchQuery,
                            onValueChange = { mainScreenViewModel.onSearchQueryChanged(it) },
                            textStyle = TextStyle(
                                color = Color.White,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Start
                            ),
                            modifier = Modifier
                                .focusRequester(focusRequester),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.Done,
                                keyboardType = KeyboardType.Text
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    focusManager.clearFocus()
                                    keyboardController?.hide()
                                }
                            ),
                            singleLine = true)

                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = stringResource(R.string.clear),
                            tint = Color.White,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .clickable {
                                    mainScreenViewModel.onSearchQueryChanged("")
                                }
                        )
                    }
                }
                Text(
                    text = stringResource(R.string.cancel),
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(start = 4.dp, end = 4.dp, bottom = 4.dp, top = 4.dp)
                        .clickable {
                            mainScreenViewModel.onSearchQueryChanged("")
                            focusManager.clearFocus()
                            keyboardController?.hide()
                            isFocused = false
                        }
                )
            }
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
                keyboardController?.show()
            }
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 2.dp)
                    .clickable { isFocused = true }
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(R.string.search),
                        tint = Color.White,
                        modifier = Modifier
                            .padding(start = 16.dp, end = 8.dp)
                            .align(Alignment.CenterStart)
                    )
                    Text(
                        text = stringResource(R.string.tv_show_reminder),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

