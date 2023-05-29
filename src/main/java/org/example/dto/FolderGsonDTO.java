package org.example.dto;

import com.google.gson.annotations.SerializedName;

public class FolderGsonDTO{

	@SerializedName("createdAt")
	private long createdAt;

	@SerializedName("removed")
	private boolean removed;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("userId")
	private String userId;

	@SerializedName("folderType")
	private String folderType;

	@SerializedName("updatedAt")
	private long updatedAt;

	public long getCreatedAt(){
		return createdAt;
	}

	public boolean isRemoved(){
		return removed;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getUserId(){
		return userId;
	}

	public String getFolderType(){
		return folderType;
	}

	public long getUpdatedAt(){
		return updatedAt;
	}
}