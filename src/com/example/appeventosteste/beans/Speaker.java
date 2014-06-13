package com.example.appeventosteste.beans;

public class Speaker{
	private String photo;
	private String name;
	private String filiation;
	private String title;
	private String resume;
	private String biography;
	private boolean photoIsShareable;
	private boolean nameIsShareable;
	private boolean filiationIsShareable;
	private boolean titleIsShareable;
	private boolean resumeIsShareable;
	private boolean biographyIsShareable;
	
	public boolean isPhotoIsShareable() {
		return photoIsShareable;
	}

	public void setPhotoIsShareable(String photoIsShareable) {
		if(photoIsShareable.equals("true"))
			this.photoIsShareable = true;
		else
			this.photoIsShareable = false;
	}

	public boolean isNameIsShareable() {
		return nameIsShareable;
	}

	public void setNameIsShareable(String nameIsShareable) {
		if(nameIsShareable.equals("true"))
			this.nameIsShareable = true;
		else
			this.nameIsShareable = false;
	}

	public boolean isFiliationIsShareable() {
		return filiationIsShareable;
	}

	public void setFiliationIsShareable(String filiationIsShareable) {
		if(filiationIsShareable.equals("true"))
			this.filiationIsShareable = true;
		else
			this.filiationIsShareable = false;
	}

	public boolean isTitleIsShareable() {
		return titleIsShareable;
	}

	public void setTitleIsShareable(String titleIsShareable) {
		if(titleIsShareable.equals("true"))
			this.titleIsShareable = true;
		else
			this.titleIsShareable = false;
	}

	public boolean isResumeIsShareable() {
		return resumeIsShareable;
	}

	public void setResumeIsShareable(String resumeIsShareable) {
		if(resumeIsShareable.equals("true"))
			this.resumeIsShareable = true;
		else
			this.resumeIsShareable = false;
	}

	public boolean isBiographyIsShareable() {
		return biographyIsShareable;
	}

	public void setBiographyIsShareable(String biographyIsShareable) {
		if(biographyIsShareable.equals("true"))
			this.biographyIsShareable = true;
		else
			this.biographyIsShareable = false;

	}

	public Speaker(){
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFiliation() {
		return filiation;
	}
	public void setFiliation(String filiation) {
		this.filiation = filiation;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}


}
