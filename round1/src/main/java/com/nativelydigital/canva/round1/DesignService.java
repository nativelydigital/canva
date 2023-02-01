package com.nativelydigital.canva.round1;

interface DesignService {
  /** Creates a design and returns the design id. */
  String createDesign(AuthContext ctx, String designContent);

  /** Returns the design content, if the user has access to the design. */
  String getDesign(AuthContext ctx, String designId);
}
