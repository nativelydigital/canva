package com.nativelydigital.canva.round1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class DesignServiceImpl implements DesignService {

	private static Map<String, Design> designsByDesignId = new HashMap<>();
	private static Map<String, List<Design>> designsByUserId = new HashMap<>();

	
	// A user should only be able to access the designs that they have created.

	/** Creates a design and returns the design id. */
	@Override
	public String createDesign(AuthContext ctx, String designContent) {
		// Assume authContext is not null
		String newDesignId = Design.createDesignId();

		Design design = new Design(newDesignId, designContent, ctx.userId);

		designsByDesignId.put(newDesignId, design);

		designsByUserId.compute(ctx.userId, (userId, existingList) -> {
			List<Design> list = existingList != null ? existingList : new ArrayList<>();
			list.add(design);
			return list;
		});
		
		return newDesignId;
	}

	/** Returns the design content, if the user has access to the design. */
	@Override
	public String getDesign(AuthContext ctx, String designId) {
		Design design = designsByDesignId.getOrDefault(designId, null);

		if (design == null) {
			return null;
		}

		if (!(ctx.userId != null && ctx.userId.equals(design.createdByUserId()))) {
			return null;
		}

		return design.designContent();
	}

	@Override
	public List<String> findDesigns(AuthContext ctx) {
		List<Design> designs = designsByUserId.getOrDefault(ctx.userId, List.of());

		if (designs == null) {
			System.out.printf("Warning: designsByUserId for user ID '%s' had null list\n", ctx.userId);
			return List.of();
		}
		
		// Could add an auth sanity check
		
		return designs.stream().map(d -> d.designId()).collect(Collectors.toList());
	}
}
