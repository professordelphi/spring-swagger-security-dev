package com.sb.estudo.sbestudo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class HomeControllerTest {

	@InjectMocks
	public HomeController home;

	@Mock
	File file;

	@Test(expected = Exception.class)
	public void moveFileOriginToDestinyTest() throws IOException {

		Boolean retornado = this.home.moveFileOriginToDestiny(file.getName(), this.home.getDestino());

		when(this.home.moveFileOriginToDestiny(file.getName(), this.home.getDestino())).thenReturn(true);
		assertEquals(true, retornado);
		assertTrue(retornado);
	}

	
	@Test(expected = Exception.class)
	public void moveFileOriginToDestinyTestNull() throws IOException {

		Boolean retornado = this.home.moveFileOriginToDestiny(null, this.home.getDestino());

		when(this.home.moveFileOriginToDestiny(null, this.home.getDestino())).thenReturn(false);
		assertEquals(false, retornado);

	}


}
//criar get´s  no MoveFile class
//criar o teste MoveFileTest