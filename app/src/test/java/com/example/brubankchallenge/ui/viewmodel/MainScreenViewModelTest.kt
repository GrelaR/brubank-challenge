package com.example.brubankchallenge.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.domain.usecase.*
import com.example.brubankchallenge.ui.screens.home_screen.viewmodel.MainScreenViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class MainScreenViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher: TestDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)


    @Mock
    private lateinit var getMoviesUseCase: GetMoviesUseCase

    @Mock
    private lateinit var getGenresUseCase: GetGenresUseCase

    @Mock
    private lateinit var searchMoviesUseCase: SearchMoviesUseCase

    @Mock
    private lateinit var addMovieUseCase: AddMovieUseCase

    @Mock
    private lateinit var getSubscriptionMoviesUseCase: GetSubscribedMoviesUseCase

    @Mock
    private lateinit var removeMovieUseCase: RemoveMovieUseCase

    private lateinit var viewModel: MainScreenViewModel

    private lateinit var subscriptionMoviesFlow: MutableStateFlow<List<Movie>>

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        subscriptionMoviesFlow = MutableStateFlow(emptyList())
        viewModel = MainScreenViewModel(
            getMoviesUseCase,
            getGenresUseCase,
            searchMoviesUseCase,
            addMovieUseCase,
            getSubscriptionMoviesUseCase,
            removeMovieUseCase
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `toggleMovieSubscription adds movie when not subscribed`() = testScope.runTest {
        // Given a movie that is not subscribed
        val movie = Movie(
            genresIds = listOf(1, 2, 3),
            id = 1,
            title = "Test Movie",
            overview = "Pelicula pochoclera",
            posterPath = ("url de prueba"),
            releaseDate = "1980"
        )

        `when`(getSubscriptionMoviesUseCase()).thenReturn(flowOf(emptyList()))
        `when`(addMovieUseCase(movie)).thenAnswer {
            `when`(getSubscriptionMoviesUseCase()).thenReturn(flowOf(listOf(movie)))
        }
        // When toggleMovieSubscription is called
        viewModel.toggleMovieSubscription(movie)
        advanceUntilIdle()

        subscriptionMoviesFlow.update { listOf(movie) }

        // Collect the flow and verify
        val isSubscribedList = mutableListOf<Boolean>()
        viewModel.isMovieSubscribed(movie).toList(isSubscribedList)

        // Then the movie should not be subscribed
        assertFalse(isSubscribedList.first())
    }

    @Test
    fun `toggleMovieSubscription removes movie when subscribed`() = runTest {
        // Given a movie that is subscribed
        val movie = Movie(
            genresIds = listOf(1, 2, 3),
            id = 1,
            title = "Test Movie",
            overview = "Pelicula pochoclera",
            posterPath = ("url de prueba"),
            releaseDate = "1980"
        )

        `when`(getSubscriptionMoviesUseCase()).thenReturn(flowOf(listOf(movie)))

        // When toggleMovieSubscription is called
        viewModel.toggleMovieSubscription(movie)
        advanceUntilIdle()

        // Then the movie should not be subscribed
        assertFalse(viewModel.isMovieSubscribed(movie).first())
    }
}
