package com.geekbrains.tests

import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.view.details.ViewDetailsContract
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class DetailsPresenterTest {
    private lateinit var presenter: DetailsPresenter

    @Mock
    private lateinit var viewContract: ViewDetailsContract

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        presenter = DetailsPresenter(viewContract)
        presenter.setCounter(0)
    }

    @Test
    fun setCount_onIncrement_Test() {
        presenter.onIncrement()
        verify(viewContract, times(1)).setCount(1)
    }

    @Test
    fun setCount_onDecrement_Test() {
        presenter.onDecrement()
        verify(viewContract, times(1)).setCount(-1)
    }

    @Test
    fun onAttachView_onDetachView_Test() {
        presenter.onAttachView()
        assertNotNull(presenter.currentView)
        presenter.onDetachView()
        assertNull(presenter.currentView)
    }
}