package com.nativelydigital.canva.round1;

/** Identifies the caller of a service method. */
class AuthContext {
  public final String userId;
  
  public AuthContext(String userId) {
      this.userId = userId;
  }
}