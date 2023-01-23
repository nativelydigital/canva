package com.nativelydigital.canva.round1;

import java.util.HashMap;
import java.util.Map;

class DesignServiceImpl implements DesignService {
	
	private static Map<String,Design> designs = new HashMap<>();
	
	// A user should only be able to access the designs that they have created.
	
	
  /** Creates a design and returns the design id. */
  public String createDesign(AuthContext ctx, String designContent) {
	  // Assume authContext is not null
	  String newDesignId = Design.createDesignId();
	  
	  designs.put(newDesignId, new Design(newDesignId, designContent, ctx.userId));
	  
	  return newDesignId;
  }

  /** Returns the design content, if the user has access to the design. */
  public String getDesign(AuthContext ctx, String designId) {
	  Design design = designs.getOrDefault(designId, null);
	  
	  if (design == null) {
		  return null;
	  }
	  
	  if (! (ctx.userId != null && ctx.userId.equals(design.createdByUserId() ))) {
		  return null;
	  }

  	  return design.designContent();
  }
}
