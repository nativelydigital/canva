package com.nativelydigital.canva.round1;

import java.util.UUID;

record Design(String designId, String designContent, String createdByUserId) {
	
	  public static String createDesignId() {
			 return UUID.randomUUID().toString();
	  }
}
