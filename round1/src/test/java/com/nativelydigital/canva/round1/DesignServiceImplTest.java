package com.nativelydigital.canva.round1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DesignServiceImplTest {
	
	private DesignServiceImpl designService; 
	
	@BeforeEach public void before() {
		this.designService = new DesignServiceImpl();
	}
	
	@Test
	public void createDesign_givenAValidDesign_returrnsDesignId() {
		final String validDesignContent = "Foo";
		
		String designId = designService.createDesign(authContext(USER_1), validDesignContent);
		
		assertNotNull(designId);
		assertFalse(designId.isBlank());
	}
	
	@Test
	public void getDesign_givenAnExistingAndOwnedDesign_returrnsDesignContent() {
		final String validDesignContent = "Foo";
		final String userId = USER_1;
		
		final String designId = designService.createDesign(authContext(userId), validDesignContent);
		
		String actualDesignContent = designService.getDesign(authContext(userId), designId);
		
		assertEquals(validDesignContent, actualDesignContent);
	}
	
	@Test
	public void getDesign_givenAnNonExistingDesign_returnsNull() {
		String actualDesignContent = designService.getDesign(authContext(USER_1), "Foo");
		
		assertNull(actualDesignContent);
	}
	
	@Test
	public void getDesign_givenAnExistingAndUnownedDesign_returnsNull() {
		final String validDesignContent = "Foo";
		final String creatingUserId = USER_1;
		final String gettingUserId = USER_2;
		
		final String designId = designService.createDesign(authContext(creatingUserId), validDesignContent);
		
		String actualDesignContent = designService.getDesign(authContext(gettingUserId), designId);
		
		assertNull(actualDesignContent);
	}
	
	// TODO: Add tests for findDesign
	
	private static AuthContext authContext(String userId) {
		return new AuthContext(userId);
	}
	
	private static String USER_1 = "User1";
	private static String USER_2 = "User2";
}
