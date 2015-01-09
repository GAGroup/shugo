package com.video.entity;

/**
 * VideoExValue entity. @author MyEclipse Persistence Tools
 */
public class VideoExValue extends AbstractVideoExValue implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public VideoExValue() {
	}

	/** full constructor */
	public VideoExValue(VideoInfo videoInfo, VideoExProperty videoExProperty,
			String value) {
		super(videoInfo, videoExProperty, value);
	}

}
