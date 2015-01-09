package com.video.entity;

import java.util.Set;

/**
 * VideoExProperty entity. @author MyEclipse Persistence Tools
 */
public class VideoExProperty extends AbstractVideoExProperty implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public VideoExProperty() {
	}

	/** full constructor */
	public VideoExProperty(String propertyName, String propertyDesc,
			Set videoExValues) {
		super(propertyName, propertyDesc, videoExValues);
	}

}
